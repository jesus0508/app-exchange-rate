package pe.com.test.challenge.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.com.test.challenge.application.ExchangeRateService;
import pe.com.test.challenge.application.UserService;
import pe.com.test.challenge.infrastructure.rest.model.AuthenticationRequest;
import pe.com.test.challenge.infrastructure.rest.model.AuthenticationResponse;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateRequest;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {

	private final ExchangeRateService exchangeRateService;

	@PostMapping("")
	@ResponseStatus(HttpStatus.OK)
	public Mono<ExchangeRateResponse> create(@RequestBody ExchangeRateRequest exchangeRateRequest) {

		return exchangeRateService.calculate(exchangeRateRequest);
	}

}
