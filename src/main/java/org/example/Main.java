package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/datas/banner.jpg";
        try {
            GoogleImageAnalyzer googleImageAnalyzer = new GoogleImageAnalyzer("GOOGLE_APPLICATION_CREDENTIALS");
            List<FaceData> faceDatas = googleImageAnalyzer.detectFaceData(filePath);
            for (FaceData faceData : faceDatas) {
                System.out.println(faceData.details.size());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}