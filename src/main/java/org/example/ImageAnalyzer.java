package org.example;

import java.io.IOException;
import java.util.List;

public interface ImageAnalyzer {

    public List<FaceData> detectFaceData(String filePath) throws IOException;
}
