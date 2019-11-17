package com.depression;

import java.util.ArrayList;

public class Question {
    private int questionID;
    private String questionTitle;
    private ArrayList<Choice> choices;

    public Question() {
    }

    public Question(int questionID, String questionTitle, ArrayList<Choice> choices) {
        this.questionID = questionID;
        this.questionTitle = questionTitle;
        this.choices = choices;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<Choice> choices) {
        this.choices = choices;
    }

    public Choice getChoiceByID(int id) {
        for (Choice choice : choices) {
            if (choice.getChoiceID() == id) {
                return choice;
            }
        }
        return null;
    }

}
