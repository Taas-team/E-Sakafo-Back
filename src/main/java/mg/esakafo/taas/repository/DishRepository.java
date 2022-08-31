package mg.esakafo.taas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.esakafo.taas.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long>{
    
}
