package org.loginapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Student", uniqueConstraints = { @UniqueConstraint(columnNames = "Email") })
public class StudentDTO {

	@Id
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "loginDTO") )
	@GeneratedValue(generator = "generator")
	private Integer id = null;

	@Column(name = "Name", nullable = false)
	private String name;
	@Column(name="Passout", nullable= false)
	private String passout;
	@Column(name = "Email", nullable = false)
	private String email;
	@Column(name = "percent10", nullable = false)
	private double percent10;
	@Column(name = "percent12", nullable = false)
	private double percent12;
	@Column(name = "Stream", nullable = false)
	private String stream;
	@Column(name = "percentDegree", nullable = false)
	private double percentDegree;
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private LoginDTO loginDTO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getPercent10() {
		return percent10;
	}

	public void setPercent10(double percent10) {
		this.percent10 = percent10;
	}
	
	public String getPassout() {
		return passout;
	}

	public void setPassout(String passout) {
		this.passout = passout;
	}

	public double getPercent12() {
		return percent12;
	}

	public void setPercent12(double percent12) {
		this.percent12 = percent12;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public double getPercentDegree() {
		return percentDegree;
	}

	public void setPercentDegree(double percentDegree) {
		this.percentDegree = percentDegree;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", passout=" + passout + ", email=" + email + ", percent10="
				+ percent10 + ", percent12=" + percent12 + ", stream=" + stream + ", percentDegree=" + percentDegree
				+ "]";
	}
	
	
}
