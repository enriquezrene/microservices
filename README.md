# microservices

PROFILES

@ConfigurationProperties
- Properties as POJOs (Plain Old Java Object) -> Type safe

Change from application.properties to application.yml
yaml vs properties

@EnableAutoConfiguration on App class
$ -> Property place hoder resolution

Reading the properties:
+    @Value("${configuration.projectVersion}")
+    void setProjectVersion(String projectVersion) {
+        System.out.println("************************************");
+        System.out.println("projectVersion: " + projectVersion);
+    }
+
+    @Autowired
+    void setPojoConfig(PojoConfig pojoConfig) {
+        System.out.println("************************************");
+        System.out.println("getting pojo values: " + pojoConfig.getProjectVersion());
+    }
+
+    @Autowired
+    void setEnvironment(Environment environment) {
+        System.out.println("************************************");
+        System.out.println("From Environment: " + environment.getProperty("configuration.projectVersion"));
+    }



// Mapping properties with prefix: configuration
@Configuration
@ConfigurationProperties("configuration")
@Data
public class PojoConfig {

Override the config, from the terminal type:
java -jar -Dconfiguration.projectVersion=99 target/microservices-0.0.1-SNAPSHOT.jar

