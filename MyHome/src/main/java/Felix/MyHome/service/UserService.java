package Felix.MyHome.service;

import Felix.MyHome.model.User;
import Felix.MyHome.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getCurrentUser (){

        return userRepository.findUserByUsername(SecurityContextHolder.getContext().
                getAuthentication().getName()).orElseThrow();
    }

    public int getCurrentUserId() {
        return getCurrentUser().getId();
    }

    public String showNameOfCurrentUser () {
        User currentUser = userRepository.findUserByUsername(SecurityContextHolder.getContext().
                getAuthentication().getName()).orElseThrow();



        return currentUser.getUsername();
    }
}
