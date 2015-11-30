package org.loginapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "Login", uniqueConstraints = { @UniqueConstraint(columnNames = "UserName") })
public class LoginDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id = null;
	@Column(name="UserName",unique = true, nullable = false)
	private String username;
	@Column(name="Password",nullable = false,length = 10)
	private String password;
	@OneToOne(fetch=FetchType.LAZY,mappedBy="loginDTO",cascade=CascadeType.ALL)
	private StudentDTO studentDTO;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public StudentDTO getStudentDTO() {
		return studentDTO;
	}

	public void setStudentDTO(StudentDTO studentDTO) {
		this.studentDTO = studentDTO;
	}

	public LoginDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public LoginDTO() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDTO other = (LoginDTO) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginDTO [id=" + id + ", username=" + username + ", password=" + password + ", studentDTO=" + studentDTO
				+ "]";
	}
	
}
