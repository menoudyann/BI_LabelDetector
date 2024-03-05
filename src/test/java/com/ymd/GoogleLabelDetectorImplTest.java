package com.ymd;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ymd.GoogleLabelDetectorImpl;
import com.ymd.ILabelDetector;
import com.ymd.Label;
import io.github.cdimascio.dotenv.Dotenv;
import junit.framework.TestCase;
import com.ymd.helpers.URLTester;
import org.junit.Before;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class GoogleLabelDetectorImplTest extends TestCase {

    protected ILabelDetector labelDetector;
    private Dotenv dotenv;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        this.dotenv = Dotenv.load();
        this.labelDetector = new GoogleLabelDetectorImpl("GOOGLE_APPLICATION_CREDENTIALS");
    }

    public void testAnalyze_LocalFileWithDefaultValues_ImageAnalyzed() throws IOException, URISyntaxException {

        URL localFileURL = new File("images/test.png").toURI().toURL();
        File localFile = Paths.get(localFileURL.toURI()).toFile();

        //given
        assertTrue(localFile.exists());

        //when
        String response = this.labelDetector.analyze(localFileURL);
        Gson gson = new Gson();
        Type labelListType = new TypeToken<List<Label>>() {
        }.getType();
        List<Label> labels = gson.fromJson(response, labelListType);

        //then
        assertTrue(labels.size() <= 10);
        for (Label label : labels) {
            assertTrue(label.getScore() >= 90 / 100F);
        }
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
            assertTrue(label.getScore() >= 90 / 100F);
        }
    }


    public void testAnalyze_RemoteImageWithCustomMaxLabelValue_ImageAnalyzed() throws IOException, URISyntaxException {

        URL remoteFileUrl = URI.create("https://images.unsplash.com/photo-1533050487297-09b450131914?q=80&w=3270&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D").toURL();

        //given
        assertTrue(URLTester.isUrlResponding(remoteFileUrl));

        //when
        String response = this.labelDetector.analyze(remoteFileUrl, 2);
        Gson gson = new Gson();
        Type labelListType = new TypeToken<List<Label>>() {
        }.getType();
        List<Label> labels = gson.fromJson(response, labelListType);

        //then
        assertTrue(labels.size() <= 2);
        for (Label label : labels) {
            assertTrue(label.getScore() >= 90 / 100F);
        }
    }


    public void testAnalyze_RemoteImageWithCustomMinConfidenceLevelValue_ImageAnalyzed() throws IOException, URISyntaxException {

        URL remoteFileUrl = URI.create("https://images.unsplash.com/photo-1533050487297-09b450131914?q=80&w=3270&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D").toURL();

        //given
        //TODO test if the remote file is available
        float minConfidenceLevel = 60;

        //when
        String response = this.labelDetector.analyze(remoteFileUrl, minConfidenceLevel);
        Gson gson = new Gson();
        Type labelListType = new TypeToken<List<Label>>() {
        }.getType();
        List<Label> labels = gson.fromJson(response, labelListType);

        //then
        assertTrue(labels.size() <= 10);
        for (Label label : labels) {
            assertTrue(label.getScore() >= minConfidenceLevel / 100F);
        }
    }


    public void testAnalyze_RemoteImageWithCustomValues_ImageAnalyzed() throws IOException, URISyntaxException {

        URL remoteFileUrl = URI.create("https://images.unsplash.com/photo-1533050487297-09b450131914?q=80&w=3270&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D").toURL();

        //given
        //TODO test if the remote file is available
        int maxLabels = 5;
        int minConfidenceLevel = 60;

        //when
        String response = this.labelDetector.analyze(remoteFileUrl, maxLabels, minConfidenceLevel);
        Gson gson = new Gson();
        Type labelListType = new TypeToken<List<Label>>() {
        }.getType();
        List<Label> labels = gson.fromJson(response, labelListType);

        //then
        assertTrue(labels.size() <= maxLabels);
        for (Label label : labels) {
            assertTrue(label.getScore() >= minConfidenceLevel / 100F);
        }
    }
}