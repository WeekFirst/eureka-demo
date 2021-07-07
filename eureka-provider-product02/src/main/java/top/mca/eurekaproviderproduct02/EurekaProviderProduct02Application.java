package top.mca.eurekaproviderproduct02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProviderProduct02Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderProduct02Application.class, args);
    }

}
