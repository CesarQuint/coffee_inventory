package czar.coffee.handler.coffee.handler.repositories;

import czar.coffee.handler.coffee.handler.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository  extends CrudRepository<Order,Long > {
}
