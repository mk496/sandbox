package com.cg.mobinv.mobileinventory.common.api.to;

import org.apache.olingo.odata2.api.annotation.edm.*;

@EdmEntityType(name = "Payhdt")
@EdmEntitySet(name = "PayhdtSet")
public class PayhdtTo {
	
	@EdmKey
    @EdmProperty
    private Long id;
	
	@EdmProperty
	private String storeNumber;
	
	@EdmProperty
	private String hdtday;
			
	public PayhdtTo() {}
	
	public PayhdtTo(Long id, String storeNumber, String hdtday ) {
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
	