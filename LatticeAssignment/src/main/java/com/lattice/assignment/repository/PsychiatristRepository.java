package com.lattice.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lattice.assignment.model.Psychiatrist;

public interface PsychiatristRepository extends JpaRepository<Psychiatrist, Integer>{

}
