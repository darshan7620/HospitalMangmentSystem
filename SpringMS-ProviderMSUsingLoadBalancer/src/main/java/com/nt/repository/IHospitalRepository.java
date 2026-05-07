package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Hospital;

public interface IHospitalRepository extends JpaRepository<Hospital, Integer> {

}
