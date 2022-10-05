package vistra.test.energy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import vistra.test.energy.dto.UnitDto;
import vistra.test.energy.dto.UnitResponse;
import vistra.test.energy.model.Unit;
import vistra.test.energy.repository.UnitRepository;
import vistra.test.energy.utils.UnitSpecification;

@Service
public class UnitService {

	@Autowired
	private UnitRepository unitRepository;

	public UnitResponse retrieveUnits(UnitDto unitDto){
		
		
		Specification<Unit> specification = Specification
			    // firstName from parameter
			    .where(unitDto.getName() == null ? null : UnitSpecification.nameContains(unitDto.getName()))
			    .and(unitDto.getDraft() == null ? null : UnitSpecification.draftEq(unitDto.getDraft()))
			    .and(unitDto.getUnitIdentifier() == null ? null : UnitSpecification.unitIdentifierEq(unitDto.getUnitIdentifier()));	
		
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
