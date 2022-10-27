package is.hi.hbv501g.hbv501g.Persistance.Repositories;
import is.hi.hbv501g.hbv501g.Persistance.Entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Repository fyrir Exercise. Inniheldur leitaraðferðir ásamt
 *  aðferðum til að vista og eyða exercise.
 *
 *****************************************************************************/


public interface ExerciseRepository extends JpaRepository<Exercise, Long > {
    Exercise save(Exercise exercise);
    void delete(Exercise exercise);
    List<Exercise> findAll();
    Exercise findByTitle(String title);
    List<Exercise> findByBodyPart(String body_part);
    List<Exercise> findByType(String type);
}
