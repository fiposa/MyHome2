package Felix.MyHome.controller;

import Felix.MyHome.model.Gate;
import Felix.MyHome.model.House;
import Felix.MyHome.model.SecurityUser;
import Felix.MyHome.service.GateService;
import Felix.MyHome.service.HouseService;
import Felix.MyHome.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@PreAuthorize("hasAnyRole('USER','ADMIN')")
@RequestMapping("/gate")
public class GateController {
    private final GateService gateService;
    private final HouseService houseService;
    private final UserService userService;
    public GateController(GateService gateService, HouseService houseService, UserService userService) {
        this.gateService = gateService;
        this.houseService = houseService;
        this.userService = userService;
    }
    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public String index(Model model) {
        model.addAttribute("gates", gateService.viewAllGates());
        return "gate/index";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("gate", gateService.findGateById(id));
        model.addAttribute("role", userService.CurrentUser().getRole());
        return "/gate/show";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/new")
    public String newGate (@ModelAttribute ("gate") Gate gate, @ModelAttribute ("house") House house,
                           Model model){
        model.addAttribute("houses", houseService.findAll());
        return "/gate/new";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("")
    public String create (@ModelAttribute ("gate") Gate gate){
        gateService.save(gate);
        return "redirect:/gate";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/{id}/delete")
    public String delete (@PathVariable("id") int id) {
       gateService.deleteGate(id);
        return "redirect:/gate";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping ("/gate/{id}/edit")
    public String edit (@PathVariable("id") int id, Model model) {
        model.addAttribute("gate", gateService.findGateById(id));
        model.addAttribute("houses", houseService.findAll());
        return "gate/edit";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping ("/{id}")
    public String update (@PathVariable ("id") int id, @ModelAttribute ("gate") Gate gate){
        gateService.update(id, gate);
        return "redirect:/gate/{id}";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PatchMapping ("/{id}/open")
    public String open (@PathVariable ("id") int id, @ModelAttribute ("gate") Gate gate){
        gateService.open(id, gate);
        return "redirect:/gate/{id}";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PatchMapping ("/{id}/close")
    public String close (@PathVariable ("id") int id, @ModelAttribute ("gate") Gate gate){
        gateService.close(id, gate);
        return "redirect:/gate/{id}";
    }

}

