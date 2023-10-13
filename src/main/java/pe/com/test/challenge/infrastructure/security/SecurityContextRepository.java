package pe.com.test.challenge.infrastructure.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SecurityContextRepository implements ServerSecurityContextRepository {
	
	private final AuthenticationManager authenticationManager;

	@Override
	public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {

		return Mono.empty();
	}

	@Override
	public Mono<SecurityContext> load(ServerWebExchange exchange) {

		return Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("Authorization"))
				.filter(authorization -> authorization.startsWith("Bearer "))
				.map(authorization -> authorization.substring(authorization.length()))
				.flatMap(token -> Mono.just(new UsernamePasswordAuthenticationToken(token, token)))
				.flatMap(auth -> authenticationManager.authenticate(auth).map(SecurityContextImpl::new));
	}

}
