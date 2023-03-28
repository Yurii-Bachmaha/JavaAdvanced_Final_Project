package project.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column
	private Integer age;

	@Column(unique = true)
	private String email;

	@Column
	private String password;

	@Column(name = "password_confirm")
	private String passwordConfirm;

	@Lob
	private String encodedImage;

	@Enumerated(EnumType.STRING)
	private UserRole role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Certificate> certificates = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
	private Faculty faculties;

	public User() {
	}

	public User(String firstName, String lastName, Integer age, String email, String password, String passwordConfirm,
			UserRole role, List<Certificate> certificates, Faculty faculties) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.role = role;
		this.certificates = certificates;
		this.faculties = faculties;
	}

	public User(Integer id, String firstName, String lastName, Integer age, String email, String password,
			String passwordConfirm, UserRole role, List<Certificate> certificates, Faculty faculties) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.role = role;
		this.certificates = certificates;
		this.faculties = faculties;
	}

	public User(User user) {
		this.id = user.id;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.age = user.age;
		this.email = user.email;
		this.password = user.password;
		this.passwordConfirm = user.passwordConfirm;
		this.role = user.role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getEncodedImage() {
		return encodedImage;
	}

	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public Faculty getFaculties() {
		return faculties;
	}

	public void setFaculties(Faculty faculties) {
		this.faculties = faculties;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, certificates, email, faculties, firstName, id, lastName, password, passwordConfirm,
				role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(age, other.age) && Objects.equals(certificates, other.certificates)
				&& Objects.equals(email, other.email) && Objects.equals(faculties, other.faculties)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(passwordConfirm, other.passwordConfirm) && role == other.role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", email="
				+ email + ", password=" + password + ", passwordConfirm=" + passwordConfirm + ", role=" + role
				+ ", certificates=" + certificates + ", faculties=" + faculties + "]";
	}

}