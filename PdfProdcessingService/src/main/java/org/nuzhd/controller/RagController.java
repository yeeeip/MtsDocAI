package org.nuzhd.controller;

import org.nuzhd.model.TextRequest;
import org.nuzhd.service.LlamaPromptService;
import org.nuzhd.service.PdfDocService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ask")
public class RagController {

    private final PdfDocService pdfDocService;
    private final LlamaPromptService promptService;

    public RagController(PdfDocService pdfDocService, LlamaPromptService promptService) {
        this.pdfDocService = pdfDocService;
        this.promptService = promptService;
    }

    @PostMapping
    public ResponseEntity<String> askLlama(@RequestBody TextRequest textRequest) {
        String[] similarTexts = pdfDocService.getSimilarTexts(textRequest.text());

        String response = promptService.sendPrompt(textRequest.text(), similarTexts[0]);
        return ResponseEntity.ok(response);
    }

}
