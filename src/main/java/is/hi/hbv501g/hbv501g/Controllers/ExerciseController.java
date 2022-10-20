package is.hi.hbv501g.hbv501g.Controllers;

import is.hi.hbv501g.hbv501g.Persistance.Entities.ExerciseCombo;
import is.hi.hbv501g.hbv501g.Services.ExerciseComboService;
import is.hi.hbv501g.hbv501g.Services.WorkoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExerciseController {

    private ExerciseComboService exerciseComboService;
    private WorkoutService workoutService;

    public ExerciseController(ExerciseComboService exerciseComboService, WorkoutService workoutService) {
        this.exerciseComboService = exerciseComboService;
        this.workoutService = workoutService;
    }
    // Er kannski best að fara inn í add exerciseCombo með path variable workoutID og
    // bæta því þannig við workouts...
    // Þá geymum við uppl. hvaða workout við viljum bæta combo-inu við
    // Virkar náttúrulega ekki núna...

    //@GetMapping("/workout/{id}/addExercise")



    @RequestMapping(value = "addExerciseCombo" ,method = RequestMethod.GET)
    public String addExerciseComboForm(ExerciseCombo exerciseCombo/*,@PathVariable("id") long id*/){
        return "addExerciseCombo";
    }

    @RequestMapping(value = "/workout/{id}/addExercise",method = RequestMethod.POST)
    public String addExerciseCombo(ExerciseCombo exerciseCombo,@PathVariable("id") long id, BindingResult result, Model model){
        if(result.hasErrors()) {
            return "redirect:/addExerciseCombo";
        }
        // Uses to url to store what workout the exerciseCombo shall be added to
        // Þurfum við eitthvað meira hérna ?
        // Bæta við findById tékkara
         if(workoutService.findByID(id) == null) {
            return "redirect:/addExercise";
        }
        exerciseComboService.save(exerciseCombo/*, id*/);
        return "workout";
    }

}
