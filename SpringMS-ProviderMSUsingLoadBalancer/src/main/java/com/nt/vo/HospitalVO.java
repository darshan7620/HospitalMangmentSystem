package com.nt.vo;

import java.util.List;

import com.nt.entity.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalVO {
	private Integer hospitalId;
	private String hospitalName;
	private String addrs;
	private List<Doctor> docs;
}
