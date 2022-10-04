package vistra.test.energy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vistra.test.energy.dto.MarketDesignationsRequest;
import vistra.test.energy.exception.UnitNotFoundException;
import vistra.test.energy.exception.UnitValidationException;
import vistra.test.energy.model.Unit;
import vistra.test.energy.repository.UnitRepository;

@Service
public class MarketDesignationService {
	
	@Autowired
	private UnitRepository unitRepository;

	
	public void registerMarketDesignations(Long unitId, MarketDesignationsRequest marketDesignationsRequest) {
		
		this.validations(unitId,marketDesignationsRequest);
	    System.out.println(unitId);	
	}

	private void validations(Long unitId, MarketDesignationsRequest marketDesignationsRequest) {
		
		//UnitId must exist in table master.unit
		Unit unit = this.unitRepository.findById(unitId).orElseThrow(() -> new UnitNotFoundException("Unit not found"));
		 
		//The total marketShare for all the designations must be exactly 100
		Integer sum = marketDesignationsRequest.getMarketDesignations().stream()
				  .map(item -> item.getMarketShare())
				  .reduce(0, (a, b) -> a + b);
		if(sum!=100) {
			throw new UnitValidationException("The total marketShare for all the designations must be exactly 100");
		}
		
		
		
	}

}
