package pe.com.test.challenge.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;
import pe.com.test.challenge.application.ExchangeRateService;
import pe.com.test.challenge.application.UserService;
import pe.com.test.challenge.infrastructure.rest.model.AuthenticationRequest;
import pe.com.test.challenge.infrastructure.rest.model.AuthenticationResponse;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateRequest;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthenticationHandler {

	private final UserService userService;

	public Mono<ServerResponse> postAuthentication(ServerRequest serverRequest) {
		
		return serverRequest
				.bodyToMono(AuthenticationRequest.class)
				.map(userService::login)
				.flatMap(authenticationResponse -> ServerResponse
						.status(HttpStatus.OK)
						.contentType(MediaType.APPLICATION_JSON)
						.body(authenticationResponse, AuthenticationResponse.class));
	}
}
