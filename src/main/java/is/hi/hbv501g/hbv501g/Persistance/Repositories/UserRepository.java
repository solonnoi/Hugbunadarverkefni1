package is.hi.hbv501g.hbv501g.Persistance.Repositories;
import is.hi.hbv501g.hbv501g.Persistance.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Repository fyrir User. Inniheldur leitaraðferðir ásamt
 *  aðferðum til að vista og eyða user.
 *
 *****************************************************************************/


public interface UserRepository extends JpaRepository<User, Long > {
    User save(User user);
    void delete(User user);
    List<User> findAll();
    User findByUsername(String username);
}
