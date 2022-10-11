package is.hi.hbv501g.hbv501g.Services.Implementation;

import is.hi.hbv501g.hbv501g.Persistance.Entities.ExerciseCombo;
import is.hi.hbv501g.hbv501g.Persistance.Repositories.ExerciseComboRepository;
import is.hi.hbv501g.hbv501g.Persistance.Repositories.ExerciseRepository;
import is.hi.hbv501g.hbv501g.Persistance.Repositories.WorkoutRepository;
import is.hi.hbv501g.hbv501g.Services.ExerciseComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseComboServiceImplementation implements ExerciseComboService {

    private ExerciseComboRepository exerciseComboRepository;
    private ExerciseRepository exerciseRepository;

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

    @Override
    public ExerciseCombo save(ExerciseCombo exerciseCombo) {
        return exerciseComboRepository.save(exerciseCombo);
    }

    @Override
    public void delete(ExerciseCombo exerciseCombo) {
        exerciseComboRepository.delete(exerciseCombo);
    }
}
