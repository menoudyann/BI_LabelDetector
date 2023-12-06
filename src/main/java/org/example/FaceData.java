package org.example;

import com.google.cloud.vision.v1.FaceAnnotation;

import java.util.List;

public class FaceData {

    protected List details;

    public FaceData(List<FaceAnnotation> faceAnnotations) {
        this.details = faceAnnotations;
    }

    public List getDetails() {
        return details;
    }
}