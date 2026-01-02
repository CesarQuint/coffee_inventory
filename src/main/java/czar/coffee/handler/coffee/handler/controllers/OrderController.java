package czar.coffee.handler.coffee.handler.controllers;

import czar.coffee.handler.coffee.handler.adapters.UserDetailsAdapter;
import czar.coffee.handler.coffee.handler.dtos.CreateOrderRequest;
import czar.coffee.handler.coffee.handler.dtos.responses.OrderDetailsResponse;
import czar.coffee.handler.coffee.handler.entities.Order;
import czar.coffee.handler.coffee.handler.services.OrderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController{


    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(
            @AuthenticationPrincipal UserDetailsAdapter user,
            @RequestBody CreateOrderRequest request
            )
    {
        return  orderService.createOrder(
                user.getUser().getId(),
                request
        );
    }

    @GetMapping("/{id}")
    public OrderDetailsResponse getOrder(@PathVariable Long id){
        return orderService.getOrderAggregate(id);
    }

}