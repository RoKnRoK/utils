package com.rok.misc.utils;

import java.util.Iterator;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class InsertScriptGeneratorTester {

    public static void main(String[] args) {
        Iterator<String[]> iterator = UserPassGenerator.generatePairAsArrayIterator(1000000);
        InsertScriptGenerator insertScriptGenerator = new InsertScriptGenerator("USER", new String[]{"UNAME", "UPASS"});
        insertScriptGenerator.generateScript(iterator);
    }
}
