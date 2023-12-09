package org.example;

import javax.persistence.Table;

public class Label {

    protected int id;
    protected String name;
    protected float value;


    public Label(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public float getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

}