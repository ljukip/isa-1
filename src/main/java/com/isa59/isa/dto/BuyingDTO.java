package com.isa59.isa.dto;

import java.time.LocalDate;
import java.util.List;

public class BuyingDTO {
	
	private Long id;
	private LocalDate dueDate;
	private List<BuyingItemDTO> items;
	private boolean finished;
	
	public BuyingDTO() {}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public List<BuyingItemDTO> getItems() {
		return items;
	}
	public void setItems(List<BuyingItemDTO> items) {
		this.items = items;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

}
