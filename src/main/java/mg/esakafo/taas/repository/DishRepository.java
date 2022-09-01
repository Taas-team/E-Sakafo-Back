package mg.esakafo.taas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.esakafo.taas.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long>{

    Optional<Dish> findByName(String name);
}
