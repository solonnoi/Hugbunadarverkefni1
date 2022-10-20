package is.hi.hbv501g.hbv501g.Persistance.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Inniheldur allt sem við viljum setja inn
@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    private String title;
    private String bodyPart;
    private String type;


    @OneToMany(mappedBy = "exercise",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseCombo> exerciseCombo = new ArrayList<>();

    public Exercise() {
    }

    public Exercise(String title, String bodyPart, String type) {
        this.title = title;
        this.bodyPart = bodyPart;
        this.type = type;
    }

    public String getType() {return type; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
