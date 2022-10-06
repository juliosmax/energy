package vistra.energy.retailer.dto;

import java.util.Date;

public class UnitResponseFormat {
	
	private Long id;
	
	private String name;
	
	private String internalShortName;
	
	private String internalLongName;
	
	private String unitTypeCode;
	
	private DateTimeFormat unitEndDate;
	
	private DateTimeFormat unitStartDate;
	
	
	private Boolean draft;
	
	private String unitIdentifier;
	
	public UnitResponseFormat() {
		
	}

	public UnitResponseFormat(Long id, String name, String internalShortName, String internalLongName,
			DateTimeFormat unitEndDate, DateTimeFormat unitStartDate, String unitTypeCode, Boolean draft,
			String unitIdentifier) {
		super();
		this.id = id;
		this.name = name;
		this.internalShortName = internalShortName;
		this.internalLongName = internalLongName;
		this.unitEndDate = unitEndDate;
		this.unitStartDate = unitStartDate;
		this.unitTypeCode = unitTypeCode;
		this.draft = draft;
		this.unitIdentifier = unitIdentifier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInternalShortName() {
		return internalShortName;
	}

	public void setInternalShortName(String internalShortName) {
		this.internalShortName = internalShortName;
	}

	public String getInternalLongName() {
		return internalLongName;
	}

	public void setInternalLongName(String internalLongName) {
		this.internalLongName = internalLongName;
	}

	public DateTimeFormat getUnitEndDate() {
		return unitEndDate;
	}

	public void setUnitEndDate(DateTimeFormat unitEndDate) {
		this.unitEndDate = unitEndDate;
	}

	public DateTimeFormat getUnitStartDate() {
		return unitStartDate;
	}

	public void setUnitStartDate(DateTimeFormat unitStartDate) {
		this.unitStartDate = unitStartDate;
	}

	public String getUnitTypeCode() {
		return unitTypeCode;
	}

	public void setUnitTypeCode(String unitTypeCode) {
		this.unitTypeCode = unitTypeCode;
	}

	public Boolean getDraft() {
		return draft;
	}

	public void setDraft(Boolean draft) {
		this.draft = draft;
	}

	public String getUnitIdentifier() {
		return unitIdentifier;
	}

	public void setUnitIdentifier(String unitIdentifier) {
		this.unitIdentifier = unitIdentifier;
	}

	@Override
	public String toString() {
		return "UnitResponseFormat [id=" + id + ", name=" + name + ", internalShortName=" + internalShortName
				+ ", internalLongName=" + internalLongName + ", unitEndDate=" + unitEndDate + ", unitStartDate="
				+ unitStartDate + ", unitTypeCode=" + unitTypeCode + ", draft=" + draft + ", unitIdentifier="
				+ unitIdentifier + "]";
	}
	
	

}
