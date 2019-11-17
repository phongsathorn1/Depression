package com.depression;

import java.util.ArrayList;

public class Answers {
    private ArrayList<Answer> answers = new ArrayList<>();

    public Answers() {
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public Answer getAnswerByID(int id) {
        for (Answer answer : answers) {
            if (answer.getQuestionID() == id) {
                return answer;
            }
        }
        return null;
    }
}
