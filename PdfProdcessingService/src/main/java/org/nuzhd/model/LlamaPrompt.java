package org.nuzhd.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LlamaPrompt {

    String prompt;
    @JsonProperty("system_prompt")
    String systemPrompt;
    double temperature;
    @JsonProperty("apply_chat_template")
    boolean applyChatTemplate;
    @JsonProperty("max_tokens")
    int maxTokens;
    @JsonProperty("min_tokens")
    int minTokens;
    int n;
    @JsonProperty("best_of")
    int bestOf;
    @JsonProperty("skip_special_tokens")
    boolean skipSpecialTokens;

    public LlamaPrompt(String prompt, String systemPrompt, double temperature, int maxTokens, int n, boolean skipSpecialTokens, int minTokens, int bestOf) {
        this.prompt = prompt;
        this.systemPrompt = systemPrompt;
        this.temperature = temperature;
        this.maxTokens = maxTokens;
        this.n = n;
        this.skipSpecialTokens = skipSpecialTokens;
        this.minTokens = minTokens;
        this.bestOf = bestOf;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getSystemPrompt() {
        return systemPrompt;
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean isApplyChatTemplate() {
        return applyChatTemplate;
    }

    public int getMaxTokens() {
        return maxTokens;
    }

    public int getMinTokens() {
        return minTokens;
    }

    public int getN() {
        return n;
    }

    public int getBestOf() {
        return bestOf;
    }
}
