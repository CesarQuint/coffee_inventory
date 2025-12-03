package czar.coffee.handler.coffee.handler.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("brew_items")
public class BrewItem {

    @Id
    private  Long id;
    private  String name;
    private double cost;

    public BrewItem(Long id, String name, double cost){
        this.id = id;
        this.name = name;
        this.cost =cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
