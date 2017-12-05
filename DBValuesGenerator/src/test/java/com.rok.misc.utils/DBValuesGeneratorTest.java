package com.rok.misc.utils;

import com.rok.misc.utils.config.DateValueGenerationConfig;
import com.rok.misc.utils.config.EnumeratedValueGenerationConfig;
import com.rok.misc.utils.config.StringValueGenerationConfig;
import com.rok.misc.utils.config.ValueGenerationConfig;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
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
        Calendar calendar = Calendar.getInstance();

        calendar.set(2001, Calendar.JANUARY, 1);
        Date startDate = calendar.getTime();

        calendar.set(2011, Calendar.DECEMBER, 31);
        Date endDate = calendar.getTime();

        ValueGenerationConfig[] configs = new ValueGenerationConfig[] {
                new StringValueGenerationConfig(2,4),
                new EnumeratedValueGenerationConfig(TestEnum.class),
                new DateValueGenerationConfig(startDate, endDate)
        };
        Iterator<String[]> iterator = DBValuesGenerator.generateValuesIterator(20, configs);
        while (iterator.hasNext()) {
            System.out.println(Arrays.toString(iterator.next()));
        }
    }
}

