package com.rok.misc.utils.config;

public class EnumeratedValueGenerationConfig implements ValueGenerationConfig {

    private final Class enumClass;

    public EnumeratedValueGenerationConfig(Class<? extends Enum<?>> enumClass) {
        this.enumClass = enumClass;
    }

    public Class getEnumClass() {
        return this.enumClass;
    }
}
