package ro.pcs.tasks02.services;

import ro.pcs.tasks02.models.Animal;

import java.util.List;

public interface AnimalService {
    List<Animal> getAll();
    Animal getAnimalById(Integer id);
    Animal addAnimal(Animal animal);
    void deleteAnimal(Integer id);
    Animal putAnimal (Integer id, Animal animal);
}
