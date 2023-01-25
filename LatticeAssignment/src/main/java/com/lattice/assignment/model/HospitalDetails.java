package com.lattice.assignment.model;

import java.util.List;

import lombok.Data;

@Data
public class HospitalDetails {
	private String name;
	private Integer psychiatristCount;
	private Integer patientsCount;
	private List<Psychiatrist> psychiatrists;
}

