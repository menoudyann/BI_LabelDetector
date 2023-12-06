package org.example;

import java.io.IOException;
import java.util.List;

public interface ILabelDetector {

    public List<FaceData> detectFaceData(String filePath) throws IOException;
}
