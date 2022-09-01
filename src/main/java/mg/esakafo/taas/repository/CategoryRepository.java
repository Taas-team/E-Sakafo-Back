package mg.esakafo.taas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mg.esakafo.taas.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

    Optional<Category> findByLabel(String label);
}
