package vistra.energy.retailer.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import vistra.energy.retailer.dto.DateTimeFormat;
import vistra.energy.retailer.dto.UnitDto;
import vistra.energy.retailer.dto.UnitResponse;
import vistra.energy.retailer.dto.UnitResponseFormat;
import vistra.energy.retailer.model.Market;
import vistra.energy.retailer.model.Unit;
import vistra.energy.retailer.model.UnitMarketDesignation;
import vistra.energy.retailer.model.UnitType;
import vistra.energy.retailer.repository.MarketRepository;
import vistra.energy.retailer.repository.UnitMarketDesignationRepository;
import vistra.energy.retailer.repository.UnitRepository;
import vistra.energy.retailer.repository.UnitTypeRepository;
import vistra.energy.retailer.utils.UnitSpecification;

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
		
		List<UnitResponseFormat> UnitResponseFormatList = unitTransformResponse(unitsListPaginated.getContent());
		
		unitResponse.setRecords(UnitResponseFormatList);
		unitResponse.setPage(unitsListPaginated.getNumber());
		unitResponse.setTotalPages(unitsListPaginated.getTotalPages());
		unitResponse.setTotalRecords(unitsListPaginated.getTotalElements());
		
		return unitResponse;
		
	}
	
	private List<UnitResponseFormat> unitTransformResponse(List<Unit> unitList) {
		List<UnitResponseFormat> unitResponseFormatList= new ArrayList();
		for(Unit unitItem: unitList) {
			UnitResponseFormat unitResponseFormat= new UnitResponseFormat();
			unitResponseFormat.setId(unitItem.getId());
			unitResponseFormat.setDraft(unitItem.isDraft());
			unitResponseFormat.setInternalLongName(unitItem.getInternalLongName());
			unitResponseFormat.setInternalShortName(unitItem.getInternalShortName());
			unitResponseFormat.setName(unitItem.getName());
			unitResponseFormat.setUnitIdentifier(unitItem.getUnitIdentifier());
			
			DateFormat dateFormatDate = new SimpleDateFormat("yyyy-mm-dd"); 
			DateFormat dateFormatTime = new SimpleDateFormat("HH:mm:ss"); 
			
			DateTimeFormat dateTimeFormatEndDate = new DateTimeFormat(dateFormatDate.format(unitItem.getUnitEndDate()),dateFormatTime.format(unitItem.getUnitEndDate()));
			unitResponseFormat.setUnitEndDate(dateTimeFormatEndDate);
			
			DateTimeFormat dateTimeFormatStartDate = new DateTimeFormat(dateFormatDate.format(unitItem.getUnitStartDate()),dateFormatTime.format(unitItem.getUnitStartDate()));
			unitResponseFormat.setUnitStartDate(dateTimeFormatStartDate);
			
			Optional<UnitType> unitType = this.unitTypeRepository.findById(unitItem.getUnitTypeId());
			 if(unitType.isPresent()) {
				 unitResponseFormat.setUnitTypeCode(unitType.get().getCode());
			 }
			 unitResponseFormatList.add(unitResponseFormat);
		}
		return unitResponseFormatList;
	}

}
