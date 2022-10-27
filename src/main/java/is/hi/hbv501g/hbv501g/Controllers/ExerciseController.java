package is.hi.hbv501g.hbv501g.Controllers;
import is.hi.hbv501g.hbv501g.Persistance.Entities.ExerciseCombo;
import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import is.hi.hbv501g.hbv501g.Services.ExerciseComboService;
import is.hi.hbv501g.hbv501g.Services.ExerciseService;
import is.hi.hbv501g.hbv501g.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Controller fyrir Exercise klasann. Klasinn tala við eftirfarandi
 *  service: ExerciseComboService, WorkoutService og ExerciseService.
 *  Controllerinn hefur aðferðir bæta exercises við.
 *
 *****************************************************************************/

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
    // Er kannski best að fara inn í add exerciseCombo með path variable workoutID og
    // bæta því þannig við workouts...
    // Þá geymum við uppl. hvaða workout við viljum bæta combo-inu við
    // Virkar náttúrulega ekki núna...

    //@GetMapping("/workout/{id}/addExercise")


    /**
     *
     * @param
     * @return
     */
    @RequestMapping(value = "workout/{id}/addExercise", method = RequestMethod.GET)
    public String addExerciseComboForm(ExerciseCombo exerciseCombo,@PathVariable("id") long id,Model model){
        Workout workoutToOpen = workoutService.findByID(id);
        model.addAttribute("workout", workoutToOpen);

        return "addExerciseCombo";
    }

    /**
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/workout/{id}/addExercise", method = RequestMethod.POST)
    public String addExerciseCombo(ExerciseCombo exerciseCombo,@PathVariable("id") long workout_id, String exercise_title, int reps, int sets, double kg){
        exerciseCombo.setExercise(exerciseService.findByTitle(exercise_title));
        exerciseCombo.setWorkout(workoutService.findByID(workout_id));
        exerciseComboService.save(exerciseCombo);
        return "redirect:/workout/{id}";
    }
}