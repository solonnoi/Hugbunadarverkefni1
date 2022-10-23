package is.hi.hbv501g.hbv501g.Services;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Exercise;
import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;

import java.util.List;

public interface ExerciseService {
    Exercise save(Exercise exercise);

    void delete(Exercise exercise);

    List<Exercise> findAll();

    Exercise findByTitle(String title);

    List<Exercise> findByBodyPart(String body_part);

    List<Exercise> findByType(String type);

    List<Exercise> listAll();



}
