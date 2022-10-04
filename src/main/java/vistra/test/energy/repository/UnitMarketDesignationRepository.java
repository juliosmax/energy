package vistra.test.energy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vistra.test.energy.model.UnitMarketDesignation;

@Repository
public interface UnitMarketDesignationRepository extends JpaRepository<UnitMarketDesignation, Long> {

 List<UnitMarketDesignation>  findByRegistrationCode(String registrationCode);

}
