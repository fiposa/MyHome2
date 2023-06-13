package Felix.MyHome.controller;

import Felix.MyHome.service.HouseService;
import Felix.MyHome.service.RekuperatorService;
import Felix.MyHome.service.RoomService;
import Felix.MyHome.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rekuperator")
public class RekuperatorController {

    private final RekuperatorService rekuperatorService;
    private final RoomService roomService;


    public RekuperatorController(RekuperatorService rekuperatorService, RoomService roomService) {
        this.rekuperatorService = rekuperatorService;
        this.roomService = roomService;

    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("rekuperator", rekuperatorService.findRekuperatorById(id));
        model.addAttribute("rooms", roomService.findRoomsByRekuperatorId(id));


        return "/rekuperator/show";
    }


}
