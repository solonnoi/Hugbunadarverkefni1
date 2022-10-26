package is.hi.hbv501g.hbv501g.Persistance.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Þetta er klasi sem býr til Entity-ið workouts,
 *  Forritið autogenerate-ar ID fyrir hvert og eitt workout,
 *  það eru nokkrar
 *  Það er OneToMany tenging frá workouts yfir í ExerciseCombos Entity-ið og
 *  ManyToOne tenging við user.
 *
 *****************************************************************************/
@Entity
@Table(name= "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String title;
    private int duration;
    private String description;
    @OneToMany(mappedBy = "workout",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseCombo> exerciseCombo = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    public List<ExerciseCombo> getExerciseCombo() {
        return exerciseCombo;
    }
    public void setExerciseCombo(List<ExerciseCombo> exerciseCombo) {
        this.exerciseCombo = exerciseCombo;
    }
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



