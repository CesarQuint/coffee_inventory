package czar.coffee.handler.coffee.handler.repositories.queries;

import czar.coffee.handler.coffee.handler.entities.Order;
import czar.coffee.handler.coffee.handler.repositories.queries.records.OrderHeaderRow;
import czar.coffee.handler.coffee.handler.repositories.queries.records.OrderItemRow;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface OrderQueryRepository extends Repository<Order, Long> {

    @Query("""
        SELECT
            o.id AS order_id,
            o.created_at AS created_at,
            o.total_price AS total_price,
            u.id AS user_id,
            u.name AS user_name,
            u.email AS user_email
        FROM orders o
        JOIN users u ON u.id = o.user_id
        WHERE o.id = :orderId
    """)
    OrderHeaderRow findOrderHeader(Long orderId);

    @Query("""
    SELECT
        oi.brew_item_id AS brew_item_id,
        b.name AS brew_item_name,
        oi.amount AS amount,
        oi.price_at_order_time AS price_at_order_time
    FROM order_items oi
    JOIN brew_items b ON b.id = oi.brew_item_id
    WHERE oi.order_id = :orderId
    """)
   List<OrderItemRow> findOrderItems(Long orderId);
}
