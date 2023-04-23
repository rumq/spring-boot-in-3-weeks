> [Home](../README.md)

- [1 Introduction](#1-introduction)
  - [Start](#start)
- [2 Creating a simple Spring Boot App](#2-creating-a-simple-spring-boot-app)
- [3 Creating Web App](#3-creating-web-app)
- [4 Beans Dependency injection](#4-beans-dependency-injection)
  - [4.1 Components and Beans](#41-components-and-beans)
  - [4.2 A closer look at Components and Beans](#42-a-closer-look-at-components-and-beans)
  - [4.3 Dependency Injection](#43-dependency-injection)
  - [4.4 A closer look at Dependency Injection](#44-a-closer-look-at-dependency-injection)
- [5 Injection Techniques](#5-injection-techniques)
  - [5.1 Using Spring Expression Langauge (SpEL)](#51-using-spring-expression-langauge-spel)
  - [5.2 Working with command-line arguments](#52-working-with-command-line-arguments)
- [6 Configuration Classes](#6-configuration-classes)
  - [6.1 Defining a config class and bean methods](#61-defining-a-config-class-and-bean-methods)
  - [6.2 Locating config classes and bean methods](#62-locating-config-classes-and-bean-methods)
  - [6.3 Configuration techniques](#63-configuration-techniques)
  - [6.4 Bean configuration dependencies](#64-bean-configuration-dependencies)
- [7 Spring Boot Techniques](#7-spring-boot-techniques)
  - [7.1 Setting app properties at command line](#71-setting-app-properties-at-command-line)
  - [7.2 Specifying which properties file to use](#72-specifying-which-properties-file-to-use)
  - [7.3 Defining YAML properties files](#73-defining-yaml-properties-files)
  - [7.4 Using Spring profiles](#74-using-spring-profiles)
- [Appendix A : From Old notes](#appendix-a--from-old-notes)

## 1 Introduction

### Start

Spring Boot application can run as a standalone application.

Project page for [Spring Boot](https://spring.io/projects/spring-boot).

Spring Boot documentation : [Spring Boot Reference documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

Spring Boot App can have a REST interface that clients can call. 
The app in turn can communicate with MQ and DB.

Spring Boot Cloud - Allows calling of one app in cloud to another app.

Client could be Web UI or a mobile app.

## 2 Creating a simple Spring Boot App

See 
- the slide [02_Creating_Simple_App](../slides/pdfs/02_Creating_Simple_App.pptx.pdf).
- the code [demo-02-simple-app](../demos/demo-02-simple-app/)

Spring Boot is a layer on top of Spring framework using auto configuration.

SB has few pom dependencies.

[MVN Repository](https://mvnrepository.com/) is the place to search for dependencies. You can find `sping-boot-starter` here.

We need this one [spring-boot-starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter).


To create a simple app in Java, use the below pom.xml file.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>myproject</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.6.4</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

Use the below Java file.

```java
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;

@RestController
@EnableAutoConfiguration
public class MyApplication {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
```

Run it as below

```bash
mvn spring-boot:run
```

## 3 Creating Web App

See 
- The slide [03_Creating_Web_App](../slides/pdfs/03_Creating_Web_App.pptx.pdf).
- The code [demo-03-web-app](../demos/demo-03-web-app/).
-  

SB apps run as web apps. 
Tomcat apps run on `8080` port by default. 
In the past you’d create a .war file and deploy it to a central web server.
You no longer do it this way now. 
Now each jar contains the tomcat jars and runs as a standalone java application. 
Each jar could be in its own docker container. 
These can be orchestrated by Kubernetes.
Choose Spring Web dependency (most widely used 90%)

The application would not use dynamically generated html (using templates thymeleaf) instead it would generate JSON response.

`[application.properties](http://application.properties)` file contains properties files. 
Most components have default properties for example `server.port=8080`.

## 4 Beans Dependency injection

See 
- The slide [04_Beans_Dependency_Injection](../slides/pdfs/04_Beans_DependencyInjection.pptx.pdf).
- The code [demo-04-beans-dependency-injection](../demos/demo-04-beans-dependencyinjection/).

### 4.1 Components and Beans

**Overview of Components**

A **component** is a class that Spring automatically instantiates when it is annotated with `@Controller or @RestController`: UI  
`@Service` : Middle layer
`@Repository`: Database 
`@Component:` General purpose


**Define a component**

Spring will instantiate an instance called **bean.** 
This is how it is done.
Such an instance is called a 'bean'.

```java
@Component 
public class MyComponent {
}
```

**Component Scanning**

By default application class package and sub packages scanned. 
You can give other package names if required.

```java
@SpringBootApplication( scanBasePackages={"mypackage1", "mypackage2"})
public class Application {
}
```

**Access a bean as below**

During startup all the beans are created and put in the context object.
They can be retrieved using the `getBean` method. 

```java
// Get the application context object 
ApplicationContext ctx = SpringApplication.run(MyApplication.class, args);
// call the getBean method on it, give it the class of the component
MyComponent bean = ctx.getBean(MyComponent.class);

```
### 4.2 A closer look at Components and Beans

**Specifying a name**

A bean by default has the name of the class with the first letter in lower case. We can give it a custom name by annotating the component with  `@Component("myCoolBean")`.

**Understanding Singleton Scope**
Beans are created in ‘singleton’ scope by default. We can be explicit by annotating the Component with `@Scope("singleton")` .
They can be accessed as shown above using `getBean()` on `ApplicationContext`. The same instance is returned everytime the bean is accessed.
They are created at application startup. To specify that they are lazily instantiated, annotate the component  with `@Lazy`

**Defining different scopes**
The beans can have other scopes such as `prototype`, `request`, `session` and `application` that can be given as argument to `@Scope`. When we specify `prototype` a new instance of the bean is created everytime `getBean()`is called.

### 4.3 Dependency Injection

**Overview of Dependency Injection**

Dependency injection is a way  to describe the dependencies between components using configuration.

Spring automatically injects dependencies into beans through "autowiring".

**Injecting Dependencis into Fields**

If a bean has dependencies, they can be injected via `@Autowired` annotation.
It can be used on a field.

```java
// Injecting into a field
@Autowired
private BankRepository repository;
```
**Injecting Dependencis into a constructor**

It can be used on a constructor

```java
@Autowired           
public BankServiceImpl(BankRepository repository){
	this.repository = repository;
}
```
If there is only one constructor, we can omit teh annotation as Spring automatically automatically autowires the constructor parameters as required.

**Fine-tuning Autowiring**

We can specify which particular bean to be used for injection.

```java
@Autowired
@Qualifier("primaryRepository") // To give it a name you want
public BankServiceImpl(BankRepository repository){
	this.repository = repository;
}
```

We can specify that it is optional. 

```java
@Autowired(required=false)
private BankRepository repository;
```

### 4.4 A closer look at Dependency Injection

**Autowiring a collection**

Example

If we autowire `Collection<T>`, a collection of beans of type `T` are injected.
The following injects a collection of BankRepositories.

```java
@Autowired
private Collection<BankRepository> repositories;
```

**Autowiring a Map**

If we autowire `Map<String, T>`, Spring injects a Map with beans of type `T` using the bean names as the key.
The following injects a map of BankRepositories. 

```java
@Autowired
private Map<String, Repository> reposiotriesMap;

```

**Injecting values into beans**

Values can be injected into beans using the annotation `@Value`.

`$` is used to inject a value from `application.properties`.
`#` is used to inject a value using the Spring Expression language (SpEL).

```java
import org.springframework.beans.factory.annotation.Value;

@Component
public class MyBeanWithValues {
    
    @Value("${name}")
    private String name;  // injects name from application.properties file

    @Value("#{ 5 * 7.5}") // injects general Java value through SpeEL.
}

```

A [link](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html) to a lot of common properties that can be overridden in `application.properties`.








## 5 Injection Techniques

### 5.1 Using Spring Expression Langauge (SpEL)

**Overview of SpEL**

It has a Java like syntax and can be used in various places in Spring in beans, on parameters, within XML config etc.

**Simple Example**

```java
...
@Component
...

@Value("#{5 * 7.5}")
private double workingWeek;
```

**SpEL Scalar Expressions**

Create an object

```java
@Value("#{ new java.util.Date()}")
private Date timestamp;
```

Call a static method, using `T` to denote the type

```java
@Value("#{ T(java.lang.Math).random() * 100.0}")
private double rand;
```

**Using SpEL for Collections**

Access an array or a map

```java
@Value("#{ info.cities[9] }")
private String city

@Value("#{ info.currencies['UK']}")
private String currency;
```

We can use operators

```java
@Value("#{ info.cities.?[starsWith('B')]}")
private List<String> allBCities;

@Value("#{ info.cities.^[starsWith('B')]}")
private List<String> firstCity;

@Value("#{ info.cities.$[starsWith('B')]}")
private List<String> lastCity;

@Value("#{ info.cities.![toUpperCase()]}")
private List<String> upperCities;


```

**Using SpEL for Parameters**

On autowired method parameters

```java

@Component
...

@Autowired
public void setUserName(@Value("#{ systemProperties['user.name']}") String n) { ... }

```

### 5.2 Working with command-line arguments

We can access command-line arguments by auto-wiring them into a component.

```java
@Component
...
@Autowired
public MyBeanWithArgs(ApplicationArguments args){
    // access args here
}
```
Spring Boot supports option and non-option arguments. These can be accessed by various methods in ApplicationArgument class.

```bash
# Option arguments
--target=windows --target=macOS --db=h2
# Non-option arguments
norway oslo krone 42
``` 

To access command-line arguments in maven do :-

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="norway oslo krone 42 --target=windows --target=macOS --db=h2"
```

See the example `SpelBean.displayTimestmap`.

## 6 Configuration Classes

### 6.1 Defining a config class and bean methods

A configuration class is a special class that creates and instantiates bean objects.
To define it, annotate a class with `@Configuration`,  annotate methods with `@Bean` and create/return objects.

The below creates a bean with the name `myBean` of type `MyBean`.

```java
@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean(){
        MyBean myBean = new MyBean();
        myBean.setField1("42");
        return b;
    }
}
```
The bean can be accessed via `getBean` and autowired as normal.

### 6.2 Locating config classes and bean methods

Configuration classes are special kinds of components.
So they can be located where components can be located, i.e in application packages or those specified with `scanBasePackages`.

The annotation `@SpringBootApplication` is equivalent to :
- @Configuration
- @EnableAutoConfiguration
- @ComponentScan

So the Application class is also a configuration class and the `@Bean` methods can be defined in the application class.

### 6.3 Configuration techniques

By default the bean name is the same as the method name. You can specify different name. They can then be looked up by these names as normal. They can be set to instantiate lazily using `@Lazy` annotation and also set the scope.

```java
@Bean(name="cool-bean")
public MyBean bean1() {return new MyBean(111,xx);}

@Bean(name = {"subsystemA-bean", "subsystemB-bean", "subsystemC-bean"})
@Lazy
@Scope("prototype")
public MyBean bean2() { return new MyBean(222,yy);}
```

### 6.4 Bean configuration dependencies

Consider that you have these classes

`TransactionManager` references a `DataSource`

```java
public class TransactionManager {
    DataSource dataSource;
}

public class DataSource(){}
```

You can configure it as follows

TYPE1 - call the dataSource() method.
TYPE2 - automatically

```java
@Configuration  // configuration class
public class MyConfig {
    @Bean      // configure a bean
    public DataSource dataSource(){
        DataSource ds = new DataSource()
        ...
        return ds;
    }
    // TYPE1 call
    @Bean      // configure a bean that depends on another
    public TransactionManager  transactionManager(){
        TrasactionManager tm1 = new TrasactionManager();
        tm1.setDataSource(datasoure());
        return tm1;
    }

    // TYPE2 auto
    @Bean
    public TransactionManager transactionManager2(DataSource ds){
        TransactionManager tm2 = new TransactionManager();
        tm2.setDataSource(ds);
        return tm2;
    }
}
```







## 7 Spring Boot Techniques

### 7.1 Setting app properties at command line
### 7.2 Specifying which properties file to use
### 7.3 Defining YAML properties files
### 7.4 Using Spring profiles

## Appendix A : From Old notes

- Spring (My Notes)
    - Spring provides an environment in which all of the objects we need are created and linked up and kept ready for service. That is, instantiated and autowired and available in Application context object .
    - It instantiates classes which are Java beans and have special annotations like @component etc.
    - Such objects can be accessed by looking up in the application context.
    - Most classes have only one object created called Singleton. So, this same instance is returned whenever they are referred.
    - If the classes are annotated with @prototype, then a new instance of it is instantiated every time it's looked up.
    - The classes can be annotated with @lazy to delay the creation of the object until the point when it's actually needed, that is called by another object.
    - If an object has a reference to another object, that is, its class has an instance field with the type of the other object, then the referred object can be autowired, which means it will also be created when the pointing object is created. This is called dependency injection. The first object's dependency, the second object is injected into the first object.
    - **Modernization of Java & Sprint ecosystem**
        - The deployment unit of Spring is now a jar file. It contains an embedded tomcat server. Each spring app has its own server. Each app can be installed in a separate container to take advantage of modern containerized environments.
    
    - Basics
        - Run the app via `mvn spring-boot:run`. See [Spring Boot Maven Plugin]
            - Maven : If there are more than one Applications with main method, then we can specify which one to run by giving the name of the desired application in the `mainClass` element.
                
                ```xml
                <plugin>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-maven-plugin</artifactId>
                  <configuration>
                      <mainClass>demo.spel.Application</mainClass>
                  </configuration>
                </plugin>				        
                ```
                
            - In Eclipse, edit the run configuration and give the name of the required class as Main type
        - ([https://docs.spring.io/spring-boot/docs/2.0.1.RELEASE/maven-plugin/index.html](https://docs.spring.io/spring-boot/docs/2.0.1.RELEASE/maven-plugin/index.html))
        - Can change the properties in `application.properties` or YAML.
            - For example `server.port=8111`
            - The full list of application properties is here [https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)

> [Home](../README.md)
