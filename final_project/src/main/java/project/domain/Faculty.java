package project.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculties")
public class Faculty {

	@Id
	@Column(name = "faculty_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column(name = "number_of_students")
	private Integer numberOfStudents;

	@Column(name = "minimum_passing_score")
	private Integer minimumPassingScore;

	public Faculty() {
	}

	public Faculty(String name, Integer numberOfStudents, Integer minimumPassingScore) {
		this.name = name;
		this.numberOfStudents = numberOfStudents;
		this.minimumPassingScore = minimumPassingScore;
	}

	public Faculty(Integer id, String name, Integer numberOfStudents, Integer minimumPassingScore) {
		this.id = id;
		this.name = name;
		this.numberOfStudents = numberOfStudents;
		this.minimumPassingScore = minimumPassingScore;
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

	public Integer getMinimumPassingScore() {
		return minimumPassingScore;
	}

	public void setMinimumPassingScore(Integer minimumPassingScore) {
		this.minimumPassingScore = minimumPassingScore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, minimumPassingScore, name, numberOfStudents);
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
		return Objects.equals(id, other.id) && Objects.equals(minimumPassingScore, other.minimumPassingScore)
				&& Objects.equals(name, other.name) && Objects.equals(numberOfStudents, other.numberOfStudents);
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", numberOfStudents=" + numberOfStudents
				+ ", minimumPassingScore=" + minimumPassingScore + "]";
	}

}