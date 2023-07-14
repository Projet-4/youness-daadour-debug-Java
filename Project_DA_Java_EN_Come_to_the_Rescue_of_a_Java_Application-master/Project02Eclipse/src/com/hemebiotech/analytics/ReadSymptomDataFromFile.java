package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Simple brute force implementation
 * Access the data file and return the result in a list
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	File fileIn;

	public ReadSymptomDataFromFile(File fileIn) {
		this.fileIn = fileIn;
	}

	/**
	 * Access the data file and return the result in a list
	 *
	 * @return List of symptoms
	 */

	@Override
	public List<String> GetSymptoms() {
		List<String> result = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(this.fileIn));
			String line = reader.readLine();

			while (line != null) {
				result.add(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}