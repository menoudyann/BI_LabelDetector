package org.example;

import com.google.cloud.vision.v1.FaceAnnotation;

import java.util.List;

public class FaceData {
    private float anger;
    private float joy;
    private float surprise;
    private float confidence;

    public FaceData(List<FaceAnnotation> faceAnnotations) {
        for (FaceAnnotation faceAnnotation : faceAnnotations) {
            this.anger = faceAnnotation.getAngerLikelihoodValue();
            this.joy = faceAnnotation.getJoyLikelihoodValue();
            this.surprise = faceAnnotation.getSurpriseLikelihoodValue();
            this.confidence = faceAnnotation.getDetectionConfidence();
        }
    }
}