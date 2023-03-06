package project.domain;

import java.util.Objects;

public class User {

	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private String email;
	private String password;
	private UserRole role;
	private Integer сertificateId;

	public User() {
	}

	public User(String firstName, String lastName, Integer age, String email, String password, UserRole role,
			Integer сertificateId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.password = password;
		this.role = role;
		this.сertificateId = сertificateId;
	}

	public User(Integer id, String firstName, String lastName, Integer age, String email, String password,
			UserRole role, Integer сertificateId) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.password = password;
		this.role = role;
		this.сertificateId = сertificateId;
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public Integer getСertificateId() {
		return сertificateId;
	}

	public void setСertificateId(Integer сertificateId) {
		this.сertificateId = сertificateId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, firstName, id, lastName, password, role, сertificateId);
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
		return Objects.equals(age, other.age) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& role == other.role && Objects.equals(сertificateId, other.сertificateId);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", email="
				+ email + ", password=" + password + ", role=" + role + ", сertificateId=" + сertificateId + "]";
	}

}