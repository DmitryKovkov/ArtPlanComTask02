package ro.pcs.tasks02.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.pcs.tasks02.models.Animal;

import java.util.List;


@Repository
public interface AnimalRepository extends JpaRepository<Animal,Integer> {
Animal findAnimalById (Integer id);
}
