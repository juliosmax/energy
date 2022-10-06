package vistra.energy.retailer.dto;

import java.util.List;

import vistra.energy.retailer.model.Unit;

public class UnitResponse {
	
	//private List<Unit> records;
	
	private List<UnitResponseFormat> records;
	
	private int page;
	
	private int totalPages;
	
	private long totalRecords;
	
	public UnitResponse() {
		
	}

	public List<UnitResponseFormat> getRecords() {
		return records;
	}

	public void setRecords(List<UnitResponseFormat> records) {
		this.records = records;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

}
