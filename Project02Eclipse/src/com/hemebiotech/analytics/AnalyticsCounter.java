package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Filepatrh variables for read and write
 * Make a map from a list with number of occurences
 * Sort the map
 *
 */
public class AnalyticsCounter {
    private final String FILE_PATH_SYMPTOMS = "./symptoms.txt";
    private final String FILE_PATH_RESULT = "./result.out";

    public List<String> getSymptoms() {
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(FILE_PATH_SYMPTOMS);
        System.out.println(reader.getSymptoms());
        return reader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        return symptoms.stream()
                .collect(Collectors.toMap(
                        symptom -> symptom,
                        symptom -> 1,
                        Integer::sum));
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomsByOccurence) {
        Map<String, Integer> symptomsSort = new TreeMap<>(symptomsByOccurence);
        return symptomsSort;
    }

    public void writeSymptoms(Map<String, Integer> symptomsSort) {
        WriteSymptomDataToFile writer = new WriteSymptomDataToFile(FILE_PATH_RESULT);
        writer.writeSymptoms(symptomsSort);
    }
}
