package czar.coffee.handler.coffee.handler.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Table("orders")
public class Order {

    @Id
    private Long id;

    private Long userId;
    private LocalDateTime createdAt;
    private int totalPrice;


    public  Order(Long userId, int totalPrice){
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
        this.totalPrice = totalPrice;
    }


    // ! Develop this part
    private int calculateTotal(List<OrderItem> items) {
        return items.stream().map(OrderItem::getPriceAtOrderTime).reduce(0, Integer::sum);
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", createdAt=" + createdAt +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
