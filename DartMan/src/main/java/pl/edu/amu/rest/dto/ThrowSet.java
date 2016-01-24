package pl.edu.amu.rest.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="throwset")
public class ThrowSet implements Serializable {

	private static final long serialVersionUID = 4542432973465644245L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
    @JoinColumn(name="player_id")
    private Player player;
    
	@ManyToOne
    @JoinColumn(name="match_id")
    private Match match;

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
    
    public ThrowSet(Player player, Match match, Integer round, Integer first, Integer second, Integer third)
    {
    	this.player = player;
    	this.match = match;
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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}


}
