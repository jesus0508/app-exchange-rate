package pe.com.test.challenge.infrastructure.repository;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.com.test.challenge.application.persistence.UserRepository;
import pe.com.test.challenge.domain.User;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

	private final UserInMemoryRepository userInMemoryRepository;
	
	@Override
	public Mono<User> findFirstByUsernameAndPassword(String username, String password) {

		return userInMemoryRepository.findFirstByUsernameAndPassword(username, password);
	}

}
