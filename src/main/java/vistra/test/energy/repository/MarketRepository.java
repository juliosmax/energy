package vistra.test.energy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vistra.test.energy.model.Market;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long>{

}
