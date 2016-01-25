# microservices

Adding endpoint documentation with swagger (http://swagger.io) 
- Keep in sync documentation with the endpoints
- Support for java and another popular programming languages like php, node.js and so on. 

1. Swagger maven dependency
    <dependency>
        <groupId>com.mangofactory</groupId>
        <artifactId>swagger-springmvc</artifactId>
        <version>1.0.2</version>
    </dependency>
    
2. Swagger support on SpringBoot
@SpringBootApplication
@EnableSwagger
public class MicroservicesApplication {
    ...
    
3. Visit the endpoint documentation on: http://localhost:8080/api-docs

run this command on the terminal: curl --silent http://localhost:8080/api-docs | jq '' , or you can use your preferred rest client tool. 

I'm using:

jq: command-line JSON processor https://stedolan.github.io/jq/
curl: command line tool for transferring data specified with URL syntax http://curl.haxx.se/

The output should be:
{
  "apiVersion": "1.0",
  "apis": [
    {
      "description": "Basic Error Controller",
      "path": "/default/basic-error-controller",
      "position": 0
    },
    {
      "description": "Cars Inventory Controller",
      "path": "/default/cars-inventory-controller",
      "position": 0
    },
    {
      "description": "Manufacturer Controller",
      "path": "/default/manufacturer-controller",
      "position": 0
    }
  ],
  "authorizations": {},
  "info": {
    "contact": "Contact Email",
    "description": "Api Description",
    "license": "Licence Type",
    "licenseUrl": "License URL",
    "termsOfServiceUrl": "Api terms of service",
    "title": "default Title"
  },
  "swaggerVersion": "1.2"
}




Inserting a new manufacturer:

<pre>
POST http://localhost:8080/manufacturers/
HEADERS Content-type:application/json 
{
    "name": "Chevrolet"
}
</pre>

Inserting a new car:

<pre>
POST http://localhost:8080/manufacturers/{manufacturerId}/cars
HEADERS Content-type:application/json 
{
    "model": "BMW 335i",
    "color": "white"
}
</pre>
