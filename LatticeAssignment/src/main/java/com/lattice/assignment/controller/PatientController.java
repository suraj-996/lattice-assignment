package com.lattice.assignment.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lattice.assignment.exception.PatientException;
import com.lattice.assignment.exception.PsychiatristException;
import com.lattice.assignment.model.Patient;
import com.lattice.assignment.service.PatientService;

import jakarta.validation.Valid;

@RestController
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@PostMapping("/patient/{psychiatristId}")
	public ResponseEntity<Patient> registerPatient(@PathVariable Integer psychiatristId,@Valid @RequestBody Patient patient) throws PatientException, PsychiatristException{
		return new ResponseEntity<Patient>(patientService.registerPatient(psychiatristId,patient),HttpStatus.CREATED);
		
	}
	
	
}
