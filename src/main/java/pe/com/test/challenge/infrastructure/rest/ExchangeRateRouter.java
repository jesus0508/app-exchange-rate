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
public class ExchangeRateRouter {
	
	private static final String EXCHANGE_RATE_RESOURCE = "/exchange-rate";

	@Bean
	public RouterFunction<ServerResponse> routes(ExchangeRateHandler exchangeRateHandler) {
		return route(
				POST(EXCHANGE_RATE_RESOURCE).and(accept(APPLICATION_JSON)), 
				exchangeRateHandler::postExchangeRate);
	}
}
