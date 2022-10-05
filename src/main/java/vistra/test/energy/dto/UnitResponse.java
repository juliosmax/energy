package vistra.test.energy.dto;

import java.util.List;

import vistra.test.energy.model.Unit;

public class UnitResponse {
	
	private List<Unit> records;
	
	private int page;
	
	private int totalPages;
	
	private long totalRecords;
	
	public UnitResponse() {
		
	}

	public List<Unit> getRecords() {
		return records;
	}

	public void setRecords(List<Unit> records) {
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
