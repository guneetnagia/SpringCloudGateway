package com.guneet.GoogleSearch;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("google")
@Configuration
public class GoogleConfig {
	@Bean
	public RouteLocator googleRouteConfig(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r->r.path("/googleSearch")
						.filters(f->f.rewritePath("googleSearch(?<segment>/?.*)", "/${segment}"))
						.uri("https://google.com")
						)
				.build();
	}
}
