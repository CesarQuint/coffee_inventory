package czar.coffee.handler.coffee.handler.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class CreateBrewItemRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Cost must be greater than 0")
    private double cost;

    public  CreateBrewItemRequest (){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
