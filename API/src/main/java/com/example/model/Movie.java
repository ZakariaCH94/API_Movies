package com.example.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idMovie")
	private Long id;
	@Column(name="titleMovie")
	private String title;
	@Column(name="languageMovie")
	private String language;
	@Column(name="recordedYearMovie")
	private Integer recordedYear;
	@Column(name="linkImageMovie")
	private String image;
	@Column(name="lastNameHero")
	private String lastName;
	@Column(name="firstNameHero")
	private String firstName;
	@Column(name="descriptionMovie")
	private String description;
	@Column(name="selectedMovie")
	private boolean selected;
	
	@ManyToOne
    @JoinColumn(name = "idCategory")
	private Category category;

	
	
}
