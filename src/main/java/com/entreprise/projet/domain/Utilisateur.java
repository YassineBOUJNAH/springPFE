package com.entreprise.projet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

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
    private String city;
    private String country;
    private String codepostale;


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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCodepostale() {
		return codepostale;
	}

	public void setCodepostale(String codepostale) {
		this.codepostale = codepostale;
	}

	public Utilisateur() {
    }
    
  public Utilisateur(Long id, String username, String password, String role, String email, String frstname,
			String lastname, String address, String city, String country, String codepostale) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.frstname = frstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.codepostale = codepostale;
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