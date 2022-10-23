package is.hi.hbv501g.hbv501g.Services.Implementation;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Exercise;
import is.hi.hbv501g.hbv501g.Persistance.Repositories.ExerciseRepository;
import is.hi.hbv501g.hbv501g.Services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImplementation implements ExerciseService {

    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImplementation(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }
    @Override
    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public void delete(Exercise exercise) {
        exerciseRepository.delete(exercise);
    }

    @Override
    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public Exercise findByTitle(String title) {
        return exerciseRepository.findByTitle(title);
        // ekki eins og w/o
    }

    @Override
    public List<Exercise> findByBodyPart(String body_part) {
        return exerciseRepository.findByBodyPart(body_part);
    }

    @Override
    public List<Exercise> findByType(String type) {
        return exerciseRepository.findByType(type);
    }

    @Override
    public List<Exercise> listAll() {
        return null;
    }

}
