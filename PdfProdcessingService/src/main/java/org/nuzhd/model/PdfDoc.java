package org.nuzhd.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "docs")
public class PdfDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String text;
    private List<Double> embedding;

    public PdfDoc() {
    }

    public PdfDoc(String text, List<Double> embedding) {
        this.text = text;
        this.embedding = embedding;
    }

    public PdfDoc(UUID id, String text, List<Double> embedding) {
        this.id = id;
        this.text = text;
        this.embedding = embedding;
    }

    public UUID getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public List<Double> getEmbedding() {
        return embedding;
    }
}
