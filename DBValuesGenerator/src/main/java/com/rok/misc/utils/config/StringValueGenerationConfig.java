package com.rok.misc.utils.config;

public class StringValueGenerationConfig implements ValueGenerationConfig {

    private int minSyllables, maxSyllables;

    public StringValueGenerationConfig(int minSyllables, int maxSyllables) {
        this.minSyllables = minSyllables;
        this.maxSyllables = maxSyllables;
    }

    public int getMinSyllables() {
        return minSyllables;
    }

    public int getMaxSyllables() {
        return maxSyllables;
    }
}
