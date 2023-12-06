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

public class GoogleImageAnalyzer implements ImageAnalyzer {

    protected static ImageAnnotatorClient client;

    public GoogleImageAnalyzer(String credentialPathname) {
        Dotenv dotenv = Dotenv.load();

        try {
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(dotenv.get(credentialPathname))).createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));
            ImageAnnotatorSettings settings = ImageAnnotatorSettings.newBuilder().setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
            client = ImageAnnotatorClient.create(settings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<FaceData> detectFaceData(String filePath) throws IOException {

        List<FaceData> facesData = new ArrayList<>();

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
                }


                for (FaceAnnotation annotation : res.getFaceAnnotationsList()) {
                    System.out.println("ANNONATION");
                    System.out.println(annotation);
                }
                FaceData faceData = new FaceData(res.getFaceAnnotationsList());
                facesData.add(faceData);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return facesData;
    }
}