package is.hi.hbv501g.hbv501g.Services;
import is.hi.hbv501g.hbv501g.Persistance.Entities.ExerciseCombo;
import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import java.util.List;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Service fyrir ExerciseCombo. Inniheldur leitaraðferðir ásamt
 *  aðferðum til að vista og eyða exerciseCombo.
 *
 *****************************************************************************/

public interface ExerciseComboService {
    ExerciseCombo findByExercise(String title);
    List<ExerciseCombo> findAll();
    ExerciseCombo findByID(long ID);
    ExerciseCombo save(ExerciseCombo exerciseCombo);
    void delete(ExerciseCombo exerciseCombo);
    List<ExerciseCombo> findByWorkout(Workout workout);

}
