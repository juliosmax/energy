package vistra.test.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vistra.test.energy.model.UnitType;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Long>{

}
