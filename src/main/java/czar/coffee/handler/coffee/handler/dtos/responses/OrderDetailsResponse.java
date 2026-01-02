package czar.coffee.handler.coffee.handler.dtos.responses;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDetailsResponse (
        Long orderId,
        LocalDateTime createdAt,
        int totalPrice,
        UserSummary user,
        List<OrderItemsDetails> items
        ){}
