package project.domain;

import java.util.Objects;

public class ApplicationForm {

	private Integer id;
	private User user;
	private Faculty faculty;

	public ApplicationForm() {
	}

	public ApplicationForm(User user, Faculty faculty) {
		this.user = user;
		this.faculty = faculty;
	}

	public ApplicationForm(Integer id, User user, Faculty faculty) {
		super();
		this.id = id;
		this.user = user;
		this.faculty = faculty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public int hashCode() {
		return Objects.hash(faculty, id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationForm other = (ApplicationForm) obj;
		return Objects.equals(faculty, other.faculty) && Objects.equals(id, other.id)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "ApplicationForm [id=" + id + ", user=" + user + ", faculty=" + faculty + "]";
	}

}