package ro.pcs.tasks02.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pcs.tasks02.exceptions.AnimalNotFoundException;
import ro.pcs.tasks02.models.Animal;
import ro.pcs.tasks02.repositories.AnimalRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AnimalServiceImpl implements AnimalService{

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<Animal> getAll() {
        List<Animal> animalList = animalRepository.findAll();
        return animalList;
    }

    @Override
    public Animal getAnimalById(Integer id) {
        return animalRepository.findById(id).orElseThrow(AnimalNotFoundException::new);
    }

    @Override
    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public void deleteAnimal(Integer id) {
        animalRepository.deleteById(id);
    }

    @Override
    public Animal putAnimal(Integer id, Animal animal) {
        if (animalRepository.findById(id).isPresent()) {
            Animal animalUpd = animalRepository.findAnimalById(id);
            animalUpd.setNickname(animal.getNickname());
            animalUpd.setBithday(animal.getBithday());
            animalUpd.setSex(animal.getSex());
            return animalRepository.save(animalUpd);
        } else {
            return animalRepository.save(animal);
        }
    }


}
