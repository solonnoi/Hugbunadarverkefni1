package is.hi.hbv501g.hbv501g.Persistance.Entities;

import javax.persistence.*;

@Entity
@Table(name = "Exercises")


public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private Workout workout;

    public Exercise(String title, Workout workout) {
        this.title = title;
        this.workout = workout;
    }

    public Exercise() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
}
