package czar.coffee.handler.coffee.handler.services;

import czar.coffee.handler.coffee.handler.controllers.exceptions.DuplicateNameException;
import czar.coffee.handler.coffee.handler.dtos.CreateBrewItemRequest;
import czar.coffee.handler.coffee.handler.dtos.UpdateBrewItemRequest;
import czar.coffee.handler.coffee.handler.entities.BrewItem;
import czar.coffee.handler.coffee.handler.repositories.BrewItemsRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
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

    public BrewItem addBrewItem(CreateBrewItemRequest brewItem) {

        BrewItem newBrewItem = new BrewItem(brewItem.getName(),brewItem.getCost());

        return repository.save(newBrewItem);
    }

    public BrewItem updateBrewItem(Long id , UpdateBrewItemRequest request){

        BrewItem item = repository.findById(id).orElseThrow(()-> new RuntimeException(("Brew Item Not found with Id" + id)));

        repository.findByName(request.getName()).ifPresent(existing -> {
            throw  new DuplicateNameException("The name : " + request.getName() + "is already registered");
        });

        item.setName(request.getName());
        item.setCost(request.getCost());

        return  repository.save(item);
    }

}
