package org.example;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors;
import io.github.cdimascio.dotenv.Dotenv;

import javax.persistence.Table;

public class GoogleLabelDetectorImpl implements ILabelDetector {

    protected static ImageAnnotatorClient client;
    protected Database database;

    public GoogleLabelDetectorImpl(String credentialPathname) {
        Dotenv dotenv = Dotenv.load();
        database = new Database();

        try {
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(dotenv.get(credentialPathname))).createScoped(List.of("https://www.googleapis.com/auth/cloud-platform"));
            ImageAnnotatorSettings settings = ImageAnnotatorSettings.newBuilder().setCredentialsProvider(FixedCredentialsProvider.create(credentials)).build();
            client = ImageAnnotatorClient.create(settings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Label> analyze(String remoteFullPath, int maxLabels, float minConfidenceLevel) throws IOException {

        List<Label> labels = new ArrayList<>();
        List<AnnotateImageRequest> requests = new ArrayList<>();

        ByteString imgBytes = ByteString.readFrom(new FileInputStream(remoteFullPath));

        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.FACE_DETECTION).setMaxResults(maxLabels).build();
        AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        try {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                }
                List<FaceAnnotation> faceAnnotations = res.getFaceAnnotationsList();
                for (FaceAnnotation annotation : faceAnnotations) {
                    if (annotation.getDetectionConfidence() > minConfidenceLevel){
                        Map<Descriptors.FieldDescriptor, Object> fields = annotation.getAllFields();
                        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : fields.entrySet()) {
                            String key = entry.getKey().getName();
                            Object value = entry.getValue();
                            if (value instanceof Number) {
                                Label label = new Label(key, (float) value);
                                labels.add(label);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return labels;
    }
}