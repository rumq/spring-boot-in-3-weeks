> [Home](Home.md)

# Week Two Notes

## Status : IN_PROGRESS

## Week Two Slides

- [07_Spring_Boot_Techniques](../slides/pdfs/07_Spring_Boot_Techniques.pptx.pdf)
- [08_Integrating_Data_Sources](../slides/pdfs/08_Integrating_Data_Sources.pptx.pdf)
- [09_Querying_Modifying_Entities](../slides/pdfs/09_Querying_Modifying_Entities.pptx.pdf)
- [10_Spring_Data_Repositories](../slides/pdfs/10_Spring_Data_Repositories.pptx.pdf)
- [11_Simple_Rest_Services](../slides/pdfs/11_Simple_Rest_Services.pptx.pdf)
- [12_Full_Rest_Services](../slides/pdfs/12_Full_Rest_Services.pptx.pdf)

## 07 Spring Boot Techniques

## 1. Setting App properties at the command line

Properties can be set in a `application.properties` file. These properties can then be used in the code as below

```java
@Value("${app.name}")
private String appName;
```

Can be set at many places

- Command line
- Environment variable SPRING_APPLICATION_JSON
- OS environment variables
- Application properties file outside of the jar
- Application properties file inside the jar

The topmost property will override the lower ones.

1. Specifying whichi properties file to use
2. Defining YAML properties Files
3. Using Spring profiles

On IntelliJ you can set the command line arguments as below

Run-> edit configurations -> spring boot -> Application -> Modify options-> Main class -> Program arguments

Give the command line arguments as below

```bash
--app.name=MyApp
```

Loads from `application.properties` and `application.yml` files. We can specify a specific file if we want to, but only one file will be loaded.

In Maven `java` and `resource` are on the classpath.
The properties file can be in the `resources` folder. Or it can be in a folder called `config` in the `resources` folder. However it conventionally goes in the `resources` folder.

Specify a different file as below

````bash
--spring.config.name=app2
```bash

```java
System.setProperty("spring.config.location", "app2");
````

```properties
app.name=MyApp
```

```yaml
app:
  name: MyApp
```

The properties can be injected into the code as below

```java
@Value("${app.name}")
private String appName;

@Value("${app.description}")
private String appDescription;
```

Or we can use the `@ConfigurationProperties` annotation as below, so we don't have to repeat the `@Value` annotation for each property.

```java
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private String name;
    private String description;
    // getters and setters required

}
```

Also need to specify the following in the pom.xml

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>

```

Project Lombok is used to generate the getters and setters. It is a Java library that automatically plugs into your editor and build tools, spicing up your java.

```java
@Data
```


## 08 Integrating with Data Sources

Starts at Week 2, 76:19 minutes

# [Allpages](pages/AllPages.md)



### 1. Understanding Spring Data

JPA Java Persistence API, standardization of Hibernate. Implements Object Relational Mapping (ORM).

Support of Relational DBs, NoSQL DBs, Graph DBs, Map-Reduce DBs, Cloud Datastores.

Use Spring attributes to set transaction.

Repository - CRUD with minimal code.

H2 is in memory database, runs inside JVM.

Dependency for H2 database. It provides the driver.

```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency> 
```

Review on mvnrepository.com, copy mysql dependency if we want it.



### 2. Getting started with Spring Data JPA
3. Defining JPA Entity classes
4. Viewing Database Data

## 09 Querying and Modifying Entities

1. Querying for Entities
2. Modifying Entities
3.

## 10 Spring Data Repositories

1. Understanding Spring Data Repositories
2. Using Spring Data Repositories
3.

## 11 Simple Rest Services

1. Getting started
2. Defining a simple REST service
3.

12 Full REST service

1. Setting the scene
2. Defining a full REST service




> [Home](HOME.md)

```

```
