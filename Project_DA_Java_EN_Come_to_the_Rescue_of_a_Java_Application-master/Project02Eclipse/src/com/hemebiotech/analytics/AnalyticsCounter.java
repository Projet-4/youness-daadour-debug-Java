package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Analyzes and counts symptoms, and writes the results to an external file.
 */
public class AnalyticsCounter {

	/**
	 * Counts the occurrences of symptoms.
	 *
	 * @param symptoms The list of symptoms.
	 * @return A map containing the symptoms and their occurrences.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> countSymptoms = new TreeMap<>();

		for (String symptom : symptoms) {
			countSymptoms.merge(symptom, 1, Integer::sum);
		}

		System.out.println("The symptoms have been analyzed correctly.");
		return countSymptoms;
	}

	/**
	 * Writes the symptom occurrences to an external file.
	 *
	 * @param countSymptoms A map containing the symptoms and their occurrences.
	 * @param outputFile    The file to write the results to.
	 * @throws IOException If an error occurs while writing the file.
	 */
	public void writeSymptomOccurrences(Map<String, Integer> countSymptoms, File outputFile) throws IOException {
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
