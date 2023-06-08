package Felix.MyHome.service;

import Felix.MyHome.model.House;
import Felix.MyHome.repository.HouseRepository;
import Felix.MyHome.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HouseService {

    private final HouseRepository houseRepository;

    private final UserRepository userRepository;

    public HouseService(HouseRepository houseRepository, UserRepository userRepository) {
        this.houseRepository = houseRepository;
        this.userRepository = userRepository;
    }

    public List<House> findAll (){
        return houseRepository.findAll();
    }

    public House showConcreteHouse(int id) {
        return findAll().stream().filter(house -> house.getId()==id).findAny().orElse(null);
        //можно было и в репозитории сделать, но захотелось вытащить из стрима.

    }

    public List<House> showHousesOfConcreteUser (int id){
        return houseRepository.findHousesByUserId(id);
    }

    public List<House> showHousesOfCurrentUser () {

        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userRepository.findUserByUsername(currentUserName).get().getId();

        return houseRepository.findHousesByUserId(currentUserId);
    }
    public void deleteHouseById (int id){
        houseRepository.deleteHouseById(id);
    }

    public void editHouseName (int id, House updatedHouse ){
        House houseToBeUpdated = showConcreteHouse(id);
        houseToBeUpdated.setName(updatedHouse.getName());

    }






}
