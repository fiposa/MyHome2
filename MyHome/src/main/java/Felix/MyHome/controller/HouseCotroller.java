package Felix.MyHome.controller;

import Felix.MyHome.model.House;
import Felix.MyHome.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

//@PreAuthorize("hasRole('USER')")
@RequestMapping("/house")

public class HouseCotroller {


    private final HouseService houseService;
    private final RekuperatorService rekuperatorService;
    private final UserService userService;

    private final KotelnayaService kotelnayaService;

    private final GateService gateService;
    @Autowired

    public HouseCotroller(HouseService houseService, RekuperatorService rekuperatorService, UserService userService, KotelnayaService kotelnayaService, GateService gateService) {
        this.houseService = houseService;
        this.rekuperatorService = rekuperatorService;
        this.userService = userService;
        this.kotelnayaService = kotelnayaService;
        this.gateService = gateService;
    }
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("houses", houseService.findAll());
        System.out.println("should have seen houses page.");

        return "house/index";
    }

    //@PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("house", houseService.showConcreteHouse(id));
        model.addAttribute("rekuperator", rekuperatorService.findRekupertorByHouseId(id));
        model.addAttribute("kotelnaya", kotelnayaService.findKotelnayaByHouseId(id) );
        model.addAttribute("gates",gateService.findGateByHouseId(id));
        System.out.println(gateService.findGateByHouseId(id));

        return "/house/show";
    }
    @GetMapping ("/{id}/edit")
    public String edit (Model model, @PathVariable ("id") int id){
        model.addAttribute("house",houseService.showConcreteHouse(id));
        return "/house/edit";

    }

    @PatchMapping("{id}")
    public String updateName (@ModelAttribute ("house") House house, @PathVariable ("id") int id){
        houseService.editHouseName(id, house);
        return "redirect:/house/index";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable ("id") int id){
        houseService.deleteHouseById(id);
        return "redirect:/house/index";
    }



    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/create")
    public String create (){
        return "/house/new";
    }


}
