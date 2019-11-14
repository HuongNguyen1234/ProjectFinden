package com.example.projectfinden.com.model;

public class Option {
    private int id;
    private String value;
    private String image;
    private boolean answer;

    public Option(int id, String value, String image, boolean answer) {
        this.id = id;
        this.value = value;
        this.image = image;
        this.answer = answer;
    }

    public Option() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
