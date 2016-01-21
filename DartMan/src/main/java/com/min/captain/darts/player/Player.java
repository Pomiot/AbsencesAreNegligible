package com.min.captain.darts.player;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player implements Serializable
{
	private static final long serialVersionUID = 446273158740577860L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	public Player()
	{
		;
	}
	
	public Player(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}
}
