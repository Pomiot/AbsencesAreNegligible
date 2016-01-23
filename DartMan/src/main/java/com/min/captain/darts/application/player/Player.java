package com.min.captain.darts.application.player;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.min.captain.darts.application.throwSet.ThrowSet;

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
	
	@OneToMany(mappedBy="player")
	private Set<ThrowSet> playerThrows;
	
	public Player() { }
	
	public Player(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ThrowSet> getPlayerThrows() {
		return playerThrows;
	}

	public void setPlayerThrows(Set<ThrowSet> playerThrows) {
		this.playerThrows = playerThrows;
	}
}
