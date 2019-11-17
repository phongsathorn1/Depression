package com.depression;

public class Interpretation {
    private int totalScore = 0;
    private String depressionSeverity = "ไม่มีภาวะซึมเศร้า";

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
        setDepressionSeverity(this.getTotalScore());
    }

    public void addTotalScore(int score) {
        this.totalScore += score;
        setDepressionSeverity(this.getTotalScore());
    }

    public String getDepressionSeverity() {
        return depressionSeverity;
    }

    private void setDepressionSeverity(int score) {
        if (isBetween(score, 1, 4)) {
            this.depressionSeverity = "ไม่มีภาวะซึมเศร้า";
        } else if (isBetween(score, 5, 9)) {
            this.depressionSeverity = "มีภาวะซึมเศร้าเล็กน้อย";
        } else if (isBetween(score, 10, 14)) {
            this.depressionSeverity = "มีภาวะซึมเศร้าปานกลาง";
        } else if (isBetween(score, 15, 19)) {
            this.depressionSeverity = "มีภาวะซึมเศร้ามาก";
        } else if (isBetween(score, 20, 27)) {
            this.depressionSeverity = "มีภาวะซึมเศร้ารุนแรง";
        } else {
            this.depressionSeverity = "Something went wrong";
        }
    }

    private static boolean isBetween(int x, int lower, int upper) {
        return lower <= x && x <= upper;
    }
}
