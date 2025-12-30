package czar.coffee.handler.coffee.handler.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("order_items")
public class OrderItem {


    @Id
    private Long id;

    private Long orderId;
    private Long brewItemId;
    private int amount;
    private int priceAtOrderTime;


    public  OrderItem(Long orderId, Long brewItemId, int quantity, int cost){
        this.orderId = orderId;
        this.brewItemId = brewItemId;
        this.amount = quantity;
        this.priceAtOrderTime = cost;
    }

    public int getPriceAtOrderTime (){
        return  priceAtOrderTime;
    }

    public int getAmount() {
        return amount;
    }

    public Long getBrewItemId() {
        return brewItemId;
    }

    public Long getId() {
        return id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                "orderId" + orderId +
                ", brewItemId=" + brewItemId +
                ", amount=" + amount +
                ", priceAtOrderTime=" + priceAtOrderTime +
                '}';
    }
}
