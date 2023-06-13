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
    @DeleteMapping ("/{id}/delete")
    public String delete (@PathVariable("id") int id) {
       gateService.deleteGate(id);
        return "redirect:/gate";
    }
    @GetMapping ("/gate/{id}/edit")
    public String edit (@PathVariable("id") int id, Model model) {
        model.addAttribute("gate", gateService.findGateById(id));
        model.addAttribute("houses", houseService.findAll());
        return "gate/edit";
    }
    @PatchMapping ("/{id}")
    public String update (@PathVariable ("id") int id, @ModelAttribute ("gate") Gate gate){
        gateService.update(id, gate);
        return "redirect:/gate/{id}";
    }
    @PatchMapping ("/{id}/open")
    public String open (@PathVariable ("id") int id, @ModelAttribute ("gate") Gate gate){
        gateService.open(id, gate);
        return "redirect:/gate/{id}";
    }
    @PatchMapping ("/{id}/close")
    public String close (@PathVariable ("id") int id, @ModelAttribute ("gate") Gate gate){
        gateService.close(id, gate);
        return "redirect:/gate/{id}";
    }







}

