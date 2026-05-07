package com.nt.service;

import java.util.List;

import com.nt.entity.Hospital;
import com.nt.vo.HospitalVO;

public interface IHospitalService {
	public List<Hospital> findAllHospitals(); // done
	public Hospital findHospitalById(int id);
	public String updateHospitalAddrs(int id, String addrs);
	public String updateHospitalDetails(HospitalVO hospital);
	public String deleteHospitalById(int id);
	public String registerHospital(HospitalVO doc);
	public String registerHospitals(List<HospitalVO> docs);
}
