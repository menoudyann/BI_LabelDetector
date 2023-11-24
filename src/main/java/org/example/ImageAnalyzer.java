package org.example;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import io.github.cdimascio.dotenv.Dotenv;

public class ImageAnalyzer {

    protected static ImageAnnotatorClient client;

    public ImageAnalyzer(String credentialPathname) {
        Dotenv dotenv = Dotenv.load();

        try {
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(dotenv.get(credentialPathname)))
                    .createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));
            ImageAnnotatorSettings settings = ImageAnnotatorSettings.newBuilder()
                    .setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
            client = ImageAnnotatorClient.create(settings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void detectFaces(String filePath) throws IOException {

        List<AnnotateImageRequest> requests = new ArrayList<>();

        ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.FACE_DETECTION).build();
        AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        try {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                    return;
                }

                // For full list of available annotations, see http://g.co/cloud/vision/docs
                for (FaceAnnotation annotation : res.getFaceAnnotationsList()) {
                    System.out.format("anger: %s%njoy: %s%nsurprise: %s%nposition: %s", annotation.getAngerLikelihood(), annotation.getJoyLikelihood(), annotation.getSurpriseLikelihood(), annotation.getBoundingPoly());
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}