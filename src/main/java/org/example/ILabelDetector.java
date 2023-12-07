package org.example;

import java.io.IOException;
import java.util.List;

public interface ILabelDetector {

    public List<Label> analyze(String remoteFullPath, int maxLabels, float minConfidenceLevel) throws IOException;
}
