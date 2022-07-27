package dinhgt.springboot.sbtrainingusers.dtos;

import dinhgt.springboot.sbtrainingusers.enums.ERole;

public class RoleDTO {

	private int roleId;

	private ERole roleName;

	public RoleDTO() {
		// TODO Auto-generated constructor stub
	}

	public RoleDTO(int roleId, ERole roleName) {
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
