package org.example;

import java.io.IOException;

import static org.example.ImageAnalyzer.detectFaces;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/datas/banner_mail.jpg";
        try {
            detectFaces(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}