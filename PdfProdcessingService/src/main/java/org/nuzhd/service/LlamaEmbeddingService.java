package org.nuzhd.service;

import org.nuzhd.dto.BatchEmbedRequestDto;
import org.nuzhd.dto.SingleEmbedRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LlamaEmbeddingService {

    private final RestTemplate restTemplate;

    @Value("${embedder.root-uri}")
    private String llamaUri;

    public LlamaEmbeddingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Double> getSingleEmbedding(String text) {
        SingleEmbedRequestDto requestDto = new SingleEmbedRequestDto(text, true, false);

        HttpEntity<SingleEmbedRequestDto> entity = new HttpEntity<>(requestDto);

        String uri = "%s/%s".formatted(llamaUri, "embed");
        ResponseEntity<List<List<Double>>> response = restTemplate.exchange(uri, HttpMethod.POST, entity, (Class<List<List<Double>>>) (Class<?>) List.class);

        List<List<Double>> vector = response.getBody();

        return vector.get(0);
    }

    public List<List<Double>> getBatchEmbedding(String[] texts) {
        BatchEmbedRequestDto batchEmbedRequestDto = new BatchEmbedRequestDto(texts, true, false);

        HttpEntity<BatchEmbedRequestDto> entity = new HttpEntity<>(batchEmbedRequestDto);

        String uri = "%s/%s".formatted(llamaUri, "embed");
        ResponseEntity<List<List<Double>>> response = restTemplate.exchange(uri, HttpMethod.POST, entity, (Class<List<List<Double>>>) (Class<?>) List.class);

        return response.getBody();
    }
}
