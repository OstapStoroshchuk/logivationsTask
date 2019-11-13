package ostap.storoshchuk.logivations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ostap.storoshchuk.logivations.entity.Orderline;

@Repository
public interface OrderlineRepository extends JpaRepository<Orderline, Integer> {
}
