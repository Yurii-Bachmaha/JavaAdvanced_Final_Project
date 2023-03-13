package project.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="faculties")
public class Faculty {

	@Id
	@Column(name="faculty_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column(name = "number_of_students")
	private Integer numberOfStudents;

	@OneToMany(mappedBy = "faculty")
	private Set<ApplicationForm> applicationForms = new HashSet<>();

	public Faculty() {
	}

	public Faculty(String name, Integer numberOfStudents, Set<ApplicationForm> applicationForms) {
		this.name = name;
		this.numberOfStudents = numberOfStudents;
		this.applicationForms = applicationForms;
	}

	public Faculty(Integer id, String name, Integer numberOfStudents, Set<ApplicationForm> applicationForms) {
		this.id = id;
		this.name = name;
		this.numberOfStudents = numberOfStudents;
		this.applicationForms = applicationForms;
	}

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

	public Integer getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(Integer numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public Set<ApplicationForm> getApplicationForms() {
		return applicationForms;
	}

	public void setApplicationForms(Set<ApplicationForm> applicationForms) {
		this.applicationForms = applicationForms;
	}

	@Override
	public int hashCode() {
		return Objects.hash(applicationForms, id, name, numberOfStudents);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return Objects.equals(applicationForms, other.applicationForms) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(numberOfStudents, other.numberOfStudents);
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", numberOfStudents=" + numberOfStudents + ", applicationForms="
				+ applicationForms + "]";
	}

}