package czar.coffee.handler.coffee.handler.dtos;


import java.util.List;


public class CreateOrderRequest {

    private List<OrderItemRequest> items ;

    public CreateOrderRequest() {}

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }

}


