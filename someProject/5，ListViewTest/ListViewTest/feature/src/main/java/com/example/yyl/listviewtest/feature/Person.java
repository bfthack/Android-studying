package com.example.yyl.listviewtest.feature;

public class Person {
    private String name;
    private int imageId;

    public Person(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return this.name;
    }

    public int getImageId(){
        return this.imageId;
    }

}
