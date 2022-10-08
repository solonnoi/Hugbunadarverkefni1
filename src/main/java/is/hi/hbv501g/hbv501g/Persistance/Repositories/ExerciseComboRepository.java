package is.hi.hbv501g.hbv501g.Persistance.Repositories;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Exercise;
import is.hi.hbv501g.hbv501g.Persistance.Entities.ExerciseCombo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseComboRepository extends JpaRepository<ExerciseCombo, Long > {
    ExerciseCombo save(ExerciseCombo exerciseCombo);
    void delete(ExerciseCombo exerciseCombo);
    List<ExerciseCombo> findAll();
    ExerciseCombo findByID(long ID);
}

