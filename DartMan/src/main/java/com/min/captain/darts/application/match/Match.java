package com.min.captain.darts.application.match;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.min.captain.darts.application.throwSet.ThrowSet;
import com.min.captain.darts.application.tournament.Tournament;

@Entity
@Table(name="match")
public class Match implements Serializable
{
	private static final long serialVersionUID = -4302364823675375178L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="start_date")
	private Date startDate;
	
	@OneToMany(mappedBy="match")
	private List<ThrowSet> throwSets;
	
	@ManyToOne
	@JoinColumn(name="tournament_id")
	private Tournament tournament;
	
	public Match() {
		setStartDate(new Date(System.currentTimeMillis()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ThrowSet> getThrowSets() {
		return throwSets;
	}

	public void setThrowSets(List<ThrowSet> throwSets) {
		this.throwSets = throwSets;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

}
