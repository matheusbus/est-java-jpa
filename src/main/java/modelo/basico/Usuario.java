package modelo.basico;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbusuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usucode")
	private Long id;
	
	@Column(name = "usuname", nullable = false, unique = true)
	private String username;
	
	@Column(name = "usumail", nullable = false, unique = true)
	private String email;
	
	@Column(name = "usupswd", nullable = false, unique = false)
	private String password;
	
	public Usuario() {
		
	}
	
	public Usuario(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
	
	public String toString() {
		return new StringBuilder()
				.append("Id: "+this.id+"\n")
				.append("Username: "+this.username+"\n")
				.append("Email: "+this.email+"\n")
				.append("Password: "+this.password).toString();
	}
}
