package Felix.MyHome.controller;

import Felix.MyHome.model.Gate;
import Felix.MyHome.model.House;
import Felix.MyHome.service.GateService;
import Felix.MyHome.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gate")
public class GateController {

    private final GateService gateService;
    private final HouseService houseService;



    public GateController(GateService gateService, HouseService houseService) {
        this.gateService = gateService;
        this.houseService = houseService;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("gates", gateService.viewAllGates());
        System.out.println("should have seen gates page.");

        return "gate/index";
    }

   // @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("gate", gateService.findGateById(id));
        return "/gate/show";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/new")
    public String newGate (@ModelAttribute ("gate") Gate gate, @ModelAttribute ("house") House house,
                           Model model){
        model.addAttribute("houses", houseService.findAll());

        return "/gate/new";
    }
    @PostMapping("")
    public String create (@ModelAttribute ("gate") Gate gate){
        gateService.save(gate);
        return "redirect:/gate";

    }


}

