package org.example;

import junit.framework.TestCase;

import java.io.IOException;

public class ImageAnalyzerTest extends TestCase {

    public void testDetectFaceData() throws IOException {
        String filePath = "src/main/java/org/example/datas/banner_mail.jpg";
        ImageAnalyzer imageAnalyzer = new ImageAnalyzer("GOOGLE_APPLICATION_CREDENTIALS");
        assertEquals(4, imageAnalyzer.detectFaceData(filePath).size());
    }
}