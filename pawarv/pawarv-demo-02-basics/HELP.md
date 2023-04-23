# pawarv-demo-02-basics - Spring Boot Basics

Look at this after you've been through

- The application `pawarv-demo-01-start`
- The slides up to [04_04_Beans_DependencyInjection](../../slides/pdfs/04_Beans_DependencyInjection.pptx.pdf).


This application makes use of the following dependencies.

The `spring-boot-starter-web` dependency is required to run the application as a web application.

The `spring-boot-devtools` dependency is required to enable hot reloading of the application.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

## 01 Get the bean by type

```java
var bean = ctx.getBean(MyComponent.class);
```

See the following output in the console.

```
01 : Getting bean By Type getBean(MyComponent.class) : Hello from MyComponent

```

## 02A : Get the bean by name

```java
var fancyNameComponent = ctx.getBean("FancyNameComponent");
```

See the following output in the console.

```
02A : Getting bean By Name getBean(FancyNameComponent.class) : Hello from NamedComponent
```

## 02B : Get the bean by type and name

```java
var fancyNameComponent2 = ctx.getBean("FancyNameComponent", NamedComponent.class);

```

See the following output in the console.

```
02B : Getting bean By Name and Type getBean(FancyNameComponent.class, NamedComponent.class) : Hello from NamedComponent

```

## 03 Show that the bean is a singleton

```java
var singletonScopeComponent = ctx.getBean("singletonScopeComponent", SingletonScopeComponent.class);
var singletonScopeComponent2 = ctx.getBean("singletonScopeComponent", SingletonScopeComponent.class);
```

See the following output in the console.

```
03A : Hello from SingletonScopeComponent
03B : Hello from SingletonScopeComponent
03C : (singletonScopeComponent == singletonScopeComponent2)=true

```

## 04 Show Lazy initialization

This hasn't worked quite right for me.
The `@Lazy` annotation had no effect on when the bean was initialized.

However when I used the setting `spring.main.lazy-initialization=true` in the `application.properties` file, and set `@Lazy(false)` on the bean, it worked as expected.

This is one of the limitations of working with a Framework.
If what you do doesn't match what's in the documentation, it is not straight-forward to figure out.

```java

@Component
@Lazy // true by default
public class LazyComponent { ... }
//
var lazyComponent = ctx.getBean("lazyComponent", LazyComponent.class);
```

See the following output in the console.

```
04 LazyComponent Creation: LazyComponent created
04 LazyComponent Access: Hello from LazyComponent
```

## 05 Show that the bean is a prototype

```java
var prototypeScopeComponent = ctx.getBean("prototypeScopeComponent", PrototypeScopeComponent.class);
var prototypeScopeComponent2 = ctx.getBean("prototypeScopeComponent", PrototypeScopeComponent.class);
```

See the following output in the console.

```
05A : Hello from PrototypeScopeComponent
05B : Hello from PrototypeScopeComponent
05C : (prototypeScopeComponent == prototypeScopeComponent2)=false

```

## 06 : Show that the bean is autowired

```java
var fieldAutowiredDI = ctx.getBean("fieldAutowiredDI", FieldAutowiredDI.class);

```

Autowired means that the bean is injected automatically.

The bean is injected by type.
- If there are multiple beans of the same type, the bean is injected by name.
- If there are multiple beans of the same type and name, the bean is injected by qualifier.
- If there are multiple beans of the same type and name and qualifier, the bean is injected by field name.

See the following output in the console.

```
06 : Hello from FieldAutowiredDI - Hello from SingletonScopeComponent 
```

## 07 : Show Constructor injection

```java
var constructorAutowiredDI = ctx.getBean("constructorAutowiredDI", ConstructorAutowiredDI.class);
```

See the following output in the console.

```
07 : ConstructorAutowireDI [singletonScopeComponent=Hello from SingletonScopeComponent 2054451662, prototypeScopeComponent=Hello from Triangle, lazyComponent=Hello from LazyComponent, namedComponent=Hello from NamedComponent]
```

## 08 : Qualifier, Collection, and Map injection
 
In `QualifierCollectionMapInjectionDI` the `@Qualifier` annotation is used to inject a `square` into `shape1` and a `triagle` into `shape2`. 
There's also  a field called `shape3` which is annotated with `@Qualifier`. This field is injected with a `square1` bean. 
As you can see this name is derived from the class name `Square1`.

The qualifier is required as there are three beans of type `Shape`         and we need to specify to Spring which one we need in each of these variables.

The `shapes` variable is injected with a `Collection` of all the beans of type `Shape`.

The `shapesMap` variable is injected with a `Map` of all the beans of type `Shape`. The key is the name of the bean.

See the following output in the console.

```
08: Result of Dependency Injection 
  Autowired shape1:  Hello from Square 
   Type of shape1 : class net.rumq.sb.demo02basics.Square
  Autowired shape2: Hello from Triangle 
   Type of shape2 : class net.rumq.sb.demo02basics.Triangle 
 Autowired Collection<Shape> shapes     : [Hello from Square, Hello from Square1, Hello from Triangle] 
 Autowired Map<String, Shape> shapesMap : {square=Hello from Square, square1=Hello from Square1, triangle=Hello from Triangle}
08A : Hello from Square
08B : Hello from Triangle
08C : Hello from Square1


```

