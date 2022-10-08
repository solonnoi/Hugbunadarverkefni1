package is.hi.hbv501g.hbv501g.Persistance.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    private String title;
    private String bodyPart;

    @OneToMany(mappedBy = "exercise",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseCombo> exerciseCombo = new ArrayList<>();

    public Exercise() {
    }

    public Exercise(String title, String bodyPart) {
        this.title = title;
        this.bodyPart = bodyPart;
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

}
