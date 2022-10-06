package vistra.energy.retailer.model;

import java.util.Date;

import javax.persistence.Column;
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
	
	private String registrationCode;
	@Column(name="market_share_percent")
	private Integer marketShare;
	
	public UnitMarketDesignation() {
		
	}

	public UnitMarketDesignation(Long id, Long unitId, Long marketId, Date effective_date, String registrationCode,
			Integer marketShare) {
		super();
		this.id = id;
		this.unitId = unitId;
		this.marketId = marketId;
		this.effective_date = effective_date;
		this.registrationCode = registrationCode;
		this.marketShare = marketShare;
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

	public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}

	public Integer getMarketShare() {
		return marketShare;
	}

	public void setMarketSharePercent(Integer marketShare) {
		this.marketShare = marketShare;
	}

	@Override
	public String toString() {
		return "UnitMarketDesignation [id=" + id + ", unitId=" + unitId + ", marketId=" + marketId + ", effective_date="
				+ effective_date + ", registrationCode=" + registrationCode + ", marketShare="
				+ marketShare + "]";
	}
	
	

}
