package vistra.test.energy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "unit_market_designation")
public class UnitMarketDesignation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Long unitId;
	
	private Long marketId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date effective_date;
	
	private String registration_code;
	
	private Integer market_share_percent;
	
	public UnitMarketDesignation() {
		
	}

	public UnitMarketDesignation(Long id, Long unitId, Long marketId, Date effective_date, String registration_code,
			Integer market_share_percent) {
		super();
		this.id = id;
		this.unitId = unitId;
		this.marketId = marketId;
		this.effective_date = effective_date;
		this.registration_code = registration_code;
		this.market_share_percent = market_share_percent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Date getEffective_date() {
		return effective_date;
	}

	public void setEffective_date(Date effective_date) {
		this.effective_date = effective_date;
	}

	public String getRegistration_code() {
		return registration_code;
	}

	public void setRegistration_code(String registration_code) {
		this.registration_code = registration_code;
	}

	public Integer getMarket_share_percent() {
		return market_share_percent;
	}

	public void setMarket_share_percent(Integer market_share_percent) {
		this.market_share_percent = market_share_percent;
	}
	
	

}
