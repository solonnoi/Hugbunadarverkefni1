package is.hi.hbv501g.hbv501g.Persistance.Entities;
import javax.persistence.*;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Þetta er klasi sem býr til Entity-ið ExerciseCombo,
 *  Forritið autogenerate-ar ID fyrir hvert og eitt workout,
 *  Það er OneToMany tenging frá Workout yfir í ExerciseCombo Entity-ið og
 *  ManyToOne tenging frá Workout til user.
 *
 *****************************************************************************/

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

    public Workout getWorkout() {
        return workout;
    }
    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
    public ExerciseCombo(int sets, int reps, double kg, Exercise exercise, Workout workout) {
        this.exercise = exercise;
        this.workout = workout;
        this.sets = sets;
        this.reps = reps;
        this.kg = kg;
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




}
