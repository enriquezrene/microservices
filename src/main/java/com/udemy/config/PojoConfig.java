package com.udemy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rene on 26/01/16.
 */
@Configuration
@ConfigurationProperties("configuration")
@Data
public class PojoConfig {

    private String projectVersion;
}
