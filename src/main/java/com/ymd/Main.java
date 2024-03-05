package com.ymd;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        URL filePath = URI.create("https://images.unsplash.com/photo-1533050487297-09b450131914?q=80&w=3270&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D").toURL();
//        try {
//            GoogleLabelDetectorImpl googleImageAnalyzer = new GoogleLabelDetectorImpl("GOOGLE_APPLICATION_CREDENTIALS");
//            String labels = googleImageAnalyzer.analyze(filePath, 10, 90);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("The docker container is running!");
    }
}