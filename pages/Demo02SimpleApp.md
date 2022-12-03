>[Common Home](../README.md)
 
# Demo02SimpleApp
 
## Status : DONE 
 
## Classes

* [Demo02SimpleAppApplication.java](../demos/demo-02-simple-app/src/main/java/com/example/demo02simpleapp/Demo02SimpleAppApplication.java)  

## Observations on  Demo02SimpleAppApplication class
* The class is annotated with `@SpringBootApplication`
* The class has a `main` method that starts the Spring application
  * By executing the `run` method of the `SpringApplication` class by giving it the class of the application as an argument.

 ## Observations on executing the application

Successful run shows which application is running on what Java version, and how long it took to start.

```
Starting Demo02SimpleAppApplication using Java 11.0.17 on barcelona with PID 8076 (C:\home\git\spring-boot-in-3-weeks\demos\demo-02-simple-app\target\classes started by vikram in C:\home\git\spring-boot-in-3-weeks)

Started Demo02SimpleAppApplication in 2.34 seconds (JVM running for 3.308
```

## Observations on the pom.xml file

The `pom.xml` file for the application is [here](../demos/demo-02-simple-app/pom.xml).
 
It has dependencies on the following Spring Boot modules:
`groupId` of `org.springframework.boot` and `artifactId` of `spring-boot-starter` and `spring-boot-starter-test`.

It has a dependency on the `spring-boot-maven-plugin` plugin, which is used to build the application.
  
 
>[Common Home](../README.md)