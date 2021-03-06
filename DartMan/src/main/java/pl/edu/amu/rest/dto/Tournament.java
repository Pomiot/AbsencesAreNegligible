package pl.edu.amu.rest.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@ApiModel(value = "Tournament", description = "Tournament model")
@Table(name="tournament")
public class Tournament implements Serializable {

    private static final long serialVersionUID = 2357446534853404697L;

    @Id
    @ApiModelProperty(value = "Auto-generated", required = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="start_date")
    @ApiModelProperty(value = "Auto-generated", required = false)
    private Date startDate;
    
    @NotBlank
    @Column(name="tournament_name")
    @ApiModelProperty(value = "Tournament name", required = true)
    private String tournamentName;

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
}
