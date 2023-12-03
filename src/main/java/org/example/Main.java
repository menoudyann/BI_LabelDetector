package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/datas/banner_mail.jpg";
        try {
            GoogleImageAnalyzer googleImageAnalyzer = new GoogleImageAnalyzer("GOOGLE_APPLICATION_CREDENTIALS");
            googleImageAnalyzer.detectFaceData(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}