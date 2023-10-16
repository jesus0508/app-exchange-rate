package pe.com.test.challenge.infrastructure.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.com.test.challenge.application.UserService;
import pe.com.test.challenge.infrastructure.rest.model.AuthenticationRequest;
import pe.com.test.challenge.infrastructure.rest.model.AuthenticationResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	private final UserService userService;

	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public Mono<AuthenticationResponse> create(@RequestBody AuthenticationRequest authenticationRequest) {

		return userService.login(authenticationRequest);
	}

}
