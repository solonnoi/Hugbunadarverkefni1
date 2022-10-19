package is.hi.hbv501g.hbv501g.Services;

import is.hi.hbv501g.hbv501g.Persistance.Entities.User;
import is.hi.hbv501g.hbv501g.Persistance.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    User save(User user);
    void delete(User user);
    List<User> findAll();
    //User findByUsername(String username);

    User findByLogin(String login);

    User login(User user);

    Optional<User> findByLoginPassword(String login, String password);



}


