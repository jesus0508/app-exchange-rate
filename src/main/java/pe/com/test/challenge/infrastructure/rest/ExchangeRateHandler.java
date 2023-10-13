package pe.com.test.challenge.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;
import pe.com.test.challenge.application.ExchangeRateService;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateRequest;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ExchangeRateHandler {

	private final ExchangeRateService exchangeRateService;

	public Mono<ServerResponse> postExchangeRate(ServerRequest serverRequest) {
		
		return serverRequest
				.bodyToMono(ExchangeRateRequest.class)
				.map(exchangeRateService::calculate)
				.flatMap(exchangeRate -> ServerResponse
						.status(HttpStatus.OK)
						.contentType(MediaType.APPLICATION_JSON)
						.body(exchangeRate, ExchangeRateResponse.class));
	}

}
