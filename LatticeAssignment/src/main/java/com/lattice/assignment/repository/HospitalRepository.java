package com.lattice.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lattice.assignment.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
