package vistra.test.energy.dto;

public class UnitDto {

	private String name;
	
	private String unitStartDate;
	
	private String unitEndDate;
	
	private String unitTypeCode;
	
	private Boolean draft;
	
	private String unitIdentifier;
	
	private String marketCode;
	
	private int size;
	
	private int page;



	public UnitDto(String name, String unitStartDate, String unitEndDate, String unitTypeCode, Boolean draft,
			String unitIdentifier, String marketCode, int size, int page) {
		super();
		this.name = name;
		this.unitStartDate = unitStartDate;
		this.unitEndDate = unitEndDate;
		this.unitTypeCode = unitTypeCode;
		this.draft = draft;
		this.unitIdentifier = unitIdentifier;
		this.marketCode = marketCode;
		this.size = size;
		this.page = page;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnitStartDate() {
		return unitStartDate;
	}

	public void setUnitStartDate(String unitStartDate) {
		this.unitStartDate = unitStartDate;
	}

	public String getUnitEndDate() {
		return unitEndDate;
	}

	public void setUnitEndDate(String unitEndDate) {
		this.unitEndDate = unitEndDate;
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

	public String getMarketCode() {
		return marketCode;
	}

	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	

	@Override
	public String toString() {
		return "UnitDto [name=" + name + ", unitStartDate=" + unitStartDate + ", unitEndDate=" + unitEndDate
				+ ", unitTypeCode=" + unitTypeCode + ", draft=" + draft + ", unitIdentifier=" + unitIdentifier
				+ ", marketCode=" + marketCode + "]";
	}
	
}
