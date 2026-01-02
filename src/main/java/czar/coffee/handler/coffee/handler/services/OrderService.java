package czar.coffee.handler.coffee.handler.services;


import czar.coffee.handler.coffee.handler.dtos.CreateOrderRequest;
import czar.coffee.handler.coffee.handler.dtos.responses.OrderDetailsResponse;
import czar.coffee.handler.coffee.handler.dtos.responses.OrderItemsDetails;
import czar.coffee.handler.coffee.handler.dtos.responses.UserSummary;
import czar.coffee.handler.coffee.handler.entities.BrewItem;
import czar.coffee.handler.coffee.handler.entities.Order;
import czar.coffee.handler.coffee.handler.entities.OrderItem;
import czar.coffee.handler.coffee.handler.repositories.OrderItemsRepository;
import czar.coffee.handler.coffee.handler.repositories.OrderRepository;
import czar.coffee.handler.coffee.handler.repositories.queries.OrderQueryRepository;
import czar.coffee.handler.coffee.handler.repositories.queries.records.OrderHeaderRow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private  final OrderRepository orderRepository;
    private  final OrderItemsRepository orderItemsRepository;
    private  final  CoffeeBrewService coffeeBrewService;
    private  final OrderQueryRepository orderQueryRepository;

    public  OrderService(OrderRepository orderRepository,
                         OrderItemsRepository orderItemsRepository,
                         CoffeeBrewService coffeeBrewService,
                         OrderQueryRepository orderQueryRepository){
        this.coffeeBrewService = coffeeBrewService;
        this.orderRepository = orderRepository;
        this.orderItemsRepository = orderItemsRepository;
        this.orderQueryRepository = orderQueryRepository;
    }

    public Order createOrder(Long userId , CreateOrderRequest request){

        List<OrderItem> orderItems = request.getItems().stream()
                .map(item-> {
                    BrewItem brew = coffeeBrewService.getBrewItemById(Long.valueOf(item.getBrewItemId()));
                    return  new OrderItem(null ,brew.getId(),item.getAmount(), (int) (brew.getCost() *100));
                }).toList();

        int total = orderItems.stream()
                .mapToInt(i -> i.getPriceAtOrderTime() * i.getAmount())
                .sum();

        Order order = new Order(userId,total);
        Order orderSaved = orderRepository.save(order);

        orderItems.forEach(orderItem -> {orderItem.setOrderId(orderSaved.getId());});

        orderItemsRepository.saveAll(orderItems);

        return  orderSaved;
    }

    public OrderDetailsResponse getOrderAggregate(Long orderId){

        System.out.println("Enter here");
        OrderHeaderRow orderHeader = orderQueryRepository.findOrderHeader(orderId);

        if(orderHeader == null) throw  new RuntimeException("Order not found");

        List<OrderItemsDetails> items =
                orderQueryRepository.findOrderItems(orderId)
                        .stream()
                        .map(row -> new OrderItemsDetails(row.brewItemId(),row.brewItemName(),row.priceAtOrderTime(),row.amount()))
                        .toList();

        return  new OrderDetailsResponse(
                orderHeader.orderId(),
                orderHeader.createdAt(),
                orderHeader.totalPrice(),
                new UserSummary(
                        orderHeader.userId(),
                        orderHeader.userName()
                ),items
        );

    }

}
