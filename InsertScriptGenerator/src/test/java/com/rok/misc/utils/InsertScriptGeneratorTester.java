package com.rok.misc.utils;

import com.rok.misc.utils.config.DateValueGenerationConfig;
import com.rok.misc.utils.config.EnumeratedValueGenerationConfig;
import com.rok.misc.utils.config.StringValueGenerationConfig;
import com.rok.misc.utils.config.ValueGenerationConfig;
import com.rok.misc.utils.enums.UserType;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class InsertScriptGeneratorTester {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2001, Calendar.JANUARY, 1);
        Date startDate = calendar.getTime();

        calendar.set(2011, Calendar.DECEMBER, 31);
        Date endDate = calendar.getTime();


        ValueGenerationConfig[] configs = new ValueGenerationConfig[]{
                new StringValueGenerationConfig(2, 4),
                new StringValueGenerationConfig(3, 5),
                new EnumeratedValueGenerationConfig(UserType.class),
                new DateValueGenerationConfig(startDate, endDate)
        };
        Iterator<String[]> columnValues = DBValuesGenerator.generateValuesIterator(20000, configs);
        String[] columnNames = {"UNAME", "UPASS", "UTYPE", "DATE_CREATED"};

        InsertScriptGenerator insertScriptGenerator = new InsertScriptGenerator("USER_TBL", columnNames);
        insertScriptGenerator.generateScript(columnValues);
    }
}
