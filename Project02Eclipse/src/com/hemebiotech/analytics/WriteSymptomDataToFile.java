package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

// Classe implémentant l'interface pour écrire les symptômes dans un fichier
public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;

    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                String symptom = entry.getKey();
                int quantity = entry.getValue();
                writer.write(symptom + ": " + quantity + "\n");
            }
			writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}