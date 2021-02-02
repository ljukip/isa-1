package com.isa59.isa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa59.isa.dto.BuyingDTO;
import com.isa59.isa.dto.BuyingItemDTO;
import com.isa59.isa.model.Buying;
import com.isa59.isa.model.BuyingItem;
import com.isa59.isa.model.Medication;
import com.isa59.isa.model.PharmacyAdmin;
import com.isa59.isa.model.User;
import com.isa59.isa.repository.BuyingRepository;
import com.isa59.isa.repository.MedicationRepository;
import com.isa59.isa.repository.PharmacyAdminRepository;
import com.isa59.isa.repository.PharmacyRepository;
import com.isa59.isa.repository.UserRepository;

@Service
public class BuyingService {

	@Autowired
	private BuyingRepository buyingRepository;
	
	@Autowired
	private MedicationRepository medicationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PharmacyAdminRepository pharmacyAdminRepository;
	
	
	
	public BuyingDTO create(String userName, BuyingDTO buyingDTO) {
		
		Buying buying = new Buying();
		buying.setDueDate(buyingDTO.getDueDate());
		
		List<BuyingItem> items = buyingDTO.getItems().stream().map(b->BIfromBIDTO(b)).collect(Collectors.toList());
		buying.setItems(items);
		
		User u = userRepository.findByUsername(userName);
		PharmacyAdmin pa = pharmacyAdminRepository.findById(u.getId()).get();
		buying.setPharmacy(pa.getPharmacy());
		
		buyingRepository.saveAndFlush(buying);
		return BDTOfromB(buying);
	}

	
	private BuyingItem BIfromBIDTO(BuyingItemDTO biDTO) {
		BuyingItem b = new BuyingItem();
		Medication m = medicationRepository.findById(biDTO.getMedicationID()).get();
		
		b.setQuantity(biDTO.getQuantity());
		b.setMedication(m);
		return b;
	}
	
	
	private BuyingItemDTO BIDTOfromBI(BuyingItem bi) {
		BuyingItemDTO biDTO = new BuyingItemDTO();
		
		
		biDTO.setMedicationID(bi.getMedication().getId());
		biDTO.setMedicationName(bi.getMedication().getName());
		biDTO.setQuantity(bi.getQuantity());
		
		return biDTO;
	}
	
	private BuyingDTO BDTOfromB(Buying b) {
		BuyingDTO ret = new BuyingDTO();
		ret.setDueDate(b.getDueDate());
		ret.setFinished(b.isFinished());
		ret.setId(b.getId());
		ret.setItems(b.getItems().stream().map(bi->BIDTOfromBI(bi)).collect(Collectors.toList()));
		return ret;
	}

}
