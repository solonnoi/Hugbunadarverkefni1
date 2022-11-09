package is.hi.hbv501g.hbv501g.Services;
import is.hi.hbv501g.hbv501g.Persistance.Entities.User;
import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.List;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Service fyrir User. Inniheldur leitaraðferðir ásamt
 *  aðferðum til að vista og eyða exerciseCombo. Inniheldur einnig aðferð
 *  sem segir til um hvort notandi sé skráður inn.
 *
 *****************************************************************************/

@Service
public interface UserService {

    User save(User user);
    void delete(User user);
    List<User> findAll();
    User login(User user);
    User findByUsername(String username);
    User findByID(long id);
    void addWorkoutToUser(Workout workout, User user);

    /**
     * Boolean aðferð sem athugar hvort notandi sé skráður inn
     *
     * @param session
     * @return true ef notandi er skráður inn, annars false
     */
    public Boolean userLoggedIn(HttpSession session);



}


