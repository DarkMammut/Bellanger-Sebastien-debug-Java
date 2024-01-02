package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    public List<String> getSymptoms() {
        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("./symptoms.txt");
        System.out.println(reader.getSymptoms());
        return reader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms (List<String> symptoms) {
        //boucle dans une boucle / stream

        Map<String, Integer> symptomsByOccurence = new HashMap<>();

        for (String symptom : symptoms) {
            if (symptomsByOccurence.containsKey(symptom)) {
                symptomsByOccurence.put(symptom, symptomsByOccurence.get(symptom) + 1);
            } else {
                symptomsByOccurence.put(symptom, 1);
            }
        }

        return symptomsByOccurence;

    }

    public Map<String, Integer> sortSymptoms (Map<String, Integer> symptomsByOccurence) {
        Map<String, Integer> symptomsSort = new TreeMap<>(symptomsByOccurence);

        return symptomsSort;

    }

    public void writeSymptoms (Map<String, Integer> symptomsSort) {
        WriteSymptomDataToFile writer = new WriteSymptomDataToFile("./result.out");
        writer.writeSymptoms(symptomsSort);
    }
}
