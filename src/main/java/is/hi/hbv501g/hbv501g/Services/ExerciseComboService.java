package is.hi.hbv501g.hbv501g.Services;

import is.hi.hbv501g.hbv501g.Persistance.Entities.ExerciseCombo;

import java.util.List;

public interface ExerciseComboService {

    ExerciseCombo findByTitle(String title);
    List<ExerciseCombo> findAll();
    ExerciseCombo findByID(long ID);
    ExerciseCombo save(ExerciseCombo exerciseCombo);
    void delete(ExerciseCombo exerciseCombo);
    List<ExerciseCombo> listAll(String keyword);

}
