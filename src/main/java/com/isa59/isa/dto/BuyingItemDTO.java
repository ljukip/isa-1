package com.isa59.isa.dto;

public class BuyingItemDTO {
	
	private Long medicationID;
	private int quantity;
	private String medicationName;
	
	public BuyingItemDTO() {}

	public Long getMedicationID() {
		return medicationID;
	}

	public void setMedicationID(Long medicationID) {
		this.medicationID = medicationID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getMedicationName() {
		return medicationName;
	}

	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}

	
	
}
