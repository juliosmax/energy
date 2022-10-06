package vistra.energy.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vistra.energy.retailer.model.UnitMarketDesignation;
import vistra.energy.retailer.model.UnitType;

@Repository
public interface UnitTypeRepository extends JpaRepository<UnitType, Long>{
	
	List<UnitType> findByCode(String code);

}
