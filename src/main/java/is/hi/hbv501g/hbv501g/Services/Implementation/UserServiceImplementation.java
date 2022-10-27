package is.hi.hbv501g.hbv501g.Services.Implementation;
import is.hi.hbv501g.hbv501g.Persistance.Entities.User;
import is.hi.hbv501g.hbv501g.Persistance.Repositories.UserRepository;
import is.hi.hbv501g.hbv501g.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.List;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Implementation á UserService. Inniheldur leitaraðferðir
 *  ásamt því að hafa aðferðir sem eyða og vista user. Klasinn talar
 *  við UserRepository og kallar á aðferðirnar sem eru þar. Inniheldur
 *  einnig aðferð sem athugar hvort notandi sé skráður inn og eins hvort
 *  að nota sé til áður en hann er skráður inn.
 *
 *****************************************************************************/

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Athugar hvort notandi sé skráður inn
     *
     * @param session HttpSession
     * @return true ef notandi er skráður inn,  annars false
     *
     */
    @Override
    public Boolean userLoggedIn(HttpSession session) {
        if(session.getAttribute("LoggedInUser") != null) {
            return true;
        }
        return false;
    }

    /**
     * Athugar hvort notandi sé til og hvort lykilorðið sé rétt
     *
     * @param user núverandi notandi
     * @return doesExist sem er núverandi notandi ef notandinn er til og
     *         lykilorðið er rétt. Annar skilar fallið null.
     *
     */
    @Override
    public User login(User user) {
         User doesExist = findByUsername(user.getUsername());
        if(doesExist != null){
            if(doesExist.getPassword().equals(user.getPassword())){
                return doesExist;
            }
        }
        return null;
    }





}


