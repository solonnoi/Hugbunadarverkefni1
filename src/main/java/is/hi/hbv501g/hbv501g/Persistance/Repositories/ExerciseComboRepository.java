package is.hi.hbv501g.hbv501g.Persistance.Repositories;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Exercise;
import is.hi.hbv501g.hbv501g.Persistance.Entities.ExerciseCombo;
import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseComboRepository extends JpaRepository<ExerciseCombo, Long > {
    ExerciseCombo save(ExerciseCombo exerciseCombo);
    void delete(ExerciseCombo exerciseCombo);
    List<ExerciseCombo> findAll();
    // viljum vænt bara finna eftir w/o id
    ExerciseCombo findByID(long ID);

    // TODO: 17.10.2022 athuga hvort þetta eigi að vera
    //  listi af Excombos
    ExerciseCombo findByExercise(Exercise exercise);
    List<ExerciseCombo> findByWorkout(Workout workout);
}

