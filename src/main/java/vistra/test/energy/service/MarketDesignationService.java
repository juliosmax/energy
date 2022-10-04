package vistra.test.energy.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vistra.test.energy.dto.MarketDesignationsRequest;
import vistra.test.energy.exception.UnitNotFoundException;
import vistra.test.energy.exception.UnitValidationException;
import vistra.test.energy.model.Unit;
import vistra.test.energy.model.UnitMarketDesignation;
import vistra.test.energy.repository.UnitMarketDesignationRepository;
import vistra.test.energy.repository.UnitRepository;

@Service
public class MarketDesignationService {
	
	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private UnitMarketDesignationRepository unitMarketDesignationRepository; 

	
	public void registerMarketDesignations(Long unitId, MarketDesignationsRequest marketDesignationsRequest) {
		
		this.validations(unitId,marketDesignationsRequest);
	    
		for (UnitMarketDesignation unitMarketDesignation : marketDesignationsRequest.getMarketDesignations()) {
			unitMarketDesignation.setUnitId(unitId);
			unitMarketDesignation.setEffective_date(marketDesignationsRequest.getEffectiveDate().getEffectiveDate());
			this.unitMarketDesignationRepository.saveAndFlush(unitMarketDesignation);
		}
		
	}

	private void validations(Long unitId, MarketDesignationsRequest marketDesignationsRequest) {
		
		//All fields are required
		if(marketDesignationsRequest.getEffectiveDate().getDate()==null || marketDesignationsRequest.getEffectiveDate().getTime()==null) {
			throw new UnitValidationException("All fields are required");
		}
		for (UnitMarketDesignation unitMarketDesignation : marketDesignationsRequest.getMarketDesignations()) {
			if(unitMarketDesignation.getRegistrationCode()==null || unitMarketDesignation.getMarketId()==null || unitMarketDesignation.getMarketShare()==null) {
				throw new UnitValidationException("All fields are required");
			}
		}		
		
		//At least 1 market designation must be pass
		 if(marketDesignationsRequest.getMarketDesignations().size()<1) {
			 throw new UnitValidationException("At least 1 market designation must be pass");
		 }
			
		//UnitId must exist in table master.unit
		Unit unit = this.unitRepository.findById(unitId).orElseThrow(() -> new UnitNotFoundException("Unit not found"));
		 
		//The total marketShare for all the designations must be exactly 100
		Integer sum = marketDesignationsRequest.getMarketDesignations().stream()
				  .map(item -> item.getMarketShare())
				  .reduce(0, (a, b) -> a + b);
		if(sum!=100) {
			throw new UnitValidationException("The total marketShare for all the designations must be exactly 100");
		}
		
		//All marketIds in the list must be different
		
		  List<Long> marketIdList =	marketDesignationsRequest.getMarketDesignations().stream()
			.map(item -> item.getMarketId()).collect(Collectors.toList());
		  Set<Long> marketIdSet =
		           new HashSet<Long>(marketIdList);
		  if(marketIdSet.size()!= marketIdList.size() ) {
			  throw new UnitValidationException("All marketIds in the list must be different");
		  }
		  
		  //Registration code is unique per unit and market
		  List<String> registrationCodeList =	marketDesignationsRequest.getMarketDesignations().stream()
					.map(item -> item.getRegistrationCode()).collect(Collectors.toList());
				  Set<String> registrationCodeSet =
				           new HashSet<String>(registrationCodeList);
				  if(registrationCodeSet.size()!= registrationCodeList.size() ) {
					  throw new UnitValidationException("Registration code is unique per unit and market");
				  }
			
	       for (UnitMarketDesignation unitMarketDesignation : marketDesignationsRequest.getMarketDesignations()) { 
	    	   List<UnitMarketDesignation> unitMarketDesignationFromRepo = this.unitMarketDesignationRepository.findByRegistrationCode(unitMarketDesignation.getRegistrationCode());
	           if(!unitMarketDesignationFromRepo.isEmpty()) {
	        	   throw new UnitValidationException("Registration code is unique per unit and market");
	           }
	       }
	      
			
	}

}
