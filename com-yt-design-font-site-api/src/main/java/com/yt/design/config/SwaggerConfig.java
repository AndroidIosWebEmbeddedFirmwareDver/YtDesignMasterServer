package com.yt.design.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @Description SwaggerConfig cover https://www.jianshu.com/p/74e36d52d3c3
 * @Author
 * @Create 2018-04-03 下午4:55
 **/

@Conditional(SwaggerCondition.class)
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * /api.* [访问的路径匹配,如:SwaggerApiController.java @RequestMapping("/api/v1") 符合该路径匹配]
     *
     * @return
     */
    @Bean
    public Docket userApi() {

        // 添加多个header或参数
        /*ParameterBuilder parameterBuilder1 = new ParameterBuilder();
        parameterBuilder1.name("clientCode").description("访问的系统clientCode").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        ParameterBuilder parameterBuilder2 = new ParameterBuilder();
        parameterBuilder2.name("timestamp").description("请求api的当前时间(long[yyyy-MM-dd HH:hh:ss SSS])").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        ParameterBuilder parameterBuilder3 = new ParameterBuilder();
        parameterBuilder3.name("encrypt-key").description("请求api的认证密文").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        List<Parameter> parameterList = new ArrayList<Parameter>();
        parameterList.add(parameterBuilder1.build());
        parameterList.add(parameterBuilder2.build());
        parameterList.add(parameterBuilder3.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false).globalOperationParameters(parameterList)
                .select()
                .paths(PathSelectors.regex("/api.*"))
                .build();*/

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()// 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any()) // 对所有@Api注解进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监控[指定匹配路径监控(PathSelectors.regex("/api.*"))]
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("淘一设计")
                .description("淘一设计主站管理系统接口文档")
                .termsOfServiceUrl("localhost:8080")
                .license("Apache license")
                .contact("developer@mail.com")
                .version("1.0")
                .build();
    }
}
