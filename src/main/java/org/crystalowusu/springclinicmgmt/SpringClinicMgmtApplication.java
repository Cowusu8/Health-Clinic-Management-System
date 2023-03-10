package org.crystalowusu.springclinicmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication  //(exclude = {UserDetailsServiceAutoConfiguration.class})
@Configuration
public class SpringClinicMgmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringClinicMgmtApplication.class, args);

    }

}
