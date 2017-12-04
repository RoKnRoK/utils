package com.rok.misc.utils;

import com.rok.misc.utils.config.EnumeratedValueGenerationConfig;
import com.rok.misc.utils.config.StringValueGenerationConfig;
import com.rok.misc.utils.config.ValueGenerationConfig;

import java.util.Iterator;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class DBValuesGenerator {

    public static Iterator<String[]> generateValuesIterator(final int count, final ValueType[] types, final ValueGenerationConfig[] configs) {
        return new Iterator<String[]> () {
            private int totalCount = -1;
            private int currentCount = 0;

            {
                setTotalCount(count);
            }

            public boolean hasNext() {

                return currentCount < totalCount;
            }

            public String[] next() {
                currentCount++;
                return DBValuesGenerator.generateValuesArray(types, configs);
            }

            public void remove() {
                //as this is dynamically generated collection, nothing to remove
            }

            public void setTotalCount(int totalCount){
                this.totalCount = totalCount;
            }
        };
    }


    private static String[] generateValuesArray(ValueType[] types, ValueGenerationConfig[] configs) {
        int length = types.length;
        String[] values = new String[length];
        for (int i = 0; i < length; i++) {
            ValueType valueType = types[i];
            switch (valueType) {
                case STRING: {
                    values[i] = generateStringValue((StringValueGenerationConfig) configs[i]);
                } break;
                case ENUMERATED: {
                    values[i] = generateEnumeratedValue((EnumeratedValueGenerationConfig) configs[i]);
                } break;
            }
        }
        return values;
    }

    private static String generateEnumeratedValue(EnumeratedValueGenerationConfig config) {
        Class enumClass = config.getEnumClass();
        Object[] enumConstants = enumClass.getEnumConstants();
        int ind = (int) (Math.random() * 100) % enumConstants.length;
        return "'" + enumConstants[ind].toString() + "'";
    }

    private static String generateStringValue(StringValueGenerationConfig config) {
        int randomLength = (int) (Math.random() * 100) % (config.getMaxSyllables() - config.getMinSyllables() + 1) + config.getMinSyllables();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < randomLength; i++) {
            result.append(SyllableGenerator.nextSyllable());
        }
        return "'" + result.toString() + "'";
    }
}
