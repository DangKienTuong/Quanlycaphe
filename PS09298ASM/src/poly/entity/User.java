package poly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = " Users")
public class User {
	@Id
	@Column(name = "Username")
	@NotBlank(message = "Không được để trống username !")
	private String username;
	@Column(name = "Password")
	@NotBlank(message = "Không được để trống pass !")
	private String password;
	@Column(name = "Fullname")
	private String fullname;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}
