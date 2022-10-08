package is.hi.hbv501g.hbv501g.Persistance.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String title;
    private int duration;
    private String description;

    /*
    @OneToMany(mappedBy = "workout",cascade = CascadeType.ALL, orphanRemoval = true)
   private List<MyWorkouts> myWorkouts = new ArrayList<>();

     */

    @OneToMany(mappedBy = "workout",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseCombo> exerciseCombo = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Workout() {
    }

    public Workout(String title, int duration, String description) {
        this.title = title;
        this.duration = duration;
        this.description = description;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {return description;}

}



