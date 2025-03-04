package com.loginreg.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "First Name is required!")
	@Size(min = 3, max = 30, message = "First Name must be between 2 and 30 characters")
	private String firstName;

	@NotBlank(message = "Last Name is required!")
	@Size(min = 3, max = 30, message = "Last Name must be between 2 and 30 characters")
	private String lastName;

	@NotBlank(message = "Email is required!")
	@Email(message = "Please enter a valid email!")
	private String email;

	@NotBlank(message = "Password is required!")
	@Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
	private String password;

	@Transient
	@Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters")
	private String confirmPassword;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date updatedAt;
	
	public User() {
		
	}
	
	public User(
			@NotBlank(message = "First Name is required!") @Size(min = 3, max = 30, message = "First Name must be between 2 and 30 characters") String firstName,
			@NotBlank(message = "Last Name is required!") @Size(min = 3, max = 30, message = "Last Name must be between 2 and 30 characters") String lastName,
			@NotBlank(message = "Email is required!") @Email(message = "Please enter a valid email!") String email,
			@NotBlank(message = "Password is required!") @Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters") String password,
			@Size(min = 8, max = 128, message = "Confirm Password must be between 8 and 128 characters") String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
