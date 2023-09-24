package homework3.dataaccess.controller;

import homework3.dataaccess.repository.User;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@EnableResourceServer
@EnableAuthorizationServer
@RequestMapping("/")
public class SecureController {
    private final User userList;

    public SecureController(User user) {
        this.userList = user;
    }

    @GetMapping("/User")
    @Secured("Read")
    public String methodForUser(){
        return "You're user";
    }

    @GetMapping("/BusinessAdmin")
    @RolesAllowed("Write")
    public String methodForBA(){
        return "You're Business Admin";
    }

    @GetMapping("/SystemAdmin")
    @PreAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    public String methodForSA(){
        return "You're System Admin";
    }

    @GetMapping("/UserName")
    public String methodeForUserList(@RequestParam("user") String user){
        return "You're name is" + userList.getUserName();
    }

}
