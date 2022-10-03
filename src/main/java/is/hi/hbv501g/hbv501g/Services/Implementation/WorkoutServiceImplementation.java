package is.hi.hbv501g.hbv501g.Services.Implementation;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import is.hi.hbv501g.hbv501g.Persistance.Repositories.WorkoutRepository;
import is.hi.hbv501g.hbv501g.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImplementation implements WorkoutService {
    // Connection to the repo
    private WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutServiceImplementation(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public Workout findByTitle(String title) {
        // Only returns the first workout that matches the title
        return workoutRepository.findByTitle(title).get(0);
    }

    @Override
    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    @Override
    public Workout findByID(long ID) {
       return workoutRepository.findByID(ID);
    }

    @Override
    public Workout save(Workout workout) {
      return workoutRepository.save(workout);
    }

    @Override
    public void delete(Workout workout) {
        workoutRepository.delete(workout);
    }
    @Override
    public List<Workout> listAll(String keyword) {
        if (keyword != null) {
            return workoutRepository.search(keyword);
        }
        return workoutRepository.findAll();
    }
}
