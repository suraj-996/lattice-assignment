package com.lattice.assignment.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lattice.assignment.exception.HospitalException;
import com.lattice.assignment.model.Hospital;
import com.lattice.assignment.model.Psychiatrist;
import com.lattice.assignment.model.PsychiatristDetails;
import com.lattice.assignment.repository.HospitalRepository;
import com.lattice.assignment.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService{
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Override
	public List<Hospital> getAllHospitals() throws HospitalException {
		List<Hospital> hospitals=hospitalRepository.findAll();
		if(hospitals.size()==0) {
			throw new HospitalException("hospital not found");
		}else {
			return hospitals;
		}
	}

	@Override
	public Map<String,Object> getHospitalDetails(Integer hospitalId) throws HospitalException {
		
		
		Map<String, Object> response = new HashMap<>();
        Hospital hospital = hospitalRepository.findById(hospitalId).get();
        if(hospital==null) {
        	throw new HospitalException("hospital not found");
        }else {
        	 List<Psychiatrist> psychiatrists = hospital.getPsychiatrists();
             int totalPatients = 0;
             List<PsychiatristDetails> psychiatristDetailsList=new ArrayList<>();
             
             for (Psychiatrist psychiatrist : psychiatrists) {
                 totalPatients += psychiatrist.getPatients().size();
                 PsychiatristDetails psychiatristDetails=new PsychiatristDetails();
                 psychiatristDetails.setId(psychiatrist.getId());
                 psychiatristDetails.setName(psychiatrist.getName());
                 psychiatristDetails.setPatientCount(psychiatrist.getPatients().size());
                 psychiatristDetailsList.add(psychiatristDetails);
                 
             }
     	        response.put("Hospital name", hospital.getName());
     	        response.put("Total Psychiatrist count", psychiatrists.size());
     	        response.put("Total patients count", totalPatients);
     	        response.put("Psychiatrist Details", psychiatristDetailsList);
         }
        return response;
     }

	@Override
	public Hospital createHospital(Hospital hospital) throws HospitalException {
		Hospital savedHospital=hospitalRepository.save(hospital);
		return savedHospital;
	}
       
}

