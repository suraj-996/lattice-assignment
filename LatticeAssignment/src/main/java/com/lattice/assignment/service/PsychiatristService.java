package com.lattice.assignment.service;

import java.util.List;

import com.lattice.assignment.exception.HospitalException;
import com.lattice.assignment.exception.PsychiatristException;
import com.lattice.assignment.model.Psychiatrist;

public interface PsychiatristService {
	public List<Psychiatrist> getAllPsychiatrist() throws PsychiatristException;
	public Psychiatrist addPsychiatrist(Integer hospitalId,Psychiatrist psychiatrist) throws PsychiatristException,HospitalException;
}
