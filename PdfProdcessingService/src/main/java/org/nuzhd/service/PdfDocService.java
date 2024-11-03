package org.nuzhd.service;

import org.nuzhd.model.PdfDoc;
import org.nuzhd.repo.PdfDocRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PdfDocService {

    private final PdfDocRepository pdfDocRepository;
    private final LlamaEmbeddingService llamaEmbeddingService;

    public PdfDocService(PdfDocRepository pdfDocRepository, LlamaEmbeddingService llamaEmbeddingService) {
        this.pdfDocRepository = pdfDocRepository;
        this.llamaEmbeddingService = llamaEmbeddingService;
    }

    private PdfDoc save(PdfDoc pdfDoc) {
        return pdfDocRepository.save(pdfDoc);
    }

    public PdfDoc vectorizeAndSave(String text) {
        List<Double> vector = llamaEmbeddingService.getSingleEmbedding(text);

        PdfDoc doc = new PdfDoc(text, vector);
        return save(doc);
    }

    public String[] getSimilarTexts(String query) {
        List<Double> vector = llamaEmbeddingService.getSingleEmbedding(query);

        float[] floats = new float[vector.size()];

        for (int i = 0; i < floats.length; i++) {
            floats[i] = vector.get(0).floatValue();
        }

        return pdfDocRepository.getSimilarTextsByQuery(floats);
    }

    public List<UUID> saveBatch(String[] texts) {
        List<List<Double>> vectors = llamaEmbeddingService.getBatchEmbedding(texts);

        List<PdfDoc> docsToSave = new ArrayList<>();
        for (int i = 0; i < texts.length; i++) {
            List<Double> vector = vectors.get(i);

            PdfDoc doc = new PdfDoc(texts[i], vector);
            docsToSave.add(doc);
        }

        List<UUID> ids = pdfDocRepository.saveAll(docsToSave)
                .stream()
                .map(PdfDoc::getId)
                .toList();

        return ids;
    }


}
