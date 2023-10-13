package pe.com.test.challenge.application;

import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateRequest;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateResponse;
import reactor.core.publisher.Mono;

public interface ExchangeRateService {

	Mono<ExchangeRateResponse> calculate(ExchangeRateRequest exchangeRateRequest);
}
