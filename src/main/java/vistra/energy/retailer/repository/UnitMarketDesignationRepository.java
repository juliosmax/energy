package vistra.energy.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vistra.energy.retailer.model.UnitMarketDesignation;

@Repository
public interface UnitMarketDesignationRepository extends JpaRepository<UnitMarketDesignation, Long> {

 List<UnitMarketDesignation>  findByRegistrationCode(String registrationCode);

 List<UnitMarketDesignation> findByUnitId(Long unitId);
 
 List<UnitMarketDesignation> findByMarketId(Long marketId);
 

}
