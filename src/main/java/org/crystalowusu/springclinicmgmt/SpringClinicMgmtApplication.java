package org.crystalowusu.springclinicmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication  (exclude = {SecurityAutoConfiguration.class })
public class SpringClinicMgmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringClinicMgmtApplication.class, args);

    }

}
