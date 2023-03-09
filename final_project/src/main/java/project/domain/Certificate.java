package project.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Certificate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_fk_id", nullable = false)
	private User user;

	@Enumerated(EnumType.STRING)
	private Subject subject;

	public Certificate() {
	}

	public Certificate(User user, Subject subject) {
		this.user = user;
		this.subject = subject;
	}

	public Certificate(Integer id, User user, Subject subject) {
		this.id = id;
		this.user = user;
		this.subject = subject;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, subject, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Certificate other = (Certificate) obj;
		return Objects.equals(id, other.id) && subject == other.subject && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", user=" + user + ", subject=" + subject + "]";
	}

}