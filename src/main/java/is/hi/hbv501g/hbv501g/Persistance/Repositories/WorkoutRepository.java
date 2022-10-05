package is.hi.hbv501g.hbv501g.Persistance.Repositories;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    Workout save(Workout workout);
    void delete(Workout workout);
    List<Workout> findAll();
    List<Workout> findByTitle(String title);
    Workout findByID(long ID);

    @Query("SELECT w FROM Workout w WHERE CONCAT(w.title, w.duration, w.description) LIKE %?1%")
    public List<Workout> search(String keyword);


}
