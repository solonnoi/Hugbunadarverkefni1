package is.hi.hbv501g.hbv501g.Services.Implementation;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import is.hi.hbv501g.hbv501g.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutServiceImplementation implements WorkoutService {
    // If we have a repo we but the connection here
    private List<Workout> workoutRepo = new ArrayList<>();
    private int id_counter =0;

    @Autowired
    public WorkoutServiceImplementation() {
        // Create 3 random workouts for our dummy repo. To be removed when JPA Added.
        // Has not been added for now :(
        workoutRepo.add(new Workout("Morning Bicep",20, "Bicep in the morning bby"));
        workoutRepo.add(new Workout("Midday Bicep",40, "Bicep at lunchtime mf"));
        workoutRepo.add(new Workout("Dinner Bicep",60, "What do you think this is? "));
        // JPA gives each book an id but here we add them manually
        for(Workout b: workoutRepo){
            b.setID(id_counter);
            id_counter++;
        }
    }

    @Override
    public Workout findByTitle(String title) {
        for (Workout b: workoutRepo){
            if(b.getTitle().equals(title)){
                return b;
            }
        }
        return null;
    }

    @Override
    public List<Workout> findAll() {
        return workoutRepo;
    }

    @Override
    public Workout findByID(long ID) {
        for (Workout b: workoutRepo){
            if(b.getID() == ID)
                return b;
        }
        return null;
    }

    @Override
    public Workout save(Workout workout) {
        workout.setID(id_counter);
        id_counter++;
        workoutRepo.add(workout);
        return workout;
    }

    @Override
    public void delete(Workout workout) {
        workoutRepo.remove(workout);
    }
}
