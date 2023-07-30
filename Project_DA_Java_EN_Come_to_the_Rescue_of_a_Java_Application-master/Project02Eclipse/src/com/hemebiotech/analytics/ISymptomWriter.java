package com.hemebiotech.analytics;

import java.io.File;
import java.util.Map;

public interface ISymptomWriter {
    void writeSymptomOccurrences(Map<String, Integer> countSymptoms, File outputFile);
}

