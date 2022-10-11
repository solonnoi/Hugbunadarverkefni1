package is.hi.hbv501g.hbv501g.Controllers;

import is.hi.hbv501g.hbv501g.Persistance.Entities.ExerciseCombo;
import is.hi.hbv501g.hbv501g.Services.ExerciseComboService;
import is.hi.hbv501g.hbv501g.Services.ExerciseService;
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

    @RequestMapping(value = "/addExerciseCombo",method = RequestMethod.GET)
    public String addExerciseComboForm( ExerciseCombo exerciseCombo){
        return "addExerciseCombo";
    }

    @RequestMapping(value = "/addExerciseCombo",method = RequestMethod.POST)
    public String addExerciseCombo(ExerciseCombo exerciseCombo, BindingResult result, Model model){
        if(result.hasErrors()){
            return "addExerciseCombo";
        }
        exerciseComboService.save(exerciseCombo);
        return "redirect:/";
    }

}
