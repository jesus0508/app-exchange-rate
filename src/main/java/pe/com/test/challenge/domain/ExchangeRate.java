package pe.com.test.challenge.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRate {

	private BigDecimal exchangeRateAmount;
	
	public BigDecimal calculate(BigDecimal amount) {
		return amount.multiply(exchangeRateAmount);
	}
}
