package czar.coffee.handler.coffee.handler.services;

import czar.coffee.handler.coffee.handler.entities.BrewItem;
import czar.coffee.handler.coffee.handler.repositories.BrewItemsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CoffeeBrewService {

    private final BrewItemsRepository repository;

    public CoffeeBrewService(BrewItemsRepository repository) {
        this.repository = repository;
    }

    public List<BrewItem> getAllBrewItems() {
        Iterable<BrewItem> items = repository.findAll();

        List<BrewItem> list = new ArrayList<>();
        items.forEach(list::add);

        return list;
    }

    public BrewItem getBrewItemById(Long id){
        return  repository.findById(id).orElseThrow(()-> new RuntimeException(("Brew Item Not found with Id" + id)));
    }

    public BrewItem addBrewItem(BrewItem brewItem) {
        return repository.save(brewItem);
    }

}
