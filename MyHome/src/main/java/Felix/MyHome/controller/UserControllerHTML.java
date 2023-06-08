package Felix.MyHome.controller;

import Felix.MyHome.repository.UserRepository;
import Felix.MyHome.service.HouseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class UserControllerHTML {
    private final HouseService houseService;
    private final UserRepository userRepository;

    public UserControllerHTML(HouseService houseService, UserRepository userRepository) {
        this.houseService = houseService;
        this.userRepository = userRepository;
    }


//    @GetMapping("/")
//    public String welcome (){
//        return "welcome";
//    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/users/welcome")
    public String welcomeUser (Model model){
        model.addAttribute("user_info", SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
       // System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        model.addAttribute("houses", houseService.showHousesOfCurrentUser());
        return "users/welcome";
    }
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            request.getSession().invalidate();
//            ;
//        }
//        return "redirect:/welcome";
//    }
//




}
