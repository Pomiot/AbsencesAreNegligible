package pl.edu.amu.rest.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="player")
@ApiModel(value = "Player", description = "Player model. Not very surprising, isn't it?")
public class Player implements Serializable {

	private static final long serialVersionUID = -6484849192253524069L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Auto-generated", required = true)
	private Long id;

    @ApiModelProperty(value = "Unique player identifier", required = true)
	@NotBlank @NotNull
	@Column(name="login")
    private String login;

    @ApiModelProperty(value = "Player name", required = false)
    @Column(name="name")
    private String name;

    @ApiModelProperty(value = "Self-explanatory", required = false)
    @Column(name="email")
    private String email;

    public Player(){
        //
    }
    
    public Player(String login, String name, String email) {
    	this.login = login;
    	this.name = name;
    	this.email = email;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                '}';
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
