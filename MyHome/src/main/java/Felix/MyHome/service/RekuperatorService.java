package Felix.MyHome.service;

import Felix.MyHome.model.Rekuperator;
import Felix.MyHome.repository.RekuperatorRepository;
import org.springframework.stereotype.Service;

@Service
public class RekuperatorService {

    private final RekuperatorRepository rekuperatorRepository;

    public RekuperatorService(RekuperatorRepository rekuperatorRepository) {
        this.rekuperatorRepository = rekuperatorRepository;
    }

    public Rekuperator findRekuperatorById (int id){
        return rekuperatorRepository.findRekuperatorById(id);
    }

    public Rekuperator findRekupertorByHouseId (int id) {
        return rekuperatorRepository.findRekuperatorByHouse_Id(id);
    }


}
