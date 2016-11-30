package com.hellospring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonView;
import com.hellospring.view.UserInfoView;

@Entity
@Table(name="user")
//@Scope("session")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")	
	@JsonView(UserInfoView.OnlyUserInfoView.class)
	private Integer id;
	
	@Column(name="name")
	@JsonView(UserInfoView.OnlyUserInfoView.class)
	private String name;
	
	@Column(name="groups")
	@Enumerated(value=EnumType.ORDINAL)
	@JsonView(UserInfoView.OnlyUserInfoView.class)
	private GroupType grpType;
	
	@JsonView(UserInfoView.AllUserInfoView.class)
	@OneToMany(mappedBy="usr", fetch=FetchType.LAZY)
	private Set<Car> cars;
	
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

	
	public GroupType getGrpType() {
		return grpType;
	}
	
	public void setGrpType(GroupType grpType) {
		this.grpType = grpType;
	}
	
	public Set<Car> getCars() {
		return cars;
	}
	
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

}
