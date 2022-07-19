package dinhgt.springboot.sbtrainingusers.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "account", schema = "my_schema")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 36, nullable = false, updatable = false)
	private int id;

	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name", length = 65)
	@NonNull
	private String firtName;

	@Column(name = "last_name", length = 65)
	@NonNull
	private String lastName;

	@Column(name = "email")
	@NonNull
	private String email;

	@Column(name = "phone", length = 10)
	@NonNull
	private String phone;

	@Column(name = "created_date")
	private LocalDateTime createdDate;

	@Column(name = "update_date")
	private LocalDateTime updateDate;

	@Column(name = "device_token")
	private String deviceToken;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account( String firtName, String lastName, String email, String phone,
			LocalDateTime createdDate, LocalDateTime updateDate) {
		super();

		this.firtName = firtName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.createdDate = createdDate;
		this.updateDate = updateDate;
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
	
	
}
