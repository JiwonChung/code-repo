package repository;

public class Question {
    // 그냥 12345
    private long id;

    // 문제집_단원_번호_회독
    private String name;

    // time per question
    private double tpq;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTpq() {
        return tpq;
    }

    public void setTpq(double tpq) {
        this.tpq = tpq;
    }
}
