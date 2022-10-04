package vistra.test.energy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vistra.test.energy.dto.MarketDesignationsRequest;
import vistra.test.energy.model.Market;
import vistra.test.energy.model.Unit;
import vistra.test.energy.model.UnitMarketDesignation;
import vistra.test.energy.model.UnitType;
import vistra.test.energy.repository.MarketRepository;
import vistra.test.energy.repository.UnitMarketDesignationRepository;
import vistra.test.energy.repository.UnitRepository;
import vistra.test.energy.repository.UnitTypeRepository;
import vistra.test.energy.service.MarketDesignationService;

@RestController
public class EnergyController {
	
	@Autowired
	private UnitMarketDesignationRepository unitMarketDesignationRepository;
	
	@Autowired
	private MarketDesignationService marketDesignationService;
	
	@GetMapping("hello")
	public List<UnitMarketDesignation> getDesignations() {
		return this.unitMarketDesignationRepository.findAll();
	}
	
	
	@PostMapping("/marketdesignations/{unitId}")
	public ResponseEntity<Object> registerMarketDesignation(@PathVariable Long unitId, @RequestBody MarketDesignationsRequest marketDesignationsRequest) {
		
		this.marketDesignationService.registerMarketDesignations(unitId, marketDesignationsRequest);
		return ResponseEntity.noContent().build();
		 

	}

}
