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
@Table(name = "unit")
public class Unit {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String name;
	private String internalShortName;
	private String internalLongName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date unitStartDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date unitEndDate;
	
	private Long unitTypeId;
	
	private boolean draft;
	
	private String unitIdentifier;
	
    public Unit() {
		
	}
	
	public Unit(Long id, String name, String internalShortName, String internalLongName, Date unitStartDate,
			Date unitEndDate, Long unitTypeId, boolean draft, String unitIdentifier) {
		super();
		this.id = id;
		this.name = name;
		this.internalShortName = internalShortName;
		this.internalLongName = internalLongName;
		this.unitStartDate = unitStartDate;
		this.unitEndDate = unitEndDate;
		this.unitTypeId = unitTypeId;
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

	public Date getUnitStartDate() {
		return unitStartDate;
	}

	public void setUnitStartDate(Date unitStartDate) {
		this.unitStartDate = unitStartDate;
	}

	public Date getUnitEndDate() {
		return unitEndDate;
	}

	public void setUnitEndDate(Date unitEndDate) {
		this.unitEndDate = unitEndDate;
	}

	public Long getUnitTypeId() {
		return unitTypeId;
	}

	public void setUnitTypeId(Long unitTypeId) {
		this.unitTypeId = unitTypeId;
	}

	public boolean isDraft() {
		return draft;
	}

	public void setDraft(boolean draft) {
		this.draft = draft;
	}

	public String getUnitIdentifier() {
		return unitIdentifier;
	}

	public void setUnitIdentifier(String unitIdentifier) {
		this.unitIdentifier = unitIdentifier;
	}

	
	
	
}
