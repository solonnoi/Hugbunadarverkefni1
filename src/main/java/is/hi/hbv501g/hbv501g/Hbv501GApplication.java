package is.hi.hbv501g.hbv501g;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// Halló, þetta er sólon

@SpringBootApplication
@RestController
public class Hbv501GApplication {
    public static void main(String[] args) {
        SpringApplication.run(Hbv501GApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
