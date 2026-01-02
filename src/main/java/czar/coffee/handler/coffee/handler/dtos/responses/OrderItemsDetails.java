package czar.coffee.handler.coffee.handler.dtos.responses;

public record OrderItemsDetails(
        Long brewItemId,
        String brewItemName,
        int cost,
        int amount
) {
}
