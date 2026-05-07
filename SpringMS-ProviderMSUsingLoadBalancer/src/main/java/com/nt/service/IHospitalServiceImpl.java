package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Hospital;
import com.nt.exception.HospitalNotFoundException;
import com.nt.repository.IHospitalRepository;
import com.nt.vo.HospitalVO;

@Service("hospital")
public class IHospitalServiceImpl implements IHospitalService {

	@Autowired
	private IHospitalRepository hospitalRepo;
	
	@Override
	public List<Hospital> findAllHospitals() {
		return hospitalRepo.findAll();
	}

	@Override
	public Hospital findHospitalById(int id) {
		return hospitalRepo.findById(id).orElseThrow(() -> new HospitalNotFoundException("Invalid hospital Id"));
	}

	@Override
	public String updateHospitalAddrs(int id, String addrs) {
		// load the object
		Hospital hs = hospitalRepo.findById(id).orElseThrow(() -> new HospitalNotFoundException("Invalid hospital Id"));
		
		// update the hospital
		hs.setAddrs(addrs);
		
		// save the object
		hospitalRepo.save(hs);
		
		return "Hospital address updated to: "+hs.getAddrs();
	}

	@Override
	public String updateHospitalDetails(HospitalVO hospital) {
		// create entity
		Hospital hs = hospitalRepo.findById(hospital.getHospitalId()).orElseThrow(() -> new HospitalNotFoundException("Invalid hospital"));
		
		// copy the properties
		BeanUtils.copyProperties(hospital, hs);
		
		// save the object
		hospitalRepo.save(hs);
		
		// return the string
		return "Hospital data is updated";
	}

	@Override
	public String deleteHospitalById(int id) {
		// delete the hospital
		hospitalRepo.deleteById(id);
		
		return "Hospital with id is deleted: "+id;
	}

	@Override
	public String registerHospital(HospitalVO doc) {
		// create hospital entity
		Hospital hospital = new Hospital();
		
		// copy the data
		BeanUtils.copyProperties(doc, hospital);
		
		// save the data
		hospitalRepo.save(hospital);
		
		// return msg
		return"Hospital is registered with the id: "+hospital.getHospitalId();
	}

	@Override
	public String registerHospitals(List<HospitalVO> hs) {
		List<Hospital> list = new ArrayList<>();
		
		// iterate over the docs
		hs.forEach(hospital -> {
			
			// crate entity
			Hospital hos = new Hospital();
			
			// copy the data
			BeanUtils.copyProperties(hospital, hos);
			
			// add to list
			list.add(hos);
		});
		
		// get all the ids
		List<Integer> ids = list.stream().map(Hospital::getHospitalId).toList();
		
		return "Hospitals are saved with ids: "+ids;
	}

}
