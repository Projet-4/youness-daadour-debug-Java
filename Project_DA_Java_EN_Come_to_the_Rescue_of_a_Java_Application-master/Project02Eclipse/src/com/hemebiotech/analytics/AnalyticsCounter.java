import com.hemebiotech.analytics.ISymptomReader;
import com.hemebiotech.analytics.ISymptomWriter;

import java.util.*;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public void processSymptoms() {
		List<String> symptoms = getSymptoms();
		Map<String, Integer> symptomCounts = countSymptoms(symptoms);
		Map<String, Integer> sortedSymptoms = sortSymptoms(symptomCounts);
		writeSymptoms(sortedSymptoms);
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();

		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}

		return symptomCounts;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
		return sortedSymptoms;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
				import com.hemebiotech.analytics.ISymptomReader;
				import com.hemebiotech.analytics.ISymptomWriter;

public class Main {
	public static void main(String[] args) {
		// Instanciation de l'ISymptomReader et de l'ISymptomWriter
		ISymptomReader reader = new YourSymptomReader(); // Remplacez YourSymptomReader par votre propre implémentation
		ISymptomWriter writer = new YourSymptomWriter(); // Remplacez YourSymptomWriter par votre propre implémentation

		// Instanciation de l'AnalyticsCounter
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

		// Appel des méthodes d'AnalyticsCounter dans le bon ordre
		counter.processSymptoms();
	}
}
