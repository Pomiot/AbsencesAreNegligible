package pl.edu.amu.rest.dto;

import java.util.Date;
import java.util.Set;

/**
 * Created by Tomasz on 23.01.2016.
 */
public class Tournament {

    private Long id;

    private Date startDate;

    private String tournamentName;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
}
