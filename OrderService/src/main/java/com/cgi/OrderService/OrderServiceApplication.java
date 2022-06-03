package com.cgi.OrderService;

import com.cgi.OrderService.filter.OrderFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean getFilter(){


		UrlBasedCorsConfigurationSource urlconfig = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();



		List<String> all = Arrays.asList("*");

		//Set CORS config - give common access for all header types - Within filter we can be more specific on what is allowed
		config.setAllowedOrigins(all);
		config.setAllowedMethods(all);
		config.setAllowCredentials(true);
		config.setAllowedHeaders(all);

		//  /** includes all folders/filetypes
		//register urlconfig with cors config
		urlconfig.registerCorsConfiguration("/**", config);

		//Create new filter bean
		FilterRegistrationBean fbean = new FilterRegistrationBean(new CorsFilter(urlconfig));
		fbean.setFilter(new OrderFilter());

		//Select what endpoints to filter
		fbean.addUrlPatterns("/OrderService/*");

		return fbean;
	}
}
