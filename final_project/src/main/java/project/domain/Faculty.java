package project.domain;

import java.util.Objects;

public class Faculty {

	private Integer faculty_id;
	private String name;
	private Integer numberOfStudents;

	public Faculty() {
	}

	public Faculty(String name, Integer numberOfStudents) {
		super();
		this.name = name;
		this.numberOfStudents = numberOfStudents;
	}

	public Faculty(Integer faculty_id, String name, Integer numberOfStudents) {
		this.faculty_id = faculty_id;
		this.name = name;
		this.numberOfStudents = numberOfStudents;
	}

	public Integer getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(Integer faculty_id) {
		this.faculty_id = faculty_id;
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

	@Override
	public int hashCode() {
		return Objects.hash(faculty_id, name, numberOfStudents);
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
		return Objects.equals(faculty_id, other.faculty_id) && Objects.equals(name, other.name)
				&& Objects.equals(numberOfStudents, other.numberOfStudents);
	}

	@Override
	public String toString() {
		return "Faculty [faculty_id=" + faculty_id + ", name=" + name + ", numberOfStudents=" + numberOfStudents + "]";
	}

}