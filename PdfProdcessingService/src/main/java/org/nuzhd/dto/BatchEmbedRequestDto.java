package org.nuzhd.dto;

public record BatchEmbedRequestDto(String[] inputs, Boolean normalize, Boolean truncate) {
}
