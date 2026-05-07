package com.nt.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Hospital {
	
	@Id
	@SequenceGenerator(name="seq",sequenceName="gen1",initialValue=1011,allocationSize=1)
	@GeneratedValue(generator="seq",strategy=GenerationType.IDENTITY)
	private Integer hospitalId;
	@Column(length=30)
	@NonNull
	private String hospitalName;
	@Column(length=30)
	@NonNull
	private String addrs;
	
	@ElementCollection
	@Column(name="doctors")
	private List<Doctor> docs;
}
