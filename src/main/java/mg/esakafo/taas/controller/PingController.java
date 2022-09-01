package mg.esakafo.taas.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PingController {

    @GetMapping("/")
    public String Hello(){
        return "Welcome to E-Kaly API";
    }

    @GetMapping("/ping")
    public String ping(){
        return "Pong";
    }
}
