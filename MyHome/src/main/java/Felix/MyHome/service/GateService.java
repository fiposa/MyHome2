package Felix.MyHome.service;

import Felix.MyHome.model.Gate;
import Felix.MyHome.model.SecurityUser;
import Felix.MyHome.repository.GatesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //(readOnly = true)//для методов, которые изменяют, просто добавляем отдельную аннотацию @Transactional
public class GateService {
    private final GatesRepository gatesRepository;
    public GateService(GatesRepository gatesRepository) {
        this.gatesRepository = gatesRepository;
    }

    public List <Gate> viewAllGates (){
        return gatesRepository.findAll();
    }

    public Gate findGateById(int id) {
        return gatesRepository.findById(id).orElse(null);
    }

    public boolean showIsGateOpen (int id) {
        return gatesRepository.findById(id).orElse(null).isGateOpen();
    }
    public List<Gate> findGateByHouseId (int id){
        return gatesRepository.findGateByHouseId(id);
    }

    @Transactional
    public void save(Gate gate){
        gatesRepository.save(gate);
        System.out.println("Gates created");
    }
    @Transactional
    public void deleteGate (int id){
        gatesRepository.deleteById(id);
        System.out.println("Gates  are deleted");
    }
    @Transactional
    public void update (int id, Gate updatedGate){
        Gate gateToBeUpdated = findGateById(id);
        gateToBeUpdated.setName(updatedGate.getName());
        gateToBeUpdated.setHouse(updatedGate.getHouse());
        gateToBeUpdated.setGateOpen(updatedGate.isGateOpen());
    }
    @Transactional
    public void open (int id, Gate updatedGate){
        Gate gateToBeUpdated = findGateById(id);
        gateToBeUpdated.setGateOpen(true);
        System.out.println("Gates " +gateToBeUpdated.getName()+ " are opened");
    }
    @Transactional
    public void close (int id, Gate updatedGate){
        Gate gateToBeUpdated = findGateById(id);
        gateToBeUpdated.setGateOpen(false);
        System.out.println("Gates " +gateToBeUpdated.getName()+ " are closed");
    }
    @Transactional
    public void delay (int id, Gate updatedGate){
        Gate gateToBeUpdated = findGateById(id);
        gateToBeUpdated.setDelay(updatedGate.getDelay());
        System.out.println("Gate delay updated");
    }


}
