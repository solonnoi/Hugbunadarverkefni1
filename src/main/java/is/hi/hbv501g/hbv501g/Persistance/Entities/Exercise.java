package is.hi.hbv501g.hbv501g.Persistance.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Þetta er klasi sem býr til töfluna exercises,
 *  Klasinn autogenerate-ar ID fyrir hvern og einn user,
 *  Það er OneToMany tenging frá exercises töflunni yfir í exercise_combos töfluna.
 *
 *****************************************************************************/

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

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
