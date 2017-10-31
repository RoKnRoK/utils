package com.rok.misc.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by RoK.
 * All rights reserved =)
 */
public class InsertScriptGenerator {

    private static final String INSERT_BODY = "INSERT INTO :table_name: (:columns_list:) VALUES\n";
    private final String tableName;
    private final String[] columnNames;

    public InsertScriptGenerator(String tableName, String[] columnNames){


        this.tableName = tableName;
        this.columnNames = columnNames;
    }

    public void generateScript(Iterator<String[]> valuesIterator){

        Path path = Paths.get("insert.sql");
        try (PrintWriter printWriter = new PrintWriter(path.toFile())){
            String columnsPrepared = Arrays.toString(this.columnNames);
            columnsPrepared = columnsPrepared.substring(1, columnsPrepared.length()-1);

            printWriter.append(INSERT_BODY.replace(":table_name:", this.tableName).replace(":columns_list:", columnsPrepared));

            boolean first = true;
            while (valuesIterator.hasNext()){
                if (!first) {printWriter.append(",\n"); }
                String valuesPrepared = Arrays.toString(valuesIterator.next());
                valuesPrepared = valuesPrepared.substring(1, valuesPrepared.length()-1);
                printWriter.append("(").append(valuesPrepared).append(")");
                first = false;
            }
            printWriter.append(";");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
