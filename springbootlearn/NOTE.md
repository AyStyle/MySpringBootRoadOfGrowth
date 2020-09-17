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