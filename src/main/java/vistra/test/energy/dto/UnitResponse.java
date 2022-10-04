package vistra.test.energy.dto;

import java.util.List;

import vistra.test.energy.model.Unit;

public class UnitResponse {
	
	private List<Unit> records;
	
	private int pageSize;
	
	private int totalPages;
	
	private int totalRecords;

	public List<Unit> getRecords() {
		return records;
	}

	public void setRecords(List<Unit> records) {
		this.records = records;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

}
