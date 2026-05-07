package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.exception.DoctorNotFoundException;
import com.nt.repository.IDoctorRepository;
import com.nt.vo.DoctorVO;

@Service("doctor")
public class IDoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepository docRepo;
	
	@Override
	public List<Doctor> findAllDocs() {
		return docRepo.findAll();
	}

	@Override
	public Doctor findDocById(int id) {
		return docRepo.findById(id).orElseThrow(() -> new DoctorNotFoundException("Invalid doctor Id!!!"));
	}

	@Override
	public String updateDocSal(int id, double hike) {
		// load the object
		Doctor doc = docRepo.findById(id).orElseThrow(() -> new DoctorNotFoundException("Invalid doctor Id!!!"));
		
		// update the sal
		doc.setSalary(doc.getSalary()*hike/100.0);
		
		// save the object and return the msg
		docRepo.save(doc);
		
		// return msg
		return "Doctor salary updated to: "+doc.getSalary();
	}

	@Override
	public String updateDocAddrs(int id, String addrs) {
		// load the object
		Doctor doc = docRepo.findById(id).orElseThrow(() -> new DoctorNotFoundException("Invalid doctor Id!!!"));
				
		// update the sal
		doc.setAddrs(addrs);
				
		// save the object and return the msg
		docRepo.save(doc);
				
		// return msg
		return "Doctor update address is: "+doc.getAddrs();
	}

	@Override
	public String deleteDocById(int id) {
		// delete the doc having id
		docRepo.deleteById(id);
		
		// return msg
		return "Doctor deleted with id: "+id;
	}

	@Override
	public String registerDoctor(DoctorVO doc) {
		// create entity class object
		Doctor doctor = new Doctor();
		
		// copy the object details
		BeanUtils.copyProperties(doc, doctor);
		
		// now save the object
		docRepo.save(doctor);
		
		// return msg
		return "Doctor saved with the id: "+doctor.getDocId();
	}

	@Override
	public String registerDoctors(List<DoctorVO> docs) {
		
		List<Doctor> list = new ArrayList<>();
		
		// iterate over the list
		docs.forEach(doc -> {
			// create entity object 
			Doctor doctor = new Doctor();
			
			// copy the properties to the doc
			BeanUtils.copyProperties(doc, doctor);
			
			// add the docs to the list
			list.add(doctor);
		});
		
		List<Integer> ids = list.stream().map(Doctor::getDocId).toList();
		return "All Doctors are registerd with ids: "+ids;
	}

	@Override
	public String updateDoctroDetails(DoctorVO doc) {
		// load the object
		Doctor doctor = docRepo.findById(doc.getDocId()).orElseThrow(() -> new DoctorNotFoundException("Invalid doctor Id!!!"));
		
		// now update copy the properties
		BeanUtils.copyProperties(doc, doctor);
		
		// save the object
		docRepo.save(doctor);
		
		return "Doctor is updated with new data";
	}
}
