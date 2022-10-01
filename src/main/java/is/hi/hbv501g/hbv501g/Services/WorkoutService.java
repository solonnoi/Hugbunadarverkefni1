package is.hi.hbv501g.hbv501g.Services;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutService {
        Workout findByTitle(String title);
        List<Workout> findAll();
        Workout findByID(long ID);
        Workout save(Workout workout);
        void delete(Workout workout);
        List<Workout> listAll(String keyword);
}
