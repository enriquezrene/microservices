package com.udemy.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by rene on 25/01/16.
 */
@Configuration
public class SwaggerConfig {

    @Autowired
    private SpringSwaggerConfig springSwaggerConfig;


    @Bean
    public SwaggerSpringMvcPlugin configureSwagger() {

        SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new SwaggerSpringMvcPlugin(springSwaggerConfig);
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Microservices")
                .description("Simple project showing spring-rest capabilities")
                .termsOfServiceUrl("http://...")
                .contact("some-email@domain.com")
                .license("Product license")
                .licenseUrl("http://...")
                .build();
        swaggerSpringMvcPlugin.apiInfo(apiInfo)
                .apiVersion("1.0");

        return swaggerSpringMvcPlugin;
    }

}
