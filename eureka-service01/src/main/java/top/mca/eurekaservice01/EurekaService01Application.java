package top.mca.eurekaservice01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableEurekaServer
public class EurekaService01Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaService01Application.class, args);
    }

    /**
     * 配置安全过滤规则
     */
    @EnableWebSecurity
    static class MyWebConfig extends WebSecurityConfigurerAdapter{
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            super.configure(http);
            http.csrf().ignoringAntMatchers("/eureka/**");
        }
    }

}
