package is.hi.hbv501g.hbv501g.Persistance.Entities;

import javax.persistence.*;

@Entity
@Table(name = "exercise_combos")
public class ExerciseCombo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private int sets;
    private int reps;
    private double kg;

    private String title;

    private long jaan;

    @ManyToOne(fetch = FetchType.LAZY)
    private Exercise exercise;
    @ManyToOne(fetch = FetchType.LAZY)
    private Workout workout;

    public Workout getWorkout() {
        return workout;
    }
    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
    public ExerciseCombo(int sets, int reps, double kg, String title, long jaan) {
        this.title = title;
        this.jaan = jaan;
        this.sets = sets;
        this.reps = reps;
        this.kg = kg;
       // this.exercise = exercise;
    }

    public ExerciseCombo() {
    }
    public String getExercise_title() {
        if (exercise == null){
            return "asdf";
        }
        else return exercise.getTitle();
    }

    public long getID() {
        return ID;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTest() {
        return jaan;
    }

    public void setTest(long test) {
        this.jaan = test;
    }
}
