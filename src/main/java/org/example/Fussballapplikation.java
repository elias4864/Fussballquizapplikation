package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/test/api")
public class Fussballapplikation {

    public static void main(String[] args) {
        SpringApplication.run(Fussballapplikation.class, args);}


    @GetMapping("/greetings")
    public ResponseEntity<String> sayHelloWorld(@RequestParam(defaultValue= "World") String name) {
        return ResponseEntity.ok("Hello "+ name);
    }   


}
