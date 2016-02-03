package com.collab.collabapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author Subhash
 *
 */
@Entity
@Table(name = "instituition")
public class Instituition {

	@Id
	@Column(name = "inst_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instId;

	@Column(name = "inst_name", nullable = false, length = 30)
	private String instName;

	@Column(name = "inst_address", nullable = false, length = 70)
	private String instAddress;

	@Column(name = "inst_contactname", nullable = false, length = 30)
	private String instContactname;

	@Column(name = "inst_contactno1", nullable = false, length = 30)
	private String instContactNo1;

	@Column(name = "inst_contactno2", nullable = false, length = 30)
	private String instContactNo2;

	@Column(name = "inst_email_id", nullable = false, length = 30)
	private String instEmailId;

	
	public int getInstId() {
		return instId;
	}

	public void setInstId(int instId) {
		this.instId = instId;
	}

	public String getInstName() {
		return instName;
	}

	public void setInstName(String instName) {
		this.instName = instName;
	}

	public String getInstAddress() {
		return instAddress;
	}

	public void setInstAddress(String instAddress) {
		this.instAddress = instAddress;
	}

	public String getInstContactname() {
		return instContactname;
	}

	public void setInstContactname(String instContactname) {
		this.instContactname = instContactname;
	}

	public String getInstContactNo1() {
		return instContactNo1;
	}

	public void setInstContactNo1(String instContactNo1) {
		this.instContactNo1 = instContactNo1;
	}

	public String getInstContactNo2() {
		return instContactNo2;
	}

	public void setInstContactNo2(String instContactNo2) {
		this.instContactNo2 = instContactNo2;
	}

	public String getInstEmailId() {
		return instEmailId;
	}

	public void setInstEmailId(String instEmailId) {
		this.instEmailId = instEmailId;
	}

}