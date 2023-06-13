package Felix.MyHome.repository;

import Felix.MyHome.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository


public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserById (int id);


    void deleteByUsername (String username);

    List<User> findAll ();



}
