特别说明： tomcat版本必须7以上，我之前就是项目main方法运行一切正常，但把war包部署到tomcat6上，访问就报404找不到请求的路径。

~~~
第 1 步：将这个 Spring Boot 项目的打包方式设置为 war。

<packaging>war</packaging>

这里还要多说一句， SpringBoot 默认有内嵌的 tomcat 模块，因此，我们要把这一部分排除掉。 
即：我们在 spring-boot-starter-web 里面排除了 spring-boot-starter-tomcat ，但是我们为了在本机测试方便，我们还要引入它，所以我们这样写：

  <dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <!-- 打包部署到tomcat上面时，不需要打包tmocat相关的jar包，否则会引起jar包冲突 -->
      <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
</dependencies>

第 2 步：提供一个 SpringBootServletInitializer 子类，并覆盖它的 configure 方法。我们可以把应用的主类改为继承 SpringBootServletInitializer。或者另外写一个类。

@Configuration  
@ComponentScan  
@EnableAutoConfiguration  
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

注意：部署到 tomcat 以后，访问这个项目的时候，须要带上这个项目的 war 包名。 
另外，我们还可以使用 war 插件来定义打包以后的 war 包名称，以免 maven 为我们默认地起了一个带版本号的 war 包名称。例如：

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-war-plugin</artifactId>
    <configuration>
        <warName>springboot</warName>
    </configuration>
</plugin>

例如： 
http://localhost:8080/springboot/user/18 
其中，springboot 是我放在 tomcat 上的 war 包名。
~~~

#打包SpringBoot+Maven项目
 http://blog.csdn.net/aofavx/article/details/51881100
 . 使用命令mvn clean 、mvn package
