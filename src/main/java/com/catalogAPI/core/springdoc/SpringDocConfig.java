package com.catalogAPI.core.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("catalog API")
                        .version("v1")
                        .description("REST API TEST")
                )
                .tags(
                        Arrays.asList(
                                new Tag().name("Products").description("Products methods"),
                                new Tag().name("CardNumber").description("CardNumber")
                        )
                );
    }
}
