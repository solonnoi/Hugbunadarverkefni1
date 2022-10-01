package is.hi.hbv501g.hbv501g.Controllers;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import is.hi.hbv501g.hbv501g.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
public class HomeController {
    private WorkoutService workoutService;

    @Autowired
    public HomeController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @RequestMapping("/")
    public String homePage(Model model, @Param("keyword") String keyword){
        // Call a method in a service class
        List<Workout> allWorkouts = workoutService.listAll(keyword);
        // Add some data to the model
        model.addAttribute("workouts",allWorkouts);
        model.addAttribute("keyword", keyword);
        return "home";
    }


    @RequestMapping(value = "/addWorkout",method = RequestMethod.GET)
    public String addWorkoutForm(Workout workout){
        return "addWorkout";
    }

    @RequestMapping(value = "/addWorkout",method = RequestMethod.POST)
    public String addWorkout(Workout workout, BindingResult result,Model model){
        if(result.hasErrors()){
            return "addWorkout";
        }
        workoutService.save(workout);
        return "redirect:/";
    }


    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET
    )
    public String deleteWorkout(@PathVariable("id") long id,  Model model){
        Workout workoutToDelete = workoutService.findByID(id);
        workoutService.delete(workoutToDelete);
        return "redirect:/";
    }
}
