package com.min.captain.darts.application.match;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.min.captain.darts.application.throwSet.ThrowSet;

public class Match implements Serializable
{
	private static final long serialVersionUID = -4302364823675375178L;

	private Long id;
	
	private List<ThrowSet> round1;
	
	private List<ThrowSet> round2;
	
	private List<ThrowSet> round3;
	
	public Match()
	{
		this.setRound1(new ArrayList<>());
		this.setRound2(new ArrayList<>());
		this.setRound3(new ArrayList<>());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ThrowSet> getRound1() {
		return round1;
	}

	public void setRound1(List<ThrowSet> round1) {
		this.round1 = round1;
	}

	public List<ThrowSet> getRound2() {
		return round2;
	}

	public void setRound2(List<ThrowSet> round2) {
		this.round2 = round2;
	}

	public List<ThrowSet> getRound3() {
		return round3;
	}

	public void setRound3(List<ThrowSet> round3) {
		this.round3 = round3;
	}
}
