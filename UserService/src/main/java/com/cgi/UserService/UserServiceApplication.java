package com.cgi.UserService;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cgi.UserService.filter.UserFilter;

@SpringBootApplication
//@EnableWebMvc
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean getfilter()
	{
		UrlBasedCorsConfigurationSource urlconfig=new UrlBasedCorsConfigurationSource();
     CorsConfiguration config=new CorsConfiguration();
     
     config.setAllowCredentials(true);
     List<String> all=Arrays.asList("*");
     
     config.setAllowedOrigins(all);
     config.setAllowedMethods(all);
     config.setAllowedHeaders(all);
     
     urlconfig.registerCorsConfiguration("/**", config);//includes all folders and file types
     
     FilterRegistrationBean fbean=new FilterRegistrationBean(new CorsFilter(urlconfig));
     fbean.setFilter(new UserFilter());
     fbean.addUrlPatterns("/userProfile/*");
     
		return fbean;
	}
}
