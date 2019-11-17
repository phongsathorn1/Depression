package com.depression;

public class Choice {
    private int choiceID;
    private String choiceTitle;
    private int choiceValue;

    public Choice() {
    }

    public Choice(int choiceID, String choiceTitle, int choiceValue) {
        this.choiceID = choiceID;
        this.choiceTitle = choiceTitle;
        this.choiceValue = choiceValue;
    }

    public int getChoiceID() {
        return choiceID;
    }

    public void setChoiceID(int choiceID) {
        this.choiceID = choiceID;
    }

    public String getChoiceTitle() {
        return choiceTitle;
    }

    public void setChoiceTitle(String choiceTitle) {
        this.choiceTitle = choiceTitle;
    }

    public int getChoiceValue() {
        return choiceValue;
    }

    public void setChoiceValue(int choiceValue) {
        this.choiceValue = choiceValue;
    }

    public void setShaded(boolean shaded) {
    }
}
