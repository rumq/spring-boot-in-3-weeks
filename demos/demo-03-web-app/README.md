> [Home](../../README.md)

# Demo 03 WebApp

## Status : DONE

## Classes

- [Demo03WebAppApplication.java](../demo-03-web-app/src/main/java/com/example/demo03webapp/Demo03WebAppApplication.java)

## Observations on Demo03WebAppApplication class

- The class is annotated with `@SpringBootApplication`
- The class has a `main` method that starts the Spring application
  - By executing the `run` method of the `SpringApplication` class by giving it the class of the application as an argument.

## Observations on the pom.xml file

The `pom.xml` file for the application is [here](../demos/demo-03-web-app/pom.xml).

It has dependencies on the following Spring Boot modules:
`groupId` of `org.springframework.boot` and `artifactId` of `spring-boot-starter-web` and `spring-boot-starter-test`.

It has a dependency on the `spring-boot-maven-plugin` plugin, which is used to build the application.

The only difference between the `pom.xml` file for this web application and the `pom.xml` file for the previous regular application is the addition of the `spring-boot-starter-web` dependency with the `web` ending.

## Observations on executing the application

Successful run shows which application is running on what Java version, and how long it took to start.

It shows that Tomcat was initialized on port `8111` adn that WebAplicationContext was initialized.

```
Starting Demo03WebAppApplication using Java 11.0.17 on barcelona with PID 12184 (C:\home\git\spring-boot-in-3-weeks\demos\demo-03-web-app\target\classes started by vikram in C:\home\git\spring-boot-in-3-weeks)

No active profile set, falling back to default profiles: default

Tomcat initialized with port(s): 8111 (http)
Starting service [Tomcat]
Starting Servlet engine: [Apache Tomcat/9.0.52]

Initializing Spring embedded WebApplicationContext

Root WebApplicationContext: initialization completed in 3479 ms
Adding welcome page: class path resource [static/index.html]

Tomcat started on port(s): 8111 (http) with context path ''

Started Demo03WebAppApplication in 6.296 seconds (JVM running for 7.469)
```

## Checks

We can check if the application is running by opening the following URL in a browser: [http://localhost:8111](http://localhost:8111)

Alternatively, we can use the `curl` command to check if the application is running.

```bash
curl http://localhost:8111
```

This should result in the following output, which is the HTML content of the `index.html` file in the `static` folder from the `resources` folder, which is [this file](../demos/demo-03-web-app/src/main/resources/static/index.html).

```bash
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    Hello world!
</body>
</html>
```

> [Home](../../README.md)
