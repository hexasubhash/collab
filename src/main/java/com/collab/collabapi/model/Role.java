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
@Table(name = "role")
public class Role {

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int role_id;

	@Column(name = "full_name", nullable = false, length = 30)
	private String roleName;

	@Column(name = "full_name", nullable = false, length = 10)
	private String roleMnemonic;

	@Column(name = "full_name", nullable = false, length = 30)
	private String roleDesc;

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleMnemonic() {
		return roleMnemonic;
	}

	public void setRoleMnemonic(String roleMnemonic) {
		this.roleMnemonic = roleMnemonic;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

}
