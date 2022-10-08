package is.hi.hbv501g.hbv501g.Services;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Exercise;

import java.util.List;

public interface ExcerciseService {
    Exercise save(Exercise exercise);

    void delete(Exercise exercise);

    List<Exercise> findAll();

    List<Exercise> findByTitle(String title);

    List<Exercise> findByBodyPart(String body_part);

    List<Exercise> findByType(String type);

}
