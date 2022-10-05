package vistra.test.energy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vistra.test.energy.dto.MarketDesignationsRequest;
import vistra.test.energy.dto.UnitDto;
import vistra.test.energy.dto.UnitResponse;
import vistra.test.energy.model.Market;
import vistra.test.energy.model.Unit;
import vistra.test.energy.model.UnitMarketDesignation;
import vistra.test.energy.model.UnitType;
import vistra.test.energy.repository.MarketRepository;
import vistra.test.energy.repository.UnitMarketDesignationRepository;
import vistra.test.energy.repository.UnitRepository;
import vistra.test.energy.repository.UnitTypeRepository;
import vistra.test.energy.service.MarketDesignationService;
import vistra.test.energy.service.UnitService;

@RestController
public class EnergyController {
	
	
	@Autowired
	private MarketDesignationService marketDesignationService;
	
	@Autowired
	private UnitService unitService;
	
	
	@PostMapping("/marketdesignations/{unitId}")
	public ResponseEntity<Object> registerMarketDesignation(@PathVariable  Long unitId, @RequestBody MarketDesignationsRequest marketDesignationsRequest) {
		
		this.marketDesignationService.registerMarketDesignations(unitId, marketDesignationsRequest);
		return ResponseEntity.noContent().build();
		 
	}
	
	@GetMapping("/units")
	public UnitResponse getUnits(@RequestParam(required = false) String name, @RequestParam(required = false) String unitStartDate, @RequestParam(required = false) String unitEndDate,
			@RequestParam(required = false) String unitTypeCode, @RequestParam(required = false) Boolean draft, @RequestParam(required = false) String unitIdentifier, 
			@RequestParam(required = false) String marketCode, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size ) {
		
		UnitDto unitDto = new UnitDto(name,unitStartDate,unitEndDate,unitTypeCode,draft,unitIdentifier,marketCode,size,page);
		
		UnitResponse unitResponse = this.unitService.retrieveUnits(unitDto);
		
		return unitResponse;
	}

}
