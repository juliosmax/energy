package vistra.test.energy.repository;

import vistra.test.energy.model.Unit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UnitRepository extends JpaRepository<Unit,Long>,  JpaSpecificationExecutor<Unit> {

}
