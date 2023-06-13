package Felix.MyHome;

import Felix.MyHome.model.*;
import Felix.MyHome.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MyHomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyHomeApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder,
										HouseRepository houseRepository, RoomRepository roomRepository,
										GatesRepository gatesRepository, RekuperatorRepository rekuperatorRepository,
										KotelnayaRepository kotelnayaRepository) {
		return args -> {
//			roomRepository.save(new Room("room1",1500,1200,
//					true,rekuperatorRepository.findRekuperatorById(1)));
//			roomRepository.save(new Room("room2",200,12200,
//					true,rekuperatorRepository.findRekuperatorById(1)));
//			roomRepository.save(new Room("room3",15300,12040,
//					true,rekuperatorRepository.findRekuperatorById(1)));
//			roomRepository.save(new Room("room4",1500,1200,
//					true,rekuperatorRepository.findRekuperatorById(2)));
//			roomRepository.save(new Room("room5",1500,1200,
//					true,rekuperatorRepository.findRekuperatorById(2)));
//			roomRepository.save(new Room("room6",15060,12060,
//					true,rekuperatorRepository.findRekuperatorById(2)));

			//System.out.println(gatesRepository.findGateByHouseId(2));
			//System.out.println(rekuperatorRepository.findRekuperatorByHouse_Id(1));

//
//			kotelnayaRepository.save(new Kotelnaya("kotelnaya1",houseRepository.findHouseById(1).orElse(null)));
//			kotelnayaRepository.save(new Kotelnaya("kotelnaya2",houseRepository.findHouseById(2).orElse(null)));
//
//
//			rekuperatorRepository.save(new Rekuperator("rekup1", houseRepository.findHouseById(1).orElse(null)));
//			rekuperatorRepository.save(new Rekuperator("rekup2", houseRepository.findHouseById(2).orElse(null)));
//			houseRepository.save(new House("house1",users.findUserById(1).orElse(null),"Lenina5-25",
//					rekuperatorRepository.findRekuperatorById(1),gatesRepository.findGateById(1),
//					kotelnayaRepository.findKotelnayaById(1)));
//
//			houseRepository.save(new House("house2",users.findUserById(2).orElse(null),"Rovio 2-22",
//					rekuperatorRepository.findRekuperatorById(2),gatesRepository.findGateById(2),
//					kotelnayaRepository.findKotelnayaById(2)));



//			System.out.println(houseRepository.findHousesByUser_Email("fiposa@inbox.ru"));





//			houseRepository.save(new House("House2",null,
//					"Lenina525", null,null));
//
//			gatesRepository.save(new Gate("Vrata1",false,
//					houseRepository.findById(1).orElse(null) ));
//
//			gatesRepository.save(new Gate("Vrata2",true,
//					houseRepository.findById(2).orElse(null) ));



			//Если написать не ROLE_ADMIN, а ADMIN, то не будет работать, и в юзере поле д.б. именно role, а не roles
			//users.save(new User("fiposa", encoder.encode("pass"), "ROLE_USER","fiposa@inbox.ru"));
			//users.save(new User("fiposa2", encoder.encode("pass"), "ROLE_USER", "fiposa2@inbox.ru"));
			//users.save(new User("admin", encoder.encode("pass"), "ROLE_ADMIN", "admin@ma.ru"));
			//users.save(new User("father", encoder.encode("pass"), "ROLE_FATHER, ROLE_ADMIN", "father@mail.ru"));



			//roomRepository.save(new Room("room25",23,45,45,true,houseRepository.findHouseByHouseName("house2").orElseThrow()));
//			roomRepository.save(new Room("room2",23,45,45,
//					true));
//			roomRepository.save(new Room("room1",23,45,45,
//					true));
//			roomRepository.save(new Room("room2",23,45,45,
//					true));
//			roomRepository.save(new Room("room3",23,45,45,
//					true)).setHouse(houseRepository.findHouseByHouseName("house1").orElseThrow());








		};
	}

}
