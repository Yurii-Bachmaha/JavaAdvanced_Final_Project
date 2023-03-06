package project.domain;

import java.util.Objects;

public class Certificate {

	private Integer certificate_id;
	private User user;
	private Subject subject;

	public Certificate() {
	}

	public Certificate(User user, Subject subject) {
		super();
		this.user = user;
		this.subject = subject;
	}

	public Certificate(Integer certificate_id, User user, Subject subject) {
		super();
		this.certificate_id = certificate_id;
		this.user = user;
		this.subject = subject;
	}

	public Integer getCertificate_id() {
		return certificate_id;
	}

	public void setCertificate_id(Integer certificate_id) {
		this.certificate_id = certificate_id;
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
		return Objects.hash(certificate_id, subject, user);
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
		return Objects.equals(certificate_id, other.certificate_id) && subject == other.subject
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Certificate [certificate_id=" + certificate_id + ", user=" + user + ", subject=" + subject + "]";
	}

}