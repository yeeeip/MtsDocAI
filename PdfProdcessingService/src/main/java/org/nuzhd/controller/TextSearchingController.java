package org.nuzhd.controller;

import org.nuzhd.service.PdfDocService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/search")
public class TextSearchingController {

    private final PdfDocService pdfDocService;

    public TextSearchingController(PdfDocService pdfDocService) {
        this.pdfDocService = pdfDocService;
    }

    @GetMapping
    public ResponseEntity<String[]> getSimilarTexts(@RequestParam("q") String query) {
        return ResponseEntity.ok(pdfDocService.getSimilarTexts(query));
    }

}
