package is.hi.hbv501g.hbv501g.Persistance.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Þetta er klasi sem býr til töfluna users,
 *  Klasinn autogenerate-ar ID fyrir hvern og einn user,
 *  Það er OneToMany tenging frá  töflunni yfir í workouts töfluna.
 *
 *****************************************************************************/

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String username;
    private String password;
    // Breyta yfir í protected?
    private String email;
    @ManyToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Workout> myWorkouts = new ArrayList<>();
    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Workout> getMyWorkouts() {
        return myWorkouts;
    }
    public void setMyWorkouts(List<Workout> myWorkouts) {
        this.myWorkouts = myWorkouts;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
