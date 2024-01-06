package org.example;

public class Label {

    protected String name;
    protected Object value;


    public Label(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}