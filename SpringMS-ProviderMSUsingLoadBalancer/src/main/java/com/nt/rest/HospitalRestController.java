package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Hospital;
import com.nt.service.IHospitalService;
import com.nt.vo.HospitalVO;

@RestController
@RequestMapping("/hospital-api")
public class HospitalRestController {

	@Autowired
	private IHospitalService hosRepo;

	@GetMapping("/findAll")
	public ResponseEntity<List<Hospital>> getAllHospitals() {
		return new ResponseEntity<List<Hospital>>(hosRepo.findAllHospitals(), HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Hospital> getHospital(@PathVariable Integer id) {
		return new ResponseEntity<Hospital>(hosRepo.findHospitalById(id), HttpStatus.OK);
	}

	@PutMapping("/updateAddr/{id}/{addr}")
	public ResponseEntity<String> updateHospitalAddress(@PathVariable Integer id, @PathVariable String addr) {
		return new ResponseEntity<String>(hosRepo.updateHospitalAddrs(id, addr), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateHos")
	public ResponseEntity<String> updateHospitalDetails(@RequestBody HospitalVO hos){
		return new ResponseEntity<String>(hosRepo.updateHospitalDetails(hos),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteHospitalById(@PathVariable Integer id){
		return new ResponseEntity<String>(hosRepo.deleteHospitalById(id),HttpStatus.OK);
	}
	
	@PutMapping("/register")
	public ResponseEntity<String> registerHospital(@RequestBody HospitalVO hos){
		return new ResponseEntity<String> (hosRepo.registerHospital(hos),HttpStatus.CREATED);
	}
	
	@PutMapping("/registerAll")
	public ResponseEntity<String> registerAllHospitals(@RequestBody List<HospitalVO> hospitals){
		return new ResponseEntity<String> (hosRepo.registerHospitals(hospitals),HttpStatus.CREATED);
	}
}
