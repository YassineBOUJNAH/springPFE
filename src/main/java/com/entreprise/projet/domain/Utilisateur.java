package com.entreprise.projet.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Utilisateur implements Serializable {

private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id ;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;
    
    private String email;
    private String frstname;
    private String lastname;
    private String address;
    private String phone;
	private String sexe;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFrstname() {
		return frstname;
	}

	public void setFrstname(String frstname) {
		this.frstname = frstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public Utilisateur() {
    }

	public Utilisateur(Long id, String username, String password, String role, String email, String frstname, String lastname, String address, String phone, String sexe) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.frstname = frstname;
		this.lastname = lastname;
		this.address = address;
		this.phone = phone;
		this.sexe = sexe;
	}

	public Utilisateur(String username, String password, String role) {
    super();
    this.username = username;
    this.password = password;
    this.role = role;
  }
  
  public Long getId() {
	    return id;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

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

	  public String getRole() {
	    return role;
	  }

	  public void setRole(String role) {
	    this.role = role;
	  }
	}