package ro.pcs.tasks02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.pcs.tasks02.models.Animal;
import ro.pcs.tasks02.services.AnimalService;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @RequestMapping(value = "/animals/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public List<Animal> animalList () {
        return animalService.getAll();
    }

    @RequestMapping(value = "/animals/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Animal animalListById (@PathVariable("id") Integer id) {
        return animalService.getAnimalById(id);
    }

    @RequestMapping(value = "/animals/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public Animal addAnimal(@RequestBody Animal animal){
        return animalService.addAnimal(animal);
    }

    @RequestMapping(value = "animals/delete/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public void deleteAnimal(@PathVariable("id") Integer id){
        animalService.deleteAnimal(id);
    }

}
