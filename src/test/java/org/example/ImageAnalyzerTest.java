package org.example;

import junit.framework.TestCase;

import java.io.IOException;

public class ImageAnalyzerTest extends TestCase {

    public void testDetectFaceData() throws IOException {
        String filePath = "src/main/java/org/example/datas/banner_mail.jpg";
        GoogleImageAnalyzer googleImageAnalyzer = new GoogleImageAnalyzer("GOOGLE_APPLICATION_CREDENTIALS");
        assertEquals(4, googleImageAnalyzer.detectFaceData(filePath).size());
    }
}