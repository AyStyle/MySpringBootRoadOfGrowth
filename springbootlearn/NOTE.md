# SpringBoot 学习笔记

#### 1. SpringBoot基础回顾
##### 1.1 约定优于配置
```
SpringBoot是所有基于Spring开发的项目起点。
SpringBoot的设计是为了让你尽可能快的跑起来Spring应用程序，并且尽可能减少你的配置文件。

约定优于配置（Convention over Configuration），又称为按约定编程，是一个种软件设计范式。 
```

#### 1.2 SpringBoot概念
##### SpringBoot解决的Spring问题
1. 起步依赖
   ```
   起步依赖本质上是一个Maven项目对象模型（Project Object Model，POM），定义了对其他库的依赖传递，这些东西加在一起即支持某项功能。
   简单的说，起步依赖就是将具备某种功能的坐标打包到一起，并提供了一些默认的功能。
   ```
2. 自动配置
   ```
   SpringBoot的自动配置指的是：SpringBoot会自动将一些配置类的bean注册进ioc容器，
   我们可以在需要的地方使用@AutoWired或@Resource等注解来使用它。
   
   “自动”的表现形式就是我们只需要引入我们想要的功能包，相关的配置我们完全不用管，
   SpringBoot会自动注入这些Bean，我们直接使用即可。
   
   SpringBoot：简单、快速、方便地搭建项目，对主流开发框架的无配置集成，极大的提高了开发和部署的效率。
   ```

#### 1.3 SpringBoot的全局配置文件
```
全局配置文件能够对一些默认配置值进行修改。SpringBoot使用一个application.properties或者application.yaml文件作为全局配置文件。
该文件一般存放在resources目录或类路径的/config目录。
application.properties/application.yaml文件中可以定义SpringBoot项目的相关属性。
这些相关属性可以是：系统属性、环境变量、命令参数，也可以是自定义配置文件名称和位置
```

#### 2. SpringBoot原理深入及源码剖析
##### 2.1 依赖管理
1. 问题1：为什么导入dependency时不需要指定版本？
   ```
   在spring-boot-dependencies.pom（爷爷工程）文件中，properties标签指定了其他框架与当前版本SpringBoot集成时，使用的默认版本号。
   因此SpringBoot在使用时一些框架的版本已经被内定了，如果依赖的框架不在spring-boot-dependencies.pom中，则还需要指定version标签
   ```
   
2. 问题2：Spring-boot-starter-parent父依赖启动器的主要作用是进行版本统一管理，那么项目运行依赖的Jar是从何而来的？
   ```
   在子项目例如：spring-boot-starter-web.pom中，引入了项目需要的全部依赖。
   SpringBoot官方还提供了其他的starts供开发者选择，当然开发者也可以自定义starters：https://docs.spring.io/spring-boot/docs/current/reference/html/using-spring-boot.html#using-boot-starter
   MyBatis和Druid等第三方框架也主动与SpringBoot进行了整合，但是在引入时必须指定版本号。
   ```

##### 2.2 自动配置（启动流程）
```
概念：
    能够在我们添加jar包依赖的时候，自动为我们配置一些组件的相关配置，我们无需配置或者只需要少量配置就能运行编写的项目。

问题：Spring Boot到底是如何进行自动配置的，都把哪些组件进行了自动配置？
    @SpringBootApplication
        @SpringBootConfiguration：是一个配置注解被@Configuration注解修饰，所以该注解对SpringBoot进行了配置管理
        @EnableAutoConfiguration：
            @AutoConfigurationPackage：会把@SpringBootApplication注解标注的类所在的包名拿下，并且对该包及其子包进行扫描，将组件添加到IOC容器中
            @Import：Spring框架的底层注解，它的作用就是给IOC容器导入某个组件类
        @ComponentScan：包扫描器，将@AutoConfigurationPackage注解获取到的包名下的组件进行扫描，并将组件添加到IOC容器中
```

##### 2.3 自定义Starter
###### 2.3.1 SpringBoot starter机制
```
SpringBoot由众多Starter组成（一些列自动化配置的Starter插件），SpringBoot之所以流行，也是因为Starter机制。

Starter是SpringBoot非常重要的一部分，可以理解为一个可插拔式的插件，
正是这些Starter使得使用某个功能的开发者不需要关注各种依赖库的处理，不需要具体的配置信息，
由SpringBoot自动通过classpath路径下的类发现需要的Bean，并织入相应的Bean。
```

###### 2.3.2 为什么要自定义Starter
```
开发过程中，经常会有一些独立于业务之外的配置模块。如果我们将这些可独立于业务代码之外的功能配置模块封装成一个个Starter，
复用的时候只需要将其在pom中引入依赖即可，SpringBoot为我们完成自动装配。
```

###### 2.3.3 自定义Starter的命名规则
```
SpringBoot提供的Starter以：spring-boot-starter-xxx的方式命名。
自定义或第三方提供的Starter以：xxx-spring-boot-starter的方式命名。    
```
1. 自定义Starter
   1. 新建Maven Jar工程，工程名为xxx-spring-boot-starter，导入SpringBoot自动配置依赖：
      ```xml
      <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-autoconfigure -->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-autoconfigure</artifactId>
          <version>2.3.3.RELEASE</version>
      </dependency>
      ``` 
      
   2. 编写JavaBean
    
   3. 编写配置类MyAutoConfiguration
   
   4. 在resources下创建/META-INF/spring.factories
   
2. 使用Starter

#### 4. SpringBoo视图技术
##### 4.1 SpringBoot支持的视图技术
   ```
       前端模板引擎技术的出现，使前端开发人员无需关注后端业务的具体实现，只需要关注自己页面呈现的效果即可，
   并且解决了前端代码错综复杂的问题、实现了前后端分离开发。SpringBoot框架对很多常用的模板引擎技术（FreeMarker、
   Thymeleaf、Mustache等）提供了整合支持。
       
       SpringBoot不太支持常用的JSP模板，并且没有提供对应的整合配置，这是因为使用嵌入式Servlet容器的SpringBoot
   应用程序对于JSP模板存在一些限制：
       1. SpringBoot默认使用嵌入式Servlet容器以JAR包方式进行项目打包部署，这种JAR包方式不支持JSP模板。
       2. 如果使用Undertow嵌入式容器部署SpringBoot项目，也不支持JSP模板。
       3. SpringBoot默认提供了一个处理请求路径"/error"的统一错误处理器，返回具体的异常信息。
          使用JSP模板时，无法对默认的错误处理器进行覆盖，只能根据SpringBoot要求在指定位置定制错误页面。
   ```

##### 4.2 SpringBoot整合Thymeleaf
1. Thymeleaf语法
   1. 常用标签：
      
      xmlns:th="http://www.thymeleaf.org"
      
      |th标签|说明|
      |:---:|:---|
      |th:insert|布局标签，替换内容到引入的文件|
      |th:replace|布局标签，替换整个标签到引入的文件|
      |th:each|元素遍历，类似JSP中的c:forEach|
      |th:if|条件判断，如果为真|
      |th:unless|条件判断，如果为假|
      |th:switch|条件判断，进行选择性匹配|
      |th:case|条件判断，进行选择性匹配|
      |th:value|属性值修改，指定标签属性值|
      |th:href|用于设定链接地址|
      |th:src|用于设定链接地址，通常是图片|
      |th:text|用于指定标签显示的文本内容|
      |th:object|用于指定标签对应的Object|
      
   2. 标准表达式
   
      |表达式|说明|
      |:---:|:---|
      |${...}|变量表达式|
      |*{...}|选择变量表达式|
      |#{...}|消息表达式|
      |@{...}|链接URL表达式|
      |~{...}|片段表达式|
      ```
      注：${...}变量表达式
      主要用于获取上下文中的变量。
     
      内置对象：
         #ctx：上下文对象
         #vars：上下文变量
         #locale：上下文区域设置
         #request：(仅限Web Context)HttpServletRequest对象
         #response：(仅限Web Context)HttpServletResponse对象
         #session：(仅限Web Context)HttpSession对象
         #servletContext：(仅限Web Context)ServletContext对象
         #ctx：上下文对象
      ```

2. 基本使用
   1. Thymeleaf模板基本配置
      1. 在SpringBoot中引入Thymeleaf模板
      
      2. 在全局配置文件中设置Thymeleaf模板参数（Web项目都会使用系列参数）
         ```
         spring.thymeleaf.cache=true                        # 启用模板缓存
         spring.thymeleaf.encoding=UTF-8                    # 模板编码
         spring.thymeleaf.mode=HTML5                        # 应用于模板的模板方式
         spring.thymeleaf.prefix=classpath:/thmplates/      # 指定模板页面存放路径
         spring.thymeleaf.suffix=.html                      # 指定模板页面名称的后缀
         ```
         
   2. 静态资源的访问
      ```
      SpringBoot默认在resources目录下创建一个子目录用于存放静态资源文件：public.resources.static
      ``` 