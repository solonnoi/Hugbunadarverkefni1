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

    @ManyToOne(fetch = FetchType.LAZY)
    private Exercise exercise;

    @ManyToOne(fetch = FetchType.LAZY)
    private Workout workout;

    public ExerciseCombo(int sets, int reps, double kg, Exercise exercise) {
        this.sets = sets;
        this.reps = reps;
        this.kg = kg;
        this.exercise = exercise;
    }

    public ExerciseCombo() {

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
}
