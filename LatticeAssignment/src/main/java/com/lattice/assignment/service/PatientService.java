package com.lattice.assignment.service;

import com.lattice.assignment.exception.PatientException;
import com.lattice.assignment.exception.PsychiatristException;
import com.lattice.assignment.model.Patient;

public interface PatientService {
	public Patient registerPatient(Integer psychiatristId, Patient patient) throws PatientException,PsychiatristException;
}
