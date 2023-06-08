package Felix.MyHome.controller;

import Felix.MyHome.service.HouseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersHouseController {



        private final HouseService houseService;



    public UsersHouseController(HouseService houseService) {
        this.houseService = houseService;
    }





        @PreAuthorize("hasAnyRole('USER','ADMIN')")
        @GetMapping("/userhouse/check")
        public String check( Model model) {
            model.addAttribute("houses", houseService.showHousesOfCurrentUser());
            return "/house/check";
        }



    }



