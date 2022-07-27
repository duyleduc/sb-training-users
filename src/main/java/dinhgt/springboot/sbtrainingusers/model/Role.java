package dinhgt.springboot.sbtrainingusers.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import dinhgt.springboot.sbtrainingusers.enums.ERole;

@Entity
@Table(name = "role", schema = "my_schema")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role_name")
	private ERole roleName;
	
	@OneToMany(mappedBy = "roles", cascade = CascadeType.ALL)
	private List<Account> items;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Role(int roleId, ERole roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public ERole getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(ERole roleName) {
		this.roleName = roleName;
	}

	
	
}
