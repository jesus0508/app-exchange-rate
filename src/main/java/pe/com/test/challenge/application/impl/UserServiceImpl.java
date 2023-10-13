package pe.com.test.challenge.application.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.com.test.challenge.application.UserService;
import pe.com.test.challenge.application.persistence.UserRepository;
import pe.com.test.challenge.infrastructure.rest.model.AuthenticationRequest;
import pe.com.test.challenge.infrastructure.rest.model.AuthenticationResponse;
import pe.com.test.challenge.infrastructure.security.JwtProvider;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final JwtProvider jwtProvider;
	
	@Override
	public Mono<AuthenticationResponse> login(AuthenticationRequest authenticationRequest) {

		return userRepository.findFirstByUsernameAndPassword(
				authenticationRequest.getUsername(), 
				authenticationRequest.getPassword())
				.map(user -> jwtProvider.generateToken(user))
				.map(token -> AuthenticationResponse.builder().token(token).build());
	}
	
	
}
