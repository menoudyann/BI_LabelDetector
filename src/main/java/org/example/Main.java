package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/datas/banner.jpg";
        try {
            GoogleLabelDetector googleImageAnalyzer = new GoogleLabelDetector("GOOGLE_APPLICATION_CREDENTIALS");
            List<FaceData> faceDatas = googleImageAnalyzer.detectFaceData(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}