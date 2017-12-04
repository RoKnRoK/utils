package com.rok.misc.utils;

import com.rok.misc.utils.config.EnumeratedValueGenerationConfig;
import com.rok.misc.utils.config.StringValueGenerationConfig;
import com.rok.misc.utils.config.ValueGenerationConfig;
import com.rok.misc.utils.enums.UserType;

import java.util.Iterator;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class InsertScriptGeneratorTester {

    public static void main(String[] args) {
        ValueType[] types = new ValueType[]{ValueType.STRING, ValueType.STRING, ValueType.ENUMERATED};
        ValueGenerationConfig[] configs = new ValueGenerationConfig[]{
                new StringValueGenerationConfig(2, 4),
                new StringValueGenerationConfig(3, 5),
                new EnumeratedValueGenerationConfig(UserType.class)
        };
        Iterator<String[]> iterator = DBValuesGenerator.generateValuesIterator(20000, types, configs);
        InsertScriptGenerator insertScriptGenerator = new InsertScriptGenerator("USER", new String[]{"UNAME", "UPASS", "UTYPE"});
        insertScriptGenerator.generateScript(iterator);
    }
}
