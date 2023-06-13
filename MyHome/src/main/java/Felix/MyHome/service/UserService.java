package Felix.MyHome.service;

import Felix.MyHome.model.SecurityUser;
import Felix.MyHome.model.User;
import Felix.MyHome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class UserService {

    private final UserRepository userRepository;
    private final SecurityUser securityUser;


    public UserService(UserRepository userRepository, SecurityUser securityUser) {
        this.userRepository = userRepository;
        this.securityUser = securityUser;
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
    public User CurrentUser(){

        return userRepository.findUserByUsername(SecurityContextHolder.getContext().
                getAuthentication().getName()).orElseThrow();
    }

}
