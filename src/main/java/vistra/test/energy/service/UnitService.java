package vistra.test.energy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

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
import vistra.test.energy.utils.UnitSpecification;

@Service
public class UnitService {

	@Autowired
	private UnitRepository unitRepository;
	
	@Autowired
	private UnitTypeRepository unitTypeRepository;
	
	@Autowired
	private MarketRepository marketRepository; 
	
	@Autowired
	private UnitMarketDesignationRepository unitMarketDesignationRepository;

	public UnitResponse retrieveUnits(UnitDto unitDto){
		
		UnitType unitTypeList = new UnitType();
		if(unitDto.getUnitTypeCode()!=null) {
			unitTypeList = this.unitTypeRepository.findByCode(unitDto.getUnitTypeCode()).get(0);		
		}
		
		List<Long> unitIdList = new ArrayList();
		if(unitDto.getMarketCode()!=null) {
			Market market = this.marketRepository.findByCode(unitDto.getMarketCode()).get(0);
		    List<UnitMarketDesignation> unitMarketDesignationList = this.unitMarketDesignationRepository.findByMarketId(market.getId());
		    
		    unitIdList = unitMarketDesignationList.stream()
					.map(item -> item.getUnitId()).collect(Collectors.toList());
		}
		
		
		Specification<Unit> specification = Specification
			    .where(unitDto.getName() == null ? null : UnitSpecification.nameContains(unitDto.getName()))
			    .and(unitDto.getDraft() == null ? null : UnitSpecification.draftEq(unitDto.getDraft()))
			    .and(unitDto.getUnitIdentifier() == null ? null : UnitSpecification.unitIdentifierEq(unitDto.getUnitIdentifier()))
			    .and(unitDto.getUnitStartDateFormatted() == null ? null : UnitSpecification.startDate(unitDto.getUnitStartDateFormatted()))
			    .and(unitDto.getUnitEndDateFormatted() == null ? null : UnitSpecification.endDate(unitDto.getUnitEndDateFormatted()))
			    .and(unitDto.getUnitTypeCode() == null ? null : UnitSpecification.unitTypeId(unitTypeList.getId()))
			    .and(unitIdList.isEmpty() ? null :UnitSpecification.unitIdList(unitIdList));	
		       
		Pageable paging = PageRequest.of(unitDto.getPage(), unitDto.getSize());
		
		Page<Unit> unitsListPaginated = this.unitRepository.findAll(specification,paging);
		
		UnitResponse unitResponse = new UnitResponse();
		unitResponse.setRecords(unitsListPaginated.getContent());
		unitResponse.setPage(unitsListPaginated.getNumber());
		unitResponse.setTotalPages(unitsListPaginated.getTotalPages());
		unitResponse.setTotalRecords(unitsListPaginated.getTotalElements());
		
		return unitResponse;
		
	}

}
