package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Wichtige SpringBootApplication Annotation welche einnalig in der Runnable Main Klasse verwendet wird und als Startpunkkt der APplikation dient
 */
@SpringBootApplication
@RestController
@RequestMapping("/test/api")
public class Fussballapplikation {

    /**
     * Runnable Main Applikation im Root Example  über allen Packages Controller, Service und Repository liegt
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Fussballapplikation.class, args);}


    /**
     * Test Request für Funktionalität Rest APplikation mit Greeting HTTP Methode
     *
     * @param name the name
     * @return name
     */
    @GetMapping("/greetings")
    public ResponseEntity<String> sayHelloWorld(@RequestParam(defaultValue= "World") String name) {
        return ResponseEntity.ok("Hello "+ name);
    }   


}
