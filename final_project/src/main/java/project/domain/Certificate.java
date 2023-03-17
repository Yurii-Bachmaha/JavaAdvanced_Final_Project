package project.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name="certificate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "user_fk_id", referencedColumnName = "user_id", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "evaluation_fk_id", referencedColumnName = "evaluation_id", nullable = false)
	private Evaluation evaluation;

	public Certificate() {
	}

	public Certificate(User user, Evaluation evaluation) {
		this.user = user;
		this.evaluation = evaluation;
	}

	public Certificate(Integer id, User user, Evaluation evaluation) {
		this.id = id;
		this.user = user;
		this.evaluation = evaluation;
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

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(evaluation, id, user);
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
		return Objects.equals(evaluation, other.evaluation) && Objects.equals(id, other.id)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", user=" + user + ", evaluation=" + evaluation + "]";
	}

}