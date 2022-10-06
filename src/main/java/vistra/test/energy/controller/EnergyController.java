package vistra.test.energy.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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

@Component
@Path("/")
public class EnergyController {
	
	
	@Autowired
	private MarketDesignationService marketDesignationService;
	
	@Autowired
	private UnitService unitService;
	
	@POST
	@Path("/marketdesignations/{unitId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registerMarketDesignation(@PathParam(value = "unitId")  Long unitId, MarketDesignationsRequest marketDesignationsRequest) {
		
		this.marketDesignationService.registerMarketDesignations(unitId, marketDesignationsRequest);
		return Response.noContent().build();
		 
	}
	@GET
	@Path("/units")
	@Produces(MediaType.APPLICATION_JSON)
	public UnitResponse getUnits(@QueryParam(value = "name")  String name, @QueryParam(value = "unitStartDate") String unitStartDate, @QueryParam(value = "unitEndDate") String unitEndDate,
			@QueryParam(value = "unitTypeCode") String unitTypeCode, @QueryParam(value = "draft") Boolean draft, @QueryParam(value = "unitIdentifier") String unitIdentifier, 
			@QueryParam(value = "marketCode") String marketCode,@DefaultValue("0") @QueryParam(value = "page") int page,@DefaultValue("10") @QueryParam(value = "size") int size ) {
		
		UnitDto unitDto = new UnitDto(name,unitStartDate,unitEndDate,unitTypeCode,draft,unitIdentifier,marketCode,size,page);
		System.out.println(unitDto);
		UnitResponse unitResponse = this.unitService.retrieveUnits(unitDto);
		
		return unitResponse;
	}

}
