package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class  WriteSymptomDataToFile implements ISymptomWriter {


    @Override
    public void writeSymptomOccurrences(Map<String, Integer> countSymptoms, File outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : countSymptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue() + System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error writing the file: " + e.getMessage());
        }

        System.out.println("The file " + outputFile.getName() + " has been created.");
        System.out.println("File path: " + outputFile.getAbsolutePath());
    }
}
