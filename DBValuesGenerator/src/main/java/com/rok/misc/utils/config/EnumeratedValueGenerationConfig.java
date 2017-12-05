package com.rok.misc.utils.config;

import com.rok.misc.utils.ValueType;

public class EnumeratedValueGenerationConfig implements ValueGenerationConfig {

    private final Class enumClass;

    public EnumeratedValueGenerationConfig(Class<? extends Enum<?>> enumClass) {
        this.enumClass = enumClass;
    }

    public Class getEnumClass() {
        return this.enumClass;
    }

    public ValueType getValueType() {
        return ValueType.ENUMERATED;
    }
}
