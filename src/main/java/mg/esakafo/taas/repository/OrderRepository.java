package mg.esakafo.taas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mg.esakafo.taas.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
