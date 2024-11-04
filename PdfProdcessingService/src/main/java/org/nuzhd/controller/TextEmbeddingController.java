package org.nuzhd.controller;

import org.nuzhd.model.PdfDoc;
import org.nuzhd.model.TextBatchRequest;
import org.nuzhd.model.TextRequest;
import org.nuzhd.service.PdfDocService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/embed")
public class TextEmbeddingController {

    private final PdfDocService pdfDocService;

    public TextEmbeddingController(PdfDocService pdfDocService) {
        this.pdfDocService = pdfDocService;
    }

    @PostMapping("/single")
    public ResponseEntity<PdfDoc> embedTexts(@RequestBody TextRequest textRequest) {
        PdfDoc doc = pdfDocService.vectorizeAndSave(textRequest.text());

        return ResponseEntity.ok(doc);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<UUID>> embedTexts(TextBatchRequest textBatchRequest) {
        List<UUID> ids = pdfDocService.saveBatch(textBatchRequest.texts());

        return ResponseEntity.ok(ids);
    }

}
