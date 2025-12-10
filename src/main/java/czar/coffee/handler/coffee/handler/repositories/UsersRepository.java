package czar.coffee.handler.coffee.handler.repositories;

import czar.coffee.handler.coffee.handler.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository  extends CrudRepository<User,Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
