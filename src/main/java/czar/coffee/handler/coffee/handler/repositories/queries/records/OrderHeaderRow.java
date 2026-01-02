package czar.coffee.handler.coffee.handler.repositories.queries.records;

import java.time.LocalDateTime;

public record OrderHeaderRow(
        Long orderId,
        LocalDateTime createdAt,
        Integer totalPrice,
        Long userId,
        String userName,
        String userEmail
) {
}
