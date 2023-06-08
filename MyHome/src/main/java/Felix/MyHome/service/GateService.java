package Felix.MyHome.service;

import Felix.MyHome.model.Gate;
import Felix.MyHome.repository.GatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //(readOnly = true)//для методов, которые изменяют, просто добавляем отдельную аннотацию @Transactional
public class GateService {

    public final GatesRepository gatesRepository;

    @Autowired

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
    public void openGate (int id, Gate updatedGate){
        updatedGate.setId(id);
        updatedGate.setGateOpen(true);
        gatesRepository.save(updatedGate);
        System.out.println("Gates " +updatedGate.getName()+ " are open");
    }

    @Transactional
    public void closeGate (int id, Gate updatedGate){
        updatedGate.setId(id);
        updatedGate.setGateOpen(false);
        gatesRepository.save(updatedGate);
        System.out.println("Gates " +updatedGate.getName()+ " are closed");
    }

    @Transactional
    public void deleteGate (int id){
        gatesRepository.deleteById(id);
        System.out.println("Gates  are deleted");
    }




}
