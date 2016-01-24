package pl.edu.amu.rest.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="player")
public class Player implements Serializable {

	private static final long serialVersionUID = -6484849192253524069L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank @NotNull
	@Column(name="login")
    private String login;

    @NotBlank
    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @OneToMany(mappedBy="player")
	@Transient
	private Set<ThrowSet> playerThrows;
    
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

	public Set<ThrowSet> getPlayerThrows() {
		return playerThrows;
	}

	public void setPlayerThrows(Set<ThrowSet> playerThrows) {
		this.playerThrows = playerThrows;
	}
}
