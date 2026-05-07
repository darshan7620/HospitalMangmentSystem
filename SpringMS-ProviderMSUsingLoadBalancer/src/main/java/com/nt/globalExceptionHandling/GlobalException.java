package com.nt.globalExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exception.DoctorNotFoundException;
import com.nt.exception.HospitalNotFoundException;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<DoctorNotFoundException> doctorExecption() {
		return new ResponseEntity<DoctorNotFoundException>(new DoctorNotFoundException("Doctor Not Found!"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(HospitalNotFoundException.class)
	public ResponseEntity<HospitalNotFoundException> hostptalException() {
		return new ResponseEntity<HospitalNotFoundException>(new HospitalNotFoundException("Hospital Not Found"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> globleException() {
		return new ResponseEntity<Exception>(new Exception("Something went wrong!"), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
