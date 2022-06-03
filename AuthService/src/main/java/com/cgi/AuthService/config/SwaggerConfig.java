package com.cgi.AuthService.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

public class SwaggerConfig {

    @Bean 
	public Docket getDocket() {
//		return null;
   	 return new Docket(DocumentationType.SWAGGER_2).select()
					.apis(RequestHandlerSelectors.basePackage("com.cgi.AuthService.controller"))
					.build().apiInfo(setDetails())
					.useDefaultResponseMessages(false);

	}
    public ApiInfo setDetails()
	{
		ApiInfoBuilder apibuild=new ApiInfoBuilder();
		apibuild.title("BackOfficeSpiritsApp").version("Ver 1.1").description("This app is used to provide BackOffice endpoints")
									.license("Maliha");
		
		return apibuild.build();
	}

}
