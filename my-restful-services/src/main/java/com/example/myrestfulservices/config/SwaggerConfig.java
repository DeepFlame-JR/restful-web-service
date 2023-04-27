package com.example.myrestfulservices.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;


@OpenAPIDefinition(
    info = @io.swagger.v3.oas.annotations.info.Info(
        title = "My Restful Services",
        description = "API",
        version = "1.0.0",
        contact = @Contact(
            name = "DeepFlame",
            email = "wnsfuf0121@naver.com"
        ),
        license = @License(
            name = "APACHE",
            url = "http://www.apache.org/licenses/LICENSE-2.0"
        )
    )
)
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("My Restful Services")
                .pathsToMatch("/**")
                .build();
    }
}
