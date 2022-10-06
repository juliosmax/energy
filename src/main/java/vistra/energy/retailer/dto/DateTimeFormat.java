package vistra.energy.retailer.dto;

public class DateTimeFormat {
	
	private String date;
	private String time;
	
	
	public DateTimeFormat(String date, String time) {
		super();
		this.date = date;
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
