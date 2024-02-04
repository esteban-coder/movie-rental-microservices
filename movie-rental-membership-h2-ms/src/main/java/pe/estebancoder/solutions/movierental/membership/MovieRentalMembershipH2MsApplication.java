package pe.estebancoder.solutions.movierental.membership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MovieRentalMembershipH2MsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRentalMembershipH2MsApplication.class, args);
    }

}
