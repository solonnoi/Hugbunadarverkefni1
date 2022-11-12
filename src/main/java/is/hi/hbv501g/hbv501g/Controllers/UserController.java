package is.hi.hbv501g.hbv501g.Controllers;
import is.hi.hbv501g.hbv501g.Persistance.Entities.User;
import is.hi.hbv501g.hbv501g.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

/******************************************************************************
 *  Nafn    : Hópur 7
 *  T-póstur: sns25@hi.is, kjg18@hi.is, hrj53@hi.is, mmo15@hi.is
 *
 *  Lýsing  : Controller fyrir User klasann. Klasinn inniheldur aðferðir sem
 *  gerir notandanum kleift að búa til nýjan aðgang og skrá sig inn á sinn
 *  aðgang.
 *
 *****************************************************************************/

// Allt sem er ready og er að gera einhverja logík
// Lýsing á entities,
// 17:18
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupGET(User user) {
        return "signup_page";
    }

    /**
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPOST(User user, BindingResult result, Model model){
        if(result.hasErrors()) {
            return "redirect:/signup_page";
        }
        User exists = userService.findByUsername(user.getUsername());
        if(exists == null){
            userService.save(user);
        }
        return "redirect:/workouts";
    }

    /**
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginGET(User user){
        return "login_page";
    }

    /**
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String loginPOST(User user, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "error_page1";
        }
        User exists = userService.login(user);
        if(exists != null){
            session.setAttribute("LoggedInUser", exists);
            model.addAttribute("LoggedInUser", exists);
            System.out.println(user);
            return "redirect:/workouts";
        }
        return "redirect:/error_page1";
    }


    /**
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public String loggedinGET(HttpSession session, Model model){
        User sessionUser = (User) session.getAttribute("LoggedInUser");
        if(sessionUser != null) {
            model.addAttribute("LoggedInUser", sessionUser);
            // ATH breytti þessu - mögulega eitthvað skrítið
            return "LoggedInUser";
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session, Model model){
        session.invalidate();
        System.out.println("You are successfully logged out!");
        return "redirect:/";
    }

}
