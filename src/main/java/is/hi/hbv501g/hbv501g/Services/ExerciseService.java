package is.hi.hbv501g.hbv501g.Services;
import is.hi.hbv501g.hbv501g.Persistance.Entities.Exercise;
import java.util.List;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Service fyrir Exercise. Inniheldur leitaraðferðir ásamt
 *  aðferðum til að vista og eyða exerciseCombo.
 *
 *****************************************************************************/
public interface ExerciseService {
    Exercise save(Exercise exercise);

    void delete(Exercise exercise);

    List<Exercise> findAll();

    Exercise findByTitle(String title);

    List<Exercise> findByBodyPart(String body_part);

    List<Exercise> findByType(String type);

    List<Exercise> listAll();

}
