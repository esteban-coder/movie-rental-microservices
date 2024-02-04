package pe.estebancoder.solutions.movierental.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class MovieRentalCoreMysqlMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRentalCoreMysqlMsApplication.class, args);
    }

}
