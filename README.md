# microservices

Swagger UI is a dependency-free collection of HTML, Javascript, and CSS assets that dynamically generate beautiful documentation.
It is intended to technical and nontechnical people could get a better understanding about the exposed rest endpoints.

1. Create a new static folder inside the project: src/main/resources/static/swagger-ui
2. Download the last version from https://github.com/swagger-api/swagger-ui
3. Unzip the file downloaded
4. Copy the dist folder content inside the folder src/main/resources/static/swagger-ui
5. Go to index.html file and change from the url from http://petstore.swagger.io/v2/swagger.json to http://localhost:8080/api-docs
6. Open the browser in the address: http://localhost:8080/swagger-ui/index.html
7. Enjoy swagger-ui
 
We can remove the documentation in README file