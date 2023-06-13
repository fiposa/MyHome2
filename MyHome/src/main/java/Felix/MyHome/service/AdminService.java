package Felix.MyHome.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    @PreAuthorize("hasRole('ADMIN')")

    public void adminWrite(){
        System.out.println("Only admin can write it");
    }
}
