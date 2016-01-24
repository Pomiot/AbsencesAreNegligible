package pl.edu.amu.rest.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@ApiModel("ThrowSet")
@Table(name="throwset")
public class ThrowSet implements Serializable {

    private static final long serialVersionUID = 4542432973465644245L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Auto-generated", required = true)
    private Long id;

    @Column(name="player")
    @ApiModelProperty(value = "Player that throws belong to", required = true)
    @NotNull
    private String player;

    @Column(name="match_id")
    @ApiModelProperty(value = "Match that throws belong to", required = true)
    private Long matchId;

    @Column(name="round")
    @ApiModelProperty(value = "Round in match that throws belong to", required = true)
    private Integer round;

    @Column(name="first_throw")
    @ApiModelProperty(value = "Point value of fist throw", required = true)
    private Integer firstThrow;

    @Column(name="second_throw")
    @ApiModelProperty(value = "Point value of second throw", required = true)
    private Integer secondThrow;

    @Column(name="third_throw")
    @ApiModelProperty(value = "Point value of third throw", required = true)
    private Integer thirdThrow;

    public ThrowSet()
    {
        ;
    }

    public ThrowSet(String player, Long matchId, Integer round, Integer first, Integer second, Integer third)
    {
        this.player = player;
        this.matchId = matchId;
        this.round = round;
        this.firstThrow = first;
        this.secondThrow = second;
        this.thirdThrow = third;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getFirstThrow() {
        return firstThrow;
    }

    public void setFirstThrow(Integer firstThrow) {
        this.firstThrow = firstThrow;
    }

    public Integer getSecondThrow() {
        return secondThrow;
    }

    public void setSecondThrow(Integer secondThrow) {
        this.secondThrow = secondThrow;
    }

    public Integer getThirdThrow() {
        return thirdThrow;
    }

    public void setThirdThrow(Integer thirdThrow) {
        this.thirdThrow = thirdThrow;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
}
