package com.nt.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorVO {
	private Integer docId;
	private String docName;
	private String addrs;
	private Double salary;
	private List<String> patients;
}
