package pe.com.test.challenge.application.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.com.test.challenge.application.ExchangeRateMapper;
import pe.com.test.challenge.application.ExchangeRateService;
import pe.com.test.challenge.application.persistence.ExchangeRateRepository;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateRequest;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {

	private final ExchangeRateRepository exchangeRateRepository;
	private final ExchangeRateMapper exchangeRateMapper;

	@Override
	public Mono<ExchangeRateResponse> calculate(ExchangeRateRequest exchangeRateRequest) {

		return Mono.just(exchangeRateRequest)
				.map(exchangeRateMapper::toExchangeRateSearchCriteriaDto)
				.flatMap(exchangeRateRepository::search)
				.flatMap(exchangeRateEntity -> Mono.just(exchangeRateEntity)
						.map(exchangeRateMapper::toExchangeRate)
						.map(exchangeRate -> exchangeRate.calculate(exchangeRateRequest.getAmount()))
						.map(amount -> exchangeRateMapper.toExchangeRateResponse(exchangeRateEntity, exchangeRateRequest, amount)));
	}

}
