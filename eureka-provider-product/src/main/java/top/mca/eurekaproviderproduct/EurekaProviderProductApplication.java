package top.mca.eurekaproviderproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProviderProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderProductApplication.class, args);
    }

}
