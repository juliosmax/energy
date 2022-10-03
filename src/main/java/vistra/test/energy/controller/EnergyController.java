package vistra.test.energy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vistra.test.energy.model.Market;
import vistra.test.energy.model.Unit;
import vistra.test.energy.model.UnitMarketDesignation;
import vistra.test.energy.model.UnitType;
import vistra.test.energy.repository.MarketRepository;
import vistra.test.energy.repository.UnitMarketDesignationRepository;
import vistra.test.energy.repository.UnitRepository;
import vistra.test.energy.repository.UnitTypeRepository;

@RestController
public class EnergyController {
	
	@Autowired
	private MarketRepository marketRepository;
	
	@Autowired
	private UnitTypeRepository unitTypeRepository;
	
	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private UnitMarketDesignationRepository unitMarketDesignationRepository;
	
	@GetMapping("/hello")
	public List<UnitMarketDesignation> energy() {
		return this.unitMarketDesignationRepository.findAll();
	}

}
