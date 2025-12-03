package czar.coffee.handler.coffee.handler.controllers;

import czar.coffee.handler.coffee.handler.entities.BrewItem;
import czar.coffee.handler.coffee.handler.services.CoffeeBrewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CoffeeBrewController {

    private final CoffeeBrewService coffeeBrewService;

    public CoffeeBrewController(CoffeeBrewService coffeeBrewService){
        this.coffeeBrewService = coffeeBrewService;
    }

    @GetMapping("")
    public String base(){
        return "Great";
    }

    @GetMapping("/brew_drinks")
    public List<BrewItem> getCoffees(){
        return this.coffeeBrewService.getAllBrewItems();
    }

    @GetMapping("/brew_drinks/{id}")
    public BrewItem getOne(@PathVariable Long id){
        return coffeeBrewService.getBrewItemById(id);
    }

    @PostMapping("/brew_drink")
    public  BrewItem create(@RequestBody BrewItem brewItem){
        return  coffeeBrewService.addBrewItem(brewItem);
    }

}
