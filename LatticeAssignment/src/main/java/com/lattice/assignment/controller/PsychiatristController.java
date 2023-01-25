package com.lattice.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.assignment.exception.HospitalException;
import com.lattice.assignment.exception.PsychiatristException;
import com.lattice.assignment.model.Psychiatrist;
import com.lattice.assignment.service.PsychiatristService;

@RestController
public class PsychiatristController {
	@Autowired
	private PsychiatristService psychiatristService;
	
	@GetMapping("/psychiatrist")
	public ResponseEntity<List<Psychiatrist>> getAllPsychiatrist() throws PsychiatristException{
		return new ResponseEntity<List<Psychiatrist>>(psychiatristService.getAllPsychiatrist(),HttpStatus.OK);
		
	}
	
	@PostMapping("/psychiatrist/{hospitalId}")
	public ResponseEntity<Psychiatrist> addPsychiatrist(@PathVariable Integer hospitalId,@RequestBody Psychiatrist psychiatrist) throws PsychiatristException, HospitalException{
		return new ResponseEntity<Psychiatrist>(psychiatristService.addPsychiatrist(hospitalId,psychiatrist),HttpStatus.OK);
	}
}
