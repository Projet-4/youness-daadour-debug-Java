package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Browse the list, sort it alphabetically and count the occurrences
 * Print in external file
 */

public class AnalyticsCounter {

	/**
	 * Browse the list, sort it alphabetically and count the occurrences
	 *
	 * @param symptoms list of symptoms
	 * @return countSymptoms list of symptoms in a natural order and count the strings occurrences
	 */

	public Map<String, Integer> CountSymptoms(List<String> symptoms) {

		Map<String, Integer> countSymptoms = new TreeMap<>();

		try {
			for (String symptom : symptoms) {
				countSymptoms.merge(symptom, 1, Integer::sum);
			}
			System.out.println("The symptoms.txt file was analyzed correctly");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Cause : " + e.getCause());
		}
		return countSymptoms;
	}

	/**
	 * Print the map in an external file
	 *
	 * @param countSymptoms list of symptoms in a natural order and count the strings occurrences
	 * @param fileOut       creation of an external file
	 * @throws IOException if the file is not created correctly
	 */

	public void PrintFile(Map<String, Integer> countSymptoms, File fileOut) throws IOException {

		BufferedWriter bf = new BufferedWriter(new FileWriter(fileOut));

		try {
			for (Map.Entry entry : countSymptoms.entrySet()) {
				bf.write(entry.getKey() + " : " + entry.getValue() + System.getProperty("line.separator"));
			}
			bf.close();
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Cause : " + e.getCause());
			System.out.println("Message : " + e.getMessage());
		}




		System.out.println("The file " + fileOut + " has been created");
		System.out.println("Filepath: " + fileOut.getAbsolutePath());
	}
}