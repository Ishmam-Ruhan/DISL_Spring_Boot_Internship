package com.ishmamruhan.PracticeProject2.Annotations;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content)
@ApiResponse(responseCode = "201", description = "CREATED")
@ApiResponse(responseCode = "400", description = "CREATED")
@ApiResponse(responseCode = "404", description = "CREATED")
@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
public @interface MessageAPI {
}
