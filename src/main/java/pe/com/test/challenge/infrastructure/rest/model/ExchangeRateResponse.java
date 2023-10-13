package pe.com.test.challenge.infrastructure.rest.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pe.com.test.challenge.domain.Currency;

@ToString
@Getter
@Setter
public class ExchangeRateResponse {
	private BigDecimal amount;
	private Currency currencySource;
	private Currency currencyTarget;
	private BigDecimal exchangeRateAmount;
	private BigDecimal quotationAmount;
}
