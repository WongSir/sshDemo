package com.hellospring.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;

//import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.hellospring.view.CarInfoView;


@Entity
@Table(name="car")
public class Car implements Serializable {
	private static final long serialVersionUID = 2L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	@JsonView(CarInfoView.CarView.class)
	private Integer id;
	
	
	@Column(name="name")
	@JsonView(CarInfoView.CarView.class)
	private String name;
	
	
	@Column(name="color")
	@JsonView(CarInfoView.CarView.class)
	private String color;
		
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="ownerid")
	private User usr;
	
	@JsonView(CarInfoView.CarAllView.class)
	@OneToMany(mappedBy="car", fetch=FetchType.LAZY)
	private Set<Track> tracks;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}


	public User getUsr() {
		return usr;
	}

	public void setUsr(User usr) {
		this.usr = usr;
	}

	public Set<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	
}
