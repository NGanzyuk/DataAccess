package homework3.dataaccess.repository;

import org.springframework.stereotype.Repository;

@Repository
public class User {
    private String user;
    private String userName;
    private User(){
        user = "qwer";
        userName = "Petya";
    }

    public String getUserName() {
        return userName;
    }

    public String getUser() {
        return user;
    }
}
