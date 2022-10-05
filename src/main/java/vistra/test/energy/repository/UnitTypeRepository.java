package vistra.test.energy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vistra.test.energy.model.UnitMarketDesignation;
import vistra.test.energy.model.UnitType;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Long>{
	
	List<UnitType> findByCode(String code);

}
