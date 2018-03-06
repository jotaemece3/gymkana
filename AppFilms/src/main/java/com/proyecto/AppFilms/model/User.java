package com.proyecto.AppFilms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @author jmcaceres
 *
 *         Clase User que guarda a los usuarios.
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	@NotNull
	@NotBlank
	private String name;

	@Column(name = "surname")
	@NotNull
	@NotBlank
	private String surname;

	@Column
	@NotNull
	private Date birthDate;

	private String errorMessage;

	@OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
	private Set<Rating> rating = new HashSet<>();

	public Set<Rating> getRating() {
		return rating;
	}

	public void setRating(Set<Rating> rating) {
		this.rating = rating;
	}

	public User() {
	}

	public User(long id) {
		super();
		this.id = id;
	}

	public User(long id, String name, String surname, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
