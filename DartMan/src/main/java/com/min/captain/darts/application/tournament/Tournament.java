package com.min.captain.darts.application.tournament;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.min.captain.darts.application.match.Match;

@Entity
@Table(name="tournament")
public class Tournament implements Serializable {

	private static final long serialVersionUID = -3081985864993767425L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="tournament_name")
	private String tournamentName;
	
	@OneToMany(mappedBy="tournament")
	private Set<Match> matches;

	public Tournament() {
		this.startDate = new Date(System.currentTimeMillis());
	}
	
	public Tournament(String name) {
		this.startDate = new Date(System.currentTimeMillis());
		this.tournamentName = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public Set<Match> getMatches() {
		return matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
}
