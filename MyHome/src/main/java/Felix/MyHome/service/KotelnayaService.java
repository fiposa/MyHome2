package Felix.MyHome.service;

import Felix.MyHome.model.Kotelnaya;
import Felix.MyHome.repository.KotelnayaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class KotelnayaService {
    private final KotelnayaRepository kotelnayaRepository;

    public KotelnayaService(KotelnayaRepository kotelnayaRepository) {
        this.kotelnayaRepository = kotelnayaRepository;
    }



    public Kotelnaya findKotelnayaByHouseId (int id){
        return kotelnayaRepository.findKotelnayaByHouseId(id).orElse(null);
    }
    public Kotelnaya findKotelnayaById (int id) {
        return kotelnayaRepository.findKotelnayaById(id);
    }

}
