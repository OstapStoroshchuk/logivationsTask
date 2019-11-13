package ostap.storoshchuk.logivations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ostap.storoshchuk.logivations.entity.Case;

@Repository
public interface CaseRepository extends JpaRepository<Case, Integer> {
}
