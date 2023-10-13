package pe.com.test.challenge.application;

import java.math.BigDecimal;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import pe.com.test.challenge.domain.ExchangeRate;
import pe.com.test.challenge.infrastructure.repository.model.ExchangeRateEntity;
import pe.com.test.challenge.infrastructure.repository.model.ExchangeRateSearchCriteriaDto;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateRequest;
import pe.com.test.challenge.infrastructure.rest.model.ExchangeRateResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ExchangeRateMapper {

	ExchangeRateSearchCriteriaDto toExchangeRateSearchCriteriaDto(ExchangeRateRequest exchangeRateRequest);

	ExchangeRate toExchangeRate(ExchangeRateEntity exchangeRateEntity);

	@Mapping(target = "currencySource", source = "exchangeRateEntity.currencySource")
	@Mapping(target = "currencyTarget", source = "exchangeRateEntity.currencyTarget")
	@Mapping(target = "exchangeRateAmount", source = "exchangeRateEntity.exchangeRateAmount")
	@Mapping(target = "quotationAmount", source = "amount")
	ExchangeRateResponse toExchangeRateResponse(ExchangeRateEntity exchangeRateEntity,
			ExchangeRateRequest exchangeRateRequest, BigDecimal amount);
}
