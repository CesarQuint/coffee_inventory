package czar.coffee.handler.coffee.handler.repositories;

import czar.coffee.handler.coffee.handler.entities.BrewItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrewItemsRepository extends CrudRepository<BrewItem, Long> {

    Optional<BrewItem> findByName(String name);

}
