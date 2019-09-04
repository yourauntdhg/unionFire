package com.unionFire.swagger;

import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${jwt.header}")
    private String tokenHead;

    @Value("${swagger.enabled}")
    private Boolean swaggerEnable;

    /**
     *
     * @return docket
     */
    public Docket createRestApi(){
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> list = new ArrayList<>();
        ticketPar.name(tokenHead).description("token").modelRef(new ModelRef("string"))
                .parameterType("header")
                .defaultValue("Bearer")
                .required(true)
                .build();
        list.add(ticketPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnable)
                .apiInfo(apiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build().globalOperationParameters(list);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("unionFire接口文档")
                .version("1.0.0")
                .build();
    }
}
