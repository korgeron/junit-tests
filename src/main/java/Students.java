import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Students {
    String name;
    ArrayList<Integer> grades;
    long id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getGradeAverage() {
        AtomicReference<Double> t = new AtomicReference<>((double) 0);
        grades.forEach((k) -> {
            t.updateAndGet(v -> ((double) (v + k)));
        });
        return t.get() / grades.size();
    }
}