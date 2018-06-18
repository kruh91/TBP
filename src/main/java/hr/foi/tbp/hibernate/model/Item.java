package hr.foi.tbp.hibernate.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "item")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Audited
public class Item {

	protected Long id;
	
	protected String modifiedByUsername;

	protected Timestamp modificationTime;
	
	public Item() {
	}
	
	public Item(Long id, String modifiedByUsername, Timestamp modificationTime) {
		super();
		this.id = id;
		this.modifiedByUsername = modifiedByUsername;
		this.modificationTime = modificationTime;
	}

	@TableGenerator(name = "itemGen", table = "ID_GEN", pkColumnName = "GEN_KEY", valueColumnName = "GEN_VALUE", pkColumnValue = "ITEM_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "itemGen")
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "modified_by", nullable = false)
	public String getModifiedByUsername() {
		return modifiedByUsername;
	}

	public void setModifiedByUsername(String modifiedByUsername) {
		this.modifiedByUsername = modifiedByUsername;
	}

	@Column(name = "modification_time", nullable = false)
	public Timestamp getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Timestamp modificationTime) {
		this.modificationTime = modificationTime;
	}
}
