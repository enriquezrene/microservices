# microservices

SPRING CLOUD JOURNALED


As the config is inside a git repo, you can know:
- Who made the change
- How has evolved the configuration file
- Traceable config
- Provides help to operation people

With only one annotation you convert the spring bean as a proxy to refresh the values
The refresh is triggered by an event in the app context


You should add this dependency, to expose this endpoint http://localhost:8080/refresh
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        
        
You could inject the values inside a controller of this way: 

    @Value("${metadata.timeOut}")
    private int timeOut;
 
    @Value("${configuration.domain}")
    private String domain;
    
where: 
metadata.timeOut
configuration.domain

Should be properties inside a properties file in the git repo, for example:

You get this repo:
https://github.com/enriquezrene/microservices-configuration

In the root you have a properties file named: microservices.properties
Inside this file you get this properties:
metadata.timeOut=999
configuration.domain=udemy.com.ec

Because you have de microservices.properties file, you should instruct to your app to use this file,
You should create a bootstrap.yml file and put the properties file name
 spring:
  application:
    name: microservices
  cloud:
    config:
       uri: http://localhost:9090
       
And then using cloud tag instruct about where is the config server located