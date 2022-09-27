package is.hi.hbv501g.hbv501g.Persistance.Repositories;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    Workout save(Workout workout);
    void delete(Workout workout);

    List<Workout> findAll();
    List<Workout> findByTitle(String title);
    Workout findByID(long ID);

}
