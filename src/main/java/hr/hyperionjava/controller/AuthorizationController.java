package hr.hyperionjava.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hr.hyperionjava.model.Authorization;
import hr.hyperionjava.repository.AuthorizationRepository;

@RestController
public class AuthorizationController {

    private AuthorizationRepository authorizationRepository;

    public AuthorizationController(AuthorizationRepository authorizationRepository) {
        this.authorizationRepository = authorizationRepository;
    }

    @PostMapping("/authorizations")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Authorization authorization) {
    	authorizationRepository.save(authorization);
    }

    @GetMapping("/authorizations")
    public List<Authorization> getauthorizations() {
        return authorizationRepository.findAll();
    }
}
