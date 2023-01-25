package com.lattice.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lattice.assignment.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
