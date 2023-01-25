package com.lattice.assignment.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lattice.assignment.exception.PatientException;
import com.lattice.assignment.exception.PsychiatristException;
import com.lattice.assignment.model.Patient;
import com.lattice.assignment.model.Psychiatrist;
import com.lattice.assignment.repository.PatientRepository;
import com.lattice.assignment.repository.PsychiatristRepository;
import com.lattice.assignment.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PsychiatristRepository psychiatristRepository;
	

	@Override
	public Patient registerPatient(Integer psychiatristId, Patient patient)
			throws PatientException, PsychiatristException {
		if(patient==null) {
			throw new PatientException("Patient not saved");
		}else {
			Optional<Psychiatrist> psyOptional=psychiatristRepository.findById(psychiatristId);
			if(psyOptional.isPresent()) {
				Psychiatrist psychiatrist=psyOptional.get();
				psychiatrist.setPatients(new ArrayList<>());
				psychiatrist.getPatients().add(patient);
				patient.setPsychiatrist(psychiatrist);
				return patientRepository.save(patient);
			}else {
				throw new PsychiatristException("psychiatrist is not found");
			}
		}
	}

}
