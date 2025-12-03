package czar.coffee.handler.coffee.handler.repositories;

import czar.coffee.handler.coffee.handler.entities.BrewItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrewItemsRepository extends CrudRepository<BrewItem, Long> {

}
