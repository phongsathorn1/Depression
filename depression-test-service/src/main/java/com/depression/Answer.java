package com.depression;

public class Answer {
    private int questionID;
    private int selectedChoice;

    public Answer() {
    }

    public Answer(int questionID, int selectedChoice) {
        this.questionID = questionID;
        this.selectedChoice = selectedChoice;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getSelectedChoice() {
        return selectedChoice;
    }

    public void setSelectedChoice(int selectedChoice) {
        this.selectedChoice = selectedChoice;
    }
}
