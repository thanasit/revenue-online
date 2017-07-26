package th.or.pao.revenueonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import th.or.pao.revenueonline.configuration.JpaConfiguration;

@SpringBootApplication(scanBasePackages = {"th.or.pao.revenueonline"})
public class RevenueOnlineApp {

    public static void main(String[] args) {
        SpringApplication.run(RevenueOnlineApp.class, args);
    }

}