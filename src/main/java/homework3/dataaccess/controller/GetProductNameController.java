package homework3.dataaccess.controller;

import homework3.dataaccess.repository.GetProductNameRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetProductNameController {
    private final GetProductNameRepository repository;

    public GetProductNameController(GetProductNameRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam("name") String name) {
        return repository.getProductName(name);
    }

}
