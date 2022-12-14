package is.hi.hbv501g.hbv501g.Services.Implementation;
import is.hi.hbv501g.hbv501g.Persistance.Entities.ExerciseCombo;
import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import is.hi.hbv501g.hbv501g.Persistance.Repositories.ExerciseComboRepository;
import is.hi.hbv501g.hbv501g.Persistance.Repositories.ExerciseRepository;
import is.hi.hbv501g.hbv501g.Persistance.Repositories.WorkoutRepository;
import is.hi.hbv501g.hbv501g.Services.ExerciseComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Implementation á ExerciseComboService. Inniheldur leitaraðferðir
 *  ásamt því að hafa aðferðir sem eyða og vista exerciseCombo. Klasinn talar
 *  við ExerciseComboRepository og kallar á aðferðirnar sem eru þar.
 *
 *****************************************************************************/


@Service
public class ExerciseComboServiceImplementation implements ExerciseComboService {

    private ExerciseComboRepository exerciseComboRepository;
    private ExerciseRepository exerciseRepository;

    private WorkoutRepository workoutRepository;

    @Autowired
    public ExerciseComboServiceImplementation(ExerciseComboRepository exerciseComboRepository) {
        this.exerciseComboRepository = exerciseComboRepository;
    }

    @Override
    public ExerciseCombo findByExercise(String title) {
        return exerciseComboRepository.findByExercise(exerciseRepository.findByTitle(title));
    }

    @Override
    public List<ExerciseCombo> findAll() {
        return exerciseComboRepository.findAll();
    }

    @Override
    public ExerciseCombo findByID(long ID) {
        return exerciseComboRepository.findByID(ID);
    }

    // TODO: 17.10.2022 Bæta við ordering gæa
    @Override
    public ExerciseCombo save(ExerciseCombo exerciseCombo) {
        // Er þetta rétt hugsun?
       //exerciseCombo.setWorkout(workoutRepository.findByID(ID));
       return exerciseComboRepository.save(exerciseCombo);
    }

    @Override
    public void delete(ExerciseCombo exerciseCombo) {
        exerciseComboRepository.delete(exerciseCombo);
    }

    @Override
    public List<ExerciseCombo> findByWorkout(Workout workout) {
        return exerciseComboRepository.findByWorkout(workout);
    }
}
