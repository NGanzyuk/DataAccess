package homework3.dataaccess.controller;

import homework3.dataaccess.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam("name") String name) throws SQLException {
        return repository.getProductName(name);
    }

}
