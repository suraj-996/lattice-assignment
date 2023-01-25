package com.lattice.assignment.service;

import java.util.List;
import java.util.Map;

import com.lattice.assignment.exception.HospitalException;
import com.lattice.assignment.model.Hospital;

public interface HospitalService {
	public Hospital createHospital(Hospital hospital) throws HospitalException;
	public List<Hospital> getAllHospitals() throws HospitalException;
	public Map<String,Object> getHospitalDetails(Integer hospitalId) throws HospitalException;
}


