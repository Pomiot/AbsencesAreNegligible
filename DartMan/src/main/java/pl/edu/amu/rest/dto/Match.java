package pl.edu.amu.rest.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz on 23.01.2016.
 */
public class Match {

    private Long id;

    private Date startDate;

    private List<ThrowSet> throwSets;

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
