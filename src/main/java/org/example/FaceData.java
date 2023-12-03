package org.example;

import com.google.cloud.vision.v1.FaceAnnotation;

import java.util.List;

public class FaceData {
    private List details;

    public FaceData(List<FaceAnnotation> faceAnnotations) {
        this.details = faceAnnotations;
    }
}