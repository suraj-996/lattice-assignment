package com.lattice.assignment.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lattice.assignment.exception.HospitalException;
import com.lattice.assignment.exception.PsychiatristException;
import com.lattice.assignment.model.Hospital;
import com.lattice.assignment.model.Psychiatrist;
import com.lattice.assignment.repository.HospitalRepository;
import com.lattice.assignment.repository.PsychiatristRepository;
import com.lattice.assignment.service.PsychiatristService;



@Service
public class PsychiatristServiceImpl implements PsychiatristService{

	@Autowired
	private PsychiatristRepository psychiatristRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	@Override
	public List<Psychiatrist> getAllPsychiatrist() throws PsychiatristException {
		List<Psychiatrist> psychiatrists=psychiatristRepository.findAll();
		return psychiatrists;
	}
	@Override
	public Psychiatrist addPsychiatrist(Integer hospitalId,Psychiatrist psychiatrist) throws PsychiatristException,HospitalException {
		if(psychiatrist==null) {
			throw new PsychiatristException("psychiatrist is not saved");
		}else {
			Optional<Hospital> hospitalOpt=hospitalRepository.findById(hospitalId);
			if(hospitalOpt.isPresent()) {
				Hospital hospital=hospitalOpt.get();
				hospital.setPsychiatrists(new ArrayList<>());
		        hospital.getPsychiatrists().add(psychiatrist);
		        psychiatrist.setHospital(hospital);
		        return psychiatristRepository.save(psychiatrist);
				
			}else {
				throw new HospitalException("Hospital not found");
			}
			
		}
		
		
	}

}
