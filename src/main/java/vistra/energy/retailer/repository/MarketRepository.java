package vistra.energy.retailer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vistra.energy.retailer.model.Market;
import vistra.energy.retailer.model.UnitType;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long>{

	List<Market> findByCode(String code);
}
