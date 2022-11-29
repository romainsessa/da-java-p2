package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) { 
		Map<String, Integer> countedSymptoms = new HashMap<>();
		for (String symptom : symptoms) {
			int value = 0;
			if (countedSymptoms.containsKey(symptom)) {
				value = countedSymptoms.get(symptom) + 1;
			} else {
				value = 1;
			}
			countedSymptoms.put(symptom, value);
		}
		return countedSymptoms;
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
		Map<String, Integer> sortedSymptoms = new TreeMap<>();
		sortedSymptoms.putAll(symptoms);
		return sortedSymptoms;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) { 
		writer.writeSymptoms(symptoms);
	}
}