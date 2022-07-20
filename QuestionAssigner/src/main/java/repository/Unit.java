package repository;

public class Unit {


    // 문제집 / 회독
    private int times;
    private String bookName;
    private String unitName;
    private int questionNumber;
    private int assignedTimeForAQuestion;

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

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
