package is.hi.hbv501g.hbv501g.Controllers;

import is.hi.hbv501g.hbv501g.Persistance.Entities.ExerciseCombo;
import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import is.hi.hbv501g.hbv501g.Services.ExerciseComboService;
import is.hi.hbv501g.hbv501g.Services.ExerciseService;
import is.hi.hbv501g.hbv501g.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.persistence.PostLoad;

/*
The Exercise Controllers
 */
@Controller
public class ExerciseController {
    private ExerciseComboService exerciseComboService;
    private WorkoutService workoutService;
    private ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseComboService exerciseComboService, WorkoutService workoutService, ExerciseService exerciseService) {
        this.exerciseComboService = exerciseComboService;
        this.exerciseService = exerciseService;
        this.workoutService = workoutService;
    }
    @RequestMapping(value = "workout/{id}/addExercise", method = RequestMethod.GET)
    public String addExerciseComboForm(ExerciseCombo exerciseCombo,@PathVariable("id") long id,Model model){
        Workout workoutToOpen = workoutService.findByID(id);
        model.addAttribute("workout", workoutToOpen);
        return "addExerciseCombo";
    }
    @RequestMapping(value = "/workout/{id}/addExercise", method = RequestMethod.POST)
    public String addExerciseCombo(ExerciseCombo exerciseCombo,@PathVariable("id") long workout_id, String exercise_title, int reps, int sets, double kg) {
        exerciseCombo.setExercise(exerciseService.findByTitle(exercise_title));
        exerciseCombo.setWorkout(workoutService.findByID(workout_id));
        exerciseComboService.save(exerciseCombo);
        return "redirect:/workout/{id}";
    }
    @RequestMapping(value="/deleteExercise/{workout_id}/{id}",method = RequestMethod.GET)
    public String deleteWorkout(@PathVariable("id") long id, @PathVariable("workout_id") String workout_id) {
        ExerciseCombo exerciseComboToDelete = exerciseComboService.findByID(id);
        exerciseComboService.delete(exerciseComboToDelete);
        //Workout workoutToDelete = workoutService.findByID(id);
        //workoutService.delete(workoutToDelete);
        return "redirect:/workout/{workout_id}";
    }
}