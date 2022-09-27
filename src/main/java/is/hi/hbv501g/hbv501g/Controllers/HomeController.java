package is.hi.hbv501g.hbv501g.Controllers;

import is.hi.hbv501g.hbv501g.Persistance.Entities.Workout;
import is.hi.hbv501g.hbv501g.Services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Controller
public class HomeController {
    private WorkoutService workoutService;

    @Autowired
    public HomeController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @RequestMapping("/")
    public String homePage(Model model){
        // Call a method in a service class
        List<Workout> allWorkouts = workoutService.findAll();
        // Add some data to the model
        model.addAttribute("workouts",allWorkouts);
        return "home";
    }
    @RequestMapping(value = "/addWorkout", method = RequestMethod.GET)
    public String addWorkout(Workout workout ){
        return "newWorkout";
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String deleteWorkout(@PathVariable("id") long id,  Model model){
        Workout workoutToDelete = workoutService.findByID(id);
        workoutService.delete(workoutToDelete);
        return "redirect:/";
    }
}
