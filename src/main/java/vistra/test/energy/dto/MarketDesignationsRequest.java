package vistra.test.energy.dto;

import java.util.List;

import vistra.test.energy.model.UnitMarketDesignation;

public class MarketDesignationsRequest {

	private EffectiveDateMarketDesignation effectiveDate;
	
	private List<UnitMarketDesignation> marketDesignations;
	
	public MarketDesignationsRequest() {
		
	}

	public MarketDesignationsRequest(EffectiveDateMarketDesignation effectiveDate,
			List<UnitMarketDesignation> marketDesignations) {
		super();
		this.effectiveDate = effectiveDate;
		this.marketDesignations = marketDesignations;
	}

	public EffectiveDateMarketDesignation getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(EffectiveDateMarketDesignation effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public List<UnitMarketDesignation> getMarketDesignations() {
		return marketDesignations;
	}

	public void setMarketDesignations(List<UnitMarketDesignation> marketDesignations) {
		this.marketDesignations = marketDesignations;
	}

	@Override
	public String toString() {
		return "MarketDesignationsRequest [effectiveDate=" + effectiveDate + ", marketDesignations="
				+ marketDesignations + "]";
	}
	
	
}
