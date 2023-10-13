package pe.com.test.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import pe.com.test.challenge.infrastructure.rest.AuthenticationRouter;
import pe.com.test.challenge.infrastructure.rest.ExchangeRateRouter;

@SpringBootApplication
@Import({ExchangeRateRouter.class, AuthenticationRouter.class})
public class AppExchangeRateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppExchangeRateApplication.class, args);
	}

}
