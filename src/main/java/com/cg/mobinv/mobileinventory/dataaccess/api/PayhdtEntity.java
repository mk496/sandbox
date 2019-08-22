package com.cg.mobinv.mobileinventory.dataaccess.api;

import javax.persistence.*;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "\"mpharmdb.db.dbmodel::mpharm.Payhdt\"")
public class PayhdtEntity {
	
	@javax.persistence.Id
    @SequenceGenerator(name = "S_Payhdt", sequenceName = "\"mpharmdb.db::S_Payhdt\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_Payhdt")
	private Long id;
	
	@Nationalized
	@Column(name = "\"StoreNumber\"")
	private String storeNumber;
	
	@Nationalized
	@Column(name = "\"HDTDAY\"")
	private String hdtday;
	
	
	public PayhdtEntity() {}
	
	public PayhdtEntity(Long id, String storeNumber, String hdtday) {
		this.id = id;
		this.storeNumber = storeNumber;
		this.hdtday = hdtday;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getHdtday() {
		return hdtday;
	}

	public void setHdtday(String hdtday) {
		this.hdtday = hdtday;
	}

}
