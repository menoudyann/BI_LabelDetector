package org.example;

import com.google.rpc.context.AttributeContext;
import junit.framework.TestCase;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;

public class GoogleLabelDetectorImplTest extends TestCase {

    protected ILabelDetector labelDetector;

    public void setUp() throws Exception {
        super.setUp();
        this.labelDetector = new GoogleLabelDetectorImpl("GOOGLE_APPLICATION_CREDENTIALS");
    }

    public void testAnalyze_LocalFileWithDefaultValues_ImageAnalyzed() {

//        URI localFile = URI.create("file:///Users/yannmenoud/Desktop/CPNV/BI/DataObject/src/test/java/org/example/images/testDownload.jpg");
//
//        //given
//        assertTrue(File.Exists(localFile)));
//
//        //when
//        String response = this.labelDetector.analyze(localFile);
//        //TODO the type of response contains the payload (returned in json by the api)
//
//        //then
//        Assert.IsTrue(response.AmountOfLabels.Count() <= 10));
//        foreach(Metric metric in response.Metrics)
//        {
//            Assert.IsTrue(metric.confidenceLevel >= 90));
//        }
    }


    public void testAnalyze_RemoteImageWithDefaultValues_ImageAnalyzed() throws MalformedURLException {

//        URL remoteFileUrl = new URL("https://storage.googleapis.com/java.gogle.cld.education/voiturerue.jpg");
//
//        //given
//        //TODO test if the remote file is available
//
//        //when
//        String response = this.labelDetector.analyze(remoteFileUrl);
//        //TODO the type of response contains the payload (returned in json by the api)
//
//        //then
//        Assert.IsTrue(response.AmountOfLabels.Count() <= 10));
//        foreach(Metric metric in response.Metrics)
//        {
//            Assert.IsTrue(metric.confidenceLevel >= 90));
//        }
    }


    public void testAnalyze_RemoteImageWithCustomMaxLabelValue_ImageAnalyzed() {
//        //given
//        //TODO test if the remote file is available
//        int maxLabel = 5;
//
//        //when
//        Response response = await this.labelDetector.Analyze(remoteFileUrl, maxLabels);
//        //TODO the type of response contains the payload (returned in json by the api)
//
//        //then
//        Assert.IsTrue(response.AmountOfLabels.Count() <= maxLabels));
//        foreach(Metric metric in response.Metrics)
//        {
//            Assert.IsTrue(metric.confidenceLevel >= 90));
//        }
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