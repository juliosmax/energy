package vistra.test.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vistra.test.energy.model.UnitMarketDesignation;

@Repository
public interface UnitMarketDesignationRepository extends JpaRepository<UnitMarketDesignation, Long> {

}
