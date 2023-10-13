package pe.com.test.challenge.infrastructure.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class AuthenticationRouter {
	
	private static final String AUTHENTICATION_RESOURCE = "/auth";

	@Bean
	public RouterFunction<ServerResponse> routes(AuthenticationHandler authenticationHandler) {
		return route(
				POST(AUTHENTICATION_RESOURCE).and(accept(APPLICATION_JSON)), 
				authenticationHandler::postAuthentication);
	}
}
