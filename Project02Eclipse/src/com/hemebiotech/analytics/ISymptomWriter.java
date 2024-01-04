package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Write map into a file
 *
 */
public interface ISymptomWriter {
    public void writeSymptoms(Map<String, Integer> symptoms);
}
