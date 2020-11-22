package com.extimample.demo.config

import com.extimample.demo.DemoApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfiguration {
    @Bean
    fun docket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage(
                DemoApplication::class.java.getPackage().name))
            .paths(PathSelectors.any())
            .build()
            .useDefaultResponseMessages(false)
    }
}



