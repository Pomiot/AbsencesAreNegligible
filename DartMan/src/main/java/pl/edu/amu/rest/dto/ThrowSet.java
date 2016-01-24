package pl.edu.amu.rest.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="throwset")
public class ThrowSet implements Serializable {

    private static final long serialVersionUID = 4542432973465644245L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="player_id")
    private Long playerId;

    @Column(name="match_id")
    private Long matchId;

    @Column(name="round")
    private Integer round;

    @Column(name="first_throw")
    private Integer firstThrow;

    @Column(name="second_throw")
    private Integer secondThrow;

    @Column(name="third_throw")
    private Integer thirdThrow;

    public ThrowSet()
    {
        ;
    }

    public ThrowSet(Long playerId, Long matchId, Integer round, Integer first, Integer second, Integer third)
    {
        this.playerId = playerId;
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

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }


    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }
}
