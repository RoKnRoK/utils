package com.rok.misc.utils;

import com.rok.misc.utils.config.EnumeratedValueGenerationConfig;
import com.rok.misc.utils.config.StringValueGenerationConfig;
import com.rok.misc.utils.config.ValueGenerationConfig;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class DBValuesGeneratorTest {

    enum TestEnum {
        TEST_CONST1,
        TEST_CONST2
    }


    @Test
    public void testGenerate(){
        ValueType[] types = new ValueType[]{ValueType.STRING, ValueType.ENUMERATED};
        ValueGenerationConfig[] configs = new ValueGenerationConfig[] {
                new StringValueGenerationConfig(2,4),
                new EnumeratedValueGenerationConfig(TestEnum.class)
        };
        Iterator<String[]> iterator = DBValuesGenerator.generateValuesIterator(20, types, configs);
        while (iterator.hasNext()) {
            System.out.println(Arrays.toString(iterator.next()));
        }
    }
}

