package org.example;

import java.io.IOException;

import static org.example.ImageAnalyzer.detectFaceData;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/datas/banner_mail.jpg";
        try {
            ImageAnalyzer imageAnalyzer = new ImageAnalyzer("GOOGLE_APPLICATION_CREDENTIALS");
            imageAnalyzer.detectFaceData(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}