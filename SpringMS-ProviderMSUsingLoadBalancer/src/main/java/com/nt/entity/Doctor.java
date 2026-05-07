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
public class Doctor {

	@Id
	@SequenceGenerator(name="seq",sequenceName="gen1",initialValue=8829,allocationSize=1)
	@GeneratedValue(generator="seq",strategy=GenerationType.IDENTITY)
	private Integer docId;
	@Column(length=30)
	@NonNull
	private String docName;
	@Column(length=30)
	@NonNull
	private String addrs;
	@NonNull
	private Double salary;
	
	@ElementCollection
	@NonNull
	private List<String> patients;
}
