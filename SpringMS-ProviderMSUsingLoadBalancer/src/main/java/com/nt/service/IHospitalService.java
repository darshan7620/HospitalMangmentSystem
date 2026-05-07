package com.nt.service;

import java.util.List;

import com.nt.entity.Hospital;
import com.nt.vo.HospitalVO;

public interface IHospitalService {
	public List<Hospital> findAllHospitals(); // done
	public Hospital findHospitalById(int id); //done
	public String updateHospitalAddrs(int id, String addrs);//done
	public String updateHospitalDetails(HospitalVO hospital); // done
	public String deleteHospitalById(int id); // done
	public String registerHospital(HospitalVO doc); // done
	public String registerHospitals(List<HospitalVO> docs); // done
}
