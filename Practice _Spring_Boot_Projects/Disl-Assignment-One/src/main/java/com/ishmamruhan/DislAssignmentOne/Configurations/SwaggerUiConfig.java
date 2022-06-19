package com.ishmamruhan.DislAssignmentOne.Configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "DISL Assignment One",
        description = "Two Types of content will be available: Json & XML\n" +
                "\nDefault Content will be 'Json'. Content type can be passed through 'Param'.\n" +
                "\nAll Api's are functional. For better understanding, please go through the Api description before using it. Thanks!"))
public class SwaggerUiConfig {
}
