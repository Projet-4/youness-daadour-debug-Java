package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * Run the program
 */

public class Main {

    /**
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException {

        /*
        Read symptoms.txt and return list
         */
        ReadSymptomDataFromFile readData = new ReadSymptomDataFromFile(new File("Project02Eclipse/resources/symptoms.txt"));
        List<String> symptoms = readData.GetSymptoms();

        /*
        Sorts in alphabetical order and counts the occurrences of the symptoms in the list
         */
        AnalyticsCounter analyticsCounter = new AnalyticsCounter();
        Map<String, Integer> countSymptoms = analyticsCounter.CountSymptoms(symptoms);

        /*
        Print result in the results.out file
         */
        File fileOut = new File("Results.out");
        analyticsCounter.PrintFile(countSymptoms, fileOut);

    }

}