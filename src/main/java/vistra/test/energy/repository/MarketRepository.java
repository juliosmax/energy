package vistra.test.energy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vistra.test.energy.model.Market;
import vistra.test.energy.model.UnitType;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long>{

	List<Market> findByCode(String code);
}
