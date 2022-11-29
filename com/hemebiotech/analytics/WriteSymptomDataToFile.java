package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

  public void writeSymptoms(Map<String,Integer> symptoms) {
    try {
			FileWriter writer = new FileWriter("result.out");

			Iterator<String> iterator = symptoms.keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				String value = key + " : " + symptoms.get(key);
				writer.write(value + "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("Error on write process."); // Just output a simple message in the console in case of exception.
		}
  }

}