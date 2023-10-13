package pe.com.test.challenge.infrastructure.repository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "ExchangeRate")
@ToString
@Getter
@Setter
public class ExchangeRateEntity {
	@Id
	private Integer id;
	private String exchangeRateAmount;
	private String currencySource;
	private String currencyTarget;
}
