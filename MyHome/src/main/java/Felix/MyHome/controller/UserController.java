package Felix.MyHome.controller;

import Felix.MyHome.model.User;
import Felix.MyHome.repository.UserRepository;
import Felix.MyHome.service.AdminService;
import Felix.MyHome.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping
@EnableMethodSecurity
public class UserController {

    //SecurityUser securityUser;

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    AdminService adminService;

    @Autowired

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    @GetMapping("/")
    public String hello(){
        return "Hello!!!!!!!";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER','GOD')")
    @GetMapping("all")
    public List<User> viewAll(){
        return userRepository.findAll();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    //@PreAuthorize("hasAnyRole('ADMIN','USER','GOD')")
    @GetMapping("/admin")

    @Secured(value = {"ROLE_ADMIN"})
    public String admin() {
        //@Secured(value = {"ROLE_ADMIN"})
        adminService.adminWrite();//Блокируем не на уровне адреса, как в конфиге, а на уровне метода
        //страничка откроется только у админа, всем остальным доступ к ней закрыт. но надо внедрить бин и конструктор
        return "Hello, Admin!";
    }


    @GetMapping("/auth")
    public String auth() {
        return "Hello, ALL AUTHENTICATED!";
    }

    @PreAuthorize("hasRole('GOD')")
    @GetMapping("/god")
    public String god() {
        return "Hello, God!";
    }

    @PreAuthorize("hasRole('USER')")

    @GetMapping("/user")

    public String user() {

       String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
       System.out.println(currentUserName);
       User currentUser =  userRepository.findUserByUsername(currentUserName).orElseThrow();
       System.out.println(currentUser.getEmail());
       System.out.println(userRepository.findUserByUsername(currentUserName).get().getEmail());// get() позволяет не создавать изера, а получить чтото из опшионал.
       sendEmailService.sendEmail(currentUser.getEmail(),"Dear "+currentUser.getUsername()+" !!!", "You are logged in");
       return "Hello, User! Check your mailbox!";
       //TODO Поискать, как выковырять емайл из контекста, чтоб не искать в базе по имени.
        //Если таймстамп последней записи старше на минуту, чем текущий таймстамп, то отправка емайла с предупреждением о потери связи
    }


    @GetMapping("/info")
    public Object Info(){ //выдает инфу о пользователе.
        return   SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //if (!SecurityContext.GetUser().HasRight("GetBook"))
        //    throw new AuthException("Permission Denied"); ПОТОМ ДОБАВИТЬ ДЛЯ ОГРАНИЧЕНИЯ ДОСТУПА К МЕТОДАМ

    }
    @GetMapping("/info2")
    public Object  Info2(){ //показывает роль пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List currentPrincipalRole = authentication.getAuthorities().stream().toList();
        return currentPrincipalRole;
    }


}
