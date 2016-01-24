package pl.edu.amu.rest.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="match")
public class Match implements Serializable {

	private static final long serialVersionUID = -6377435247877594960L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name="start_date")
    private Date startDate;

	@OneToMany(mappedBy="match")
    private Set<ThrowSet> throwSets;

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

	public Set<ThrowSet> getThrowSets() {
		return throwSets;
	}

	public void setThrowSets(Set<ThrowSet> throwSets) {
		this.throwSets = throwSets;
	}
}
