package czar.coffee.handler.coffee.handler.repositories.queries.records;

public record OrderItemRow(
        Long brewItemId,
        String brewItemName,
        Integer amount ,
        Integer priceAtOrderTime
) {
}
