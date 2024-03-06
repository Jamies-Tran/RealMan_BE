package com.capstone.realmen.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;

@Configuration
public class SwaggerConfig {
    @Bean
    public SecurityScheme createAPIKeyScheme() {
        SecurityScheme scheme = new SecurityScheme();
        scheme.type(Type.HTTP).bearerFormat("JWT").scheme("bearer");
        return scheme;
    }

    @Bean
    public OpenAPI openAPI() {
        OpenAPI openAPI = new OpenAPI();
        SecurityRequirement securityRequirement = new SecurityRequirement();
        Components components = new Components();
        Info info = new Info();
        securityRequirement.addList("Bearer Authentication");
        components.addSecuritySchemes("Bearer Authentication", this.createAPIKeyScheme());
        info.title("Real Man API").description("Barber shop management API").version("1.0");
        openAPI.addSecurityItem(securityRequirement).components(components).info(info);
        return openAPI;
    }

    // @Bean
    // public GroupedOpenApi webApi() {
    // return GroupedOpenApi.builder()
    // .group("Web")
    // .pathsToExclude("*/web/**")
    // .pathsToMatch("*/web/**")
    // .build();
    // }

    // @Bean
    // public GroupedOpenApi mobileApi() {
    // return GroupedOpenApi.builder()
    // .group("Mobile")
    // .pathsToExclude("/mobile/**")
    // .pathsToMatch("/mobile/**")
    // .build();
    // }

}