package is.hi.hbv501g.hbv501g.Persistance.Repositories;

import is.hi.hbv501g.hbv501g.Persistance.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long > {
    User save(User user);
    void delete(User user);
    List<User> findAll();
    //User findByUsername(String username);

    //Optional<User> findByUsernameAndPassword(String login, String password);

    User findByLogin(String login);

    Optional<User> findByLoginAndPassword(String login, String password);

    Optional<User> findFirstByLogin(String login);
}
