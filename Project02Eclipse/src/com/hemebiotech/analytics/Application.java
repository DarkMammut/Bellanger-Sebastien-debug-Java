package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Call all methods of AnalyticsCounter
 *
 */
public class Application {
    public static void main(String[] args) {

        AnalyticsCounter analyticsCounter = new AnalyticsCounter();

        List<String> symptoms = analyticsCounter.getSymptoms();

        Map<String, Integer> symptomsByOccurrence = analyticsCounter.countSymptoms(symptoms);

        Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomsByOccurrence);

        analyticsCounter.writeSymptoms(sortedSymptoms);
    }
}
