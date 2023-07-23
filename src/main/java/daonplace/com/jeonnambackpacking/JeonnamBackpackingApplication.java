package daonplace.com.jeonnambackpacking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class JeonnamBackpackingApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeonnamBackpackingApplication.class, args);
    }

}
