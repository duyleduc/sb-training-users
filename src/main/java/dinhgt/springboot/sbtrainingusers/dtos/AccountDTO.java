package dinhgt.springboot.sbtrainingusers.dtos;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AccountDTO {

	private int id;
	@NonNull
	private String firtName;
	@NonNull
	private String lastName;
	@NonNull
	@JsonIgnore
	private String password;
	@NonNull
	private String email;
	@NonNull
	private String phone;

	private boolean isActivated;

	private String deviceToken;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateDate;

	private RoleDTO roles;

	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}

	public AccountDTO(int id, String firtName, String lastName, String password, String email, String phone,
			boolean isActivated, String deviceToken, LocalDateTime createdDate, LocalDateTime updateDate,
			RoleDTO roles) {
		super();
		this.id = id;
		this.firtName = firtName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.isActivated = isActivated;
		this.deviceToken = deviceToken;
		this.createdDate = createdDate;
		this.updateDate = updateDate;
		this.roles = roles;
	}

	/**
	 * @return the roles
	 */
	public RoleDTO getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(RoleDTO roles) {
		this.roles = roles;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirtName() {
		return firtName;
	}

	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the isActivated
	 */
	public boolean isActivated() {
		return isActivated;
	}

	/**
	 * @param isActivated the isActivated to set
	 */
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	/**
	 * @return the deviceToken
	 */
	public String getDeviceToken() {
		return deviceToken;
	}

	/**
	 * @param deviceToken the deviceToken to set
	 */
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

}
