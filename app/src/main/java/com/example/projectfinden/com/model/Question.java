package com.example.projectfinden.com.model;

import java.util.List;

public class Question {
    private int id;
    private String number;
    private String content;
    private String imageQue;
    private String correctAnswer;
    private String choice;
    private List<Option>options;

    public Question() {
    }

    public Question(int id, String number, String content, String imageQue, String correctAnswer, String choice, List<Option> options) {
        this.id = id;
        this.number = number;
        this.content = content;
        this.imageQue = imageQue;
        this.correctAnswer = correctAnswer;
        this.choice = choice;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageQue() {
        return imageQue;
    }

    public void setImageQue(String imageQue) {
        this.imageQue = imageQue;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
