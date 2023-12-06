package org.example;


import com.google.cloud.vision.v1.FaceAnnotation;

import java.util.List;

public class FaceData {

    protected FaceAnnotation details;

    public FaceData(FaceAnnotation faceAnnotations) {
        this.details = faceAnnotations;
    }
}