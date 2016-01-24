package pl.edu.amu.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="match")
@ApiModel(value = "Match", description = "Object describing match id and metadata.")
public class Match implements Serializable {

    private static final long serialVersionUID = -6377435247877594960L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Auto-generated", required = true)
    private Long id;

    @Column(name="start_date")
    @ApiModelProperty(value = "Match creation date. Auto-generated", required = true)
    private Date startDate;

    @Column(name="tournament_name")
    @ApiModelProperty(value = "Tournament that match belongs to", required = false)
    private String tournamentName;

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

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

}
