package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Hospital;
import com.nt.service.IHospitalService;

@RestController
@RequestMapping("/hospital-api")
public class HospitalRestController {
	
	@Autowired
	private IHospitalService hosRepo;
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Hospital>> getAllHospitals(){
		return new ResponseEntity<List<Hospital>> (hosRepo.findAllHospitals(), HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Hospital> getHospital(@PathVariable Integer id){
		return new ResponseEntity<Hospital> (hosRepo.findHospitalById(id),HttpStatus.OK);
	}
}
