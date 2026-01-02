package czar.coffee.handler.coffee.handler.repositories;

import czar.coffee.handler.coffee.handler.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemsRepository  extends CrudRepository<OrderItem, Long> {
}
