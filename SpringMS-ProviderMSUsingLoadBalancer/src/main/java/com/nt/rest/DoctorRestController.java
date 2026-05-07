package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;
import com.nt.vo.DoctorVO;

@RestController
@RequestMapping("/doctor-api")
public class DoctorRestController {

	@Autowired
	private IDoctorService docService;
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer id) {
		return new ResponseEntity<Doctor> (docService.findDocById(id), HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Doctor>> getDoctorById() {
		return new ResponseEntity<List<Doctor>>(docService.findAllDocs(), HttpStatus.OK);
	}
	
	@PatchMapping("/updateSal/{id}/{hike}")
	public ResponseEntity<String> updateDoctorSalById(@PathVariable Integer id, @PathVariable double hike){
		return new ResponseEntity<String> (docService.updateDocSal(id, hike),HttpStatus.OK);
	}
	
	@PatchMapping("/updateAdd/{id}/{addrs}")
	public ResponseEntity<String> updateDoctorAddrsById(@PathVariable Integer id, @PathVariable String addrs){
		return new ResponseEntity<String>(docService.updateDocAddrs(id, addrs),HttpStatus.OK);
	}
	@PutMapping("/updateAll")
	public ResponseEntity<String> updateDoctorAllDetails(@RequestBody DoctorVO vo){
		return new ResponseEntity<String> (docService.updateDoctroDetails(vo),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDocById(@PathVariable Integer id){
		return new ResponseEntity<String> (docService.deleteDocById(id),HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerGiveDoc(@RequestBody DoctorVO doc){
		return new ResponseEntity<String>(docService.registerDoctor(doc),HttpStatus.CREATED);
	}
	
	@PostMapping("/registerAll")
	public ResponseEntity<String> registerAllDoctors(@RequestBody List<DoctorVO> docs){
		return new ResponseEntity<String>(docService.registerDoctors(docs),HttpStatus.CREATED);
	}
}
