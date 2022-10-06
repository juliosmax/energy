package vistra.energy.retailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import vistra.energy.retailer.model.Unit;

public interface UnitRepository extends JpaRepository<Unit,Long>,  JpaSpecificationExecutor<Unit> {

}
