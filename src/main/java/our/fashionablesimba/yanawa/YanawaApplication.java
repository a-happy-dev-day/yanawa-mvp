package our.fashionablesimba.yanawa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class YanawaApplication {

    public static void main(String[] args) {
        SpringApplication.run(YanawaApplication.class, args);
    }

}
