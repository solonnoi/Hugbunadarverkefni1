package is.hi.hbv501g.hbv501g.Services.Implementation;

import is.hi.hbv501g.hbv501g.Persistance.Entities.User;
import is.hi.hbv501g.hbv501g.Persistance.Repositories.UserRepository;
import is.hi.hbv501g.hbv501g.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    // Use autowiring through the constructor
    @Autowired
    public UserServiceImplementation(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(String login, String password, String email){
        if(login == null && password == null){
            return null;
        }
        else {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            return userRepository.save(user);
        }
    }


    // Authentication method
    public User authenticate(String login, String password){
        return userRepository.findByLoginAndPassword(login, password).orElse(null);
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
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public Optional<User> findByLoginPassword(String login, String password) {
        return Optional.empty();
    }

    /**
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
    */




}


