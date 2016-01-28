package com.udemy;

import com.mangofactory.swagger.plugin.EnableSwagger;
import com.udemy.config.PojoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@EnableAutoConfiguration
@SpringBootApplication
@EnableSwagger
public class MicroservicesApplication {


    @Value("${configuration.projectVersion}")
    void setProjectVersion(String projectVersion) {
        System.out.println("************************************");
        System.out.println("projectVersion: " + projectVersion);
    }

    @Autowired
    void setPojoConfig(PojoConfig pojoConfig) {
        System.out.println("************************************");
        System.out.println("getting pojo values: " + pojoConfig.getProjectVersion());
    }

    @Autowired
    void setEnvironment(Environment environment) {
        System.out.println("************************************");
        System.out.println("From Environment: " + environment.getProperty("configuration.projectVersion"));
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesApplication.class, args);
    }
}
