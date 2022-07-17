package repository;

public class Unit {
    private String unitName;
    private int questionNumber;
    private int assignedTimeForAQuestion;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getAssignedTimeForAQuestion() {
        return assignedTimeForAQuestion;
    }

    public void setAssignedTimeForAQuestion(int assignedTimeForAQuestion) {
        this.assignedTimeForAQuestion = assignedTimeForAQuestion;
    }
}
