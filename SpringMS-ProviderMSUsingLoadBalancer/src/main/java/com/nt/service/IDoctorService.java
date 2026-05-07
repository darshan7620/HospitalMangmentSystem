package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;
import com.nt.vo.DoctorVO;

public interface IDoctorService {
	public List<Doctor> findAllDocs();
	public Doctor findDocById(int id); // done
	public String updateDocSal(int id, double hike); // done
	public String updateDocAddrs(int id, String addrs); // done
	public String updateDoctroDetails(DoctorVO doc); // done
	public String deleteDocById(int id); // done
	public String registerDoctor(DoctorVO doc); // done
	public String registerDoctors(List<DoctorVO> docs); // done
}
