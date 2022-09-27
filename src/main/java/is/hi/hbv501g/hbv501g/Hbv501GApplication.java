package is.hi.hbv501g.hbv501g;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Halló, þetta er sólon
// Hæ, magnea hér
//Hæhæ, git er lit kv. hafsteinn
//bull

// ATH er ekki viss um að maður eigi að láta þetta virka svona en núna ef maður setur inn
// Url-ið "http://localhost:8080/yeahBuddy" og keyrir þá ætti e-ð að koma.

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class Hbv501GApplication {
    public static void main(String[] args) {
        SpringApplication.run(Hbv501GApplication.class, args);
    }
    @GetMapping("/yeahBuddy")
    public String hello(@RequestParam(value = "yeah", defaultValue = "Buddy") String name) {
        return String.format("Hello %s!", name);
    }

}
