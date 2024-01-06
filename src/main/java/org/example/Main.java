package org.example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        String filePath = "gs://java.gogle.cld.education/voiturerue.jpg"; //"gs://java.gogle.cld.education/team.jpg";
        try {
            GoogleLabelDetectorImpl googleImageAnalyzer = new GoogleLabelDetectorImpl("GOOGLE_APPLICATION_CREDENTIALS");
            String labels = googleImageAnalyzer.analyze(filePath, 10, 0.7F);
            System.out.println(labels);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}