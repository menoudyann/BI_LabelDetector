package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public interface ILabelDetector {

    public String analyze(String remoteFullPath, int maxLabels, float minConfidenceLevel) throws IOException;
}
