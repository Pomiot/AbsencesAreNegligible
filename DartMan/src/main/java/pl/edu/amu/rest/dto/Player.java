package pl.edu.amu.rest.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class Player {

    @NotBlank @NotNull
    private String login;

    @NotBlank
    private String name;

    private String email;

    public Player(){
        //
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
}
