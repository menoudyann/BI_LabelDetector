package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.rpc.context.AttributeContext;
import junit.framework.TestCase;
import org.example.helpers.URLTester;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class GoogleLabelDetectorImplTest extends TestCase {

    protected ILabelDetector labelDetector;

    public void setUp() throws Exception {
        super.setUp();
        this.labelDetector = new GoogleLabelDetectorImpl("GOOGLE_APPLICATION_CREDENTIALS");
    }

    public void testAnalyze_LocalFileWithDefaultValues_ImageAnalyzed() throws IOException, URISyntaxException {

//        URL localFileUrl = URI.create("https://images.unsplash.com/photo-1533050487297-09b450131914?q=80&w=3270&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D").toURL();
//        //test if the file exists
//        File localFile = Paths.get(localFileUrl.toURI()).toFile();
//
//        //given
//        assertTrue(localFile.exists());
//
//        //when
//        //TODO the type of response contains the payload (returned in json by the api)
//        String response = this.labelDetector.analyze(localFileUrl, 10, 90);
//        Gson gson = new Gson();
//        Type labelListType = new TypeToken<List<Label>>() {
//        }.getType();
//        List<Label> labels = gson.fromJson(response, labelListType);
//
//        //then
//        assertTrue(labels.size() <= 10);
//        for (Label label : labels) {
//            assertTrue(label.getScore() >= 0.9F);
//        }

        fail();
    }


    public void testAnalyze_RemoteImageWithDefaultValues_ImageAnalyzed() throws IOException, URISyntaxException {

        URL remoteFileUrl = URI.create("https://images.unsplash.com/photo-1533050487297-09b450131914?q=80&w=3270&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D").toURL();

        //given
        URLTester.isUrlResponding(remoteFileUrl);

        //when
        String response = this.labelDetector.analyze(remoteFileUrl);
        Gson gson = new Gson();
        Type labelListType = new TypeToken<List<Label>>() {
        }.getType();
        List<Label> labels = gson.fromJson(response, labelListType);

        //then
        assertTrue(labels.size() <= 10);
        for (Label label : labels) {
            assertTrue(label.getScore() >= 0.9F);
        }
    }


    public void testAnalyze_RemoteImageWithCustomMaxLabelValue_ImageAnalyzed() throws IOException, URISyntaxException {

        URL remoteFileUrl = URI.create("https://images.unsplash.com/photo-1533050487297-09b450131914?q=80&w=3270&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D").toURL();

        //given
        assertTrue(URLTester.isUrlResponding(remoteFileUrl));

        //when
        String response = this.labelDetector.analyze(remoteFileUrl, 2, 95);
        Gson gson = new Gson();
        Type labelListType = new TypeToken<List<Label>>() {
        }.getType();
        List<Label> labels = gson.fromJson(response, labelListType);

        //then
        assertTrue(labels.size() <= 2);
        for (Label label : labels) {
            assertTrue(label.getScore() >= 95 / 100F);
        }
    }


    public void testAnalyze_RemoteImageWithCustomMinConfidenceLevelValue_ImageAnalyzed() {
//        //given
//        //TODO test if the remote file is available
//        int minConfidenceLevel = 60;
//
//        //when
//        Response response = await this.labelDetector.Analyze(remoteFileUrl, minConfidenceLevel);
//        //TODO the type of response contains the payload (returned in json by the api)
//
//        //then
//        Assert.IsTrue(response.AmountOfLabels.Count() <= 10));
//        foreach(Metric metric in response.Metrics)
//        {
//            Assert.IsTrue(metric.confidenceLevel >= minConfidenceLevel));
//        }
    }


    public void testAnalyze_RemoteImageWithCustomValues_ImageAnalyzed() {
//        //given
//        //TODO test if the remote file is available
//        int maxLabels = 5;
//        int minConfidenceLevel = 60;
//
//        //when
//        Response response = await this.labelDetector.Analyze(remoteFileUrl, maxLabels, minConfidenceLevel);
//        //TODO the type of response contains the payload (returned in json by the api)
//
//        //then
//        Assert.IsTrue(response.AmountOfLabels.Count() <= maxLabel));
//        foreach(Metric metric in response.Metrics)
//        {
//            Assert.IsTrue(metric.confidenceLevel >= minConfidenceLevel));
//        }
    }
}