package czar.coffee.handler.coffee.handler.dtos;

public class  OrderItemRequest{

    private  String brewItemId;
    private int amount;

    public OrderItemRequest() {}

    public String getBrewItemId() {
        return brewItemId;
    }

    public void setBrewItemId(String brewItemId) {
        this.brewItemId = brewItemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
