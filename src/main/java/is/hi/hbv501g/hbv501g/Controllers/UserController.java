package is.hi.hbv501g.hbv501g.Controllers;

import is.hi.hbv501g.hbv501g.Persistance.Entities.User;
import is.hi.hbv501g.hbv501g.Services.Implementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// 17:18
@Controller
public class UserController {

    private final UserServiceImplementation userServiceImplementation;

    @Autowired
    public UserController(UserServiceImplementation userServiceImplementation){
        this.userServiceImplementation = userServiceImplementation;
    }

    @RequestMapping(value= "/signup", method = RequestMethod.GET)
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new User());
        return "signup_page";
    }

    @RequestMapping(value= "/", method = RequestMethod.GET)
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String register(User user, BindingResult result, Model model){
        // TODO Mögulega laga þetta því þetta er einhver simplified útgáfa
        System.out.println("register request:" + user);
        User registeredUser = userServiceImplementation.registerUser(user.getLogin(), user.getPassword(), user.getEmail());
        return registeredUser == null ? "error_page1" : "redirect:/workouts";
    }

    // Viljum við skila sitthvorri error page ef username eða pw er vitlaust?
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login(User user, BindingResult result, Model model){
        System.out.println("login request:" + user);
        User authenticated = userServiceImplementation.authenticate(user.getLogin(), user.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "redirect:/workouts";
        }
        else {
            return "error_page";
        }
    }



    //End points to add
    // signup (GET, POST)
    // login (GET, POST)
    // loggedin (GET)



    /**
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupGET(User user){
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPOST(User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/signup";
        }
        User exists = userService.findByUsername(user.getUsername());
        if(exists == null){
            userService.save(user);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(User user){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(User user, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "login";
        }
        User exists = userService.login(user);
        if(exists != null){
            session.setAttribute("LoggedInUser", exists);
            model.addAttribute("LoggedInUser", exists);
            return "LoggedInUser";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public String loggedinGET(HttpSession session, Model model){
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser  != null){
            model.addAttribute("LoggedInUser", sessionUser);
            return "redirect:/";
        }
        return "redirect:/";
    }
    */
}
