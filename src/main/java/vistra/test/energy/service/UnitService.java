package vistra.test.energy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vistra.test.energy.dto.UnitDto;
import vistra.test.energy.dto.UnitResponse;
import vistra.test.energy.model.Unit;
import vistra.test.energy.repository.UnitRepository;

@Service
public class UnitService {

	@Autowired
	private UnitRepository unitRepository;

	public UnitResponse retrieveUnits(UnitDto unitDto){
		
		
		Unit unit = new Unit();
		if(unitDto.getDraft()!=null) {
		unit.setDraft(unitDto.getDraft());
		}	
		
		if(unitDto.getName()!=null) {
		unit.setName(unitDto.getName());
		}
		
		if(unitDto.getUnitIdentifier()!=null) {
		unit.setUnitIdentifier(unitDto.getUnitIdentifier());
		}
		
		Pageable paging = PageRequest.of(unitDto.getPage(), unitDto.getSize());
		
		Page<Unit> unitsListPaginated = this.unitRepository.findAll(Example.of(unit),paging);
		
		UnitResponse unitResponse = new UnitResponse();
		unitResponse.setRecords(unitsListPaginated.getContent());
		unitResponse.setPage(unitsListPaginated.getNumber());
		unitResponse.setTotalPages(unitsListPaginated.getTotalPages());
		unitResponse.setTotalRecords(unitsListPaginated.getTotalElements());
		
		return unitResponse;
		
	}

}
