package Project.ObjectToSql;

/**
 * Created by liuxiang on 2018/7/2.
 */
public class Student {
    private int no;
    private String name;
    private float score;

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
        this.score = score;
    }

    public Student(int no, String name, float score) {
        this.no = no;
        this.name = name;
        this.score = score;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
