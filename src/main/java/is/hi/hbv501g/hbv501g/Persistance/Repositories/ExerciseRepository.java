package is.hi.hbv501g.hbv501g.Persistance.Repositories;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Exercise;
import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long > {
    Exercise save(Exercise exercise);
    void delete(Exercise exercise);
    List<Exercise> findAll();
    List<Exercise> findByTitle(String title);
    List<Exercise> findByBodyPart(String body_part);
    List<Exercise> findByType(String type);
}
