package vistra.energy.retailer.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import vistra.energy.retailer.exception.BadDateTimeException;

public class EffectiveDateMarketDesignation {

	private String date;
	
	private String time;

	public EffectiveDateMarketDesignation(String date, String time) {
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
	
	public Date getEffectiveDate()  {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 try {
			Date effectiveDate=formatter.parse(this.date+" "+this.time);
			return effectiveDate;
		} catch (ParseException e) {
			throw new BadDateTimeException("Bad date or time request");
		}  
		 
	}

	@Override
	public String toString() {
		return "EffectiveDateMarketDesignation [date=" + date + ", time=" + time + "]";
	}
	
}
