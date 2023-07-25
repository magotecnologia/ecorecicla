package edu.unal.todosalau.ecorecicla.ui.state;

public class LoginState {
    private String username;
    private String password;
    private Boolean isLogged;
    private String error;

    public LoginState(String username, String password, Boolean isLogged, String error) {
        this.username = username;
        this.password = password;
        this.isLogged = isLogged;
        this.error = error;
    }

    public LoginState() {
        this.username="";
        this.password = "";
        this.isLogged = false;
        this.error = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLogged() {
        return isLogged;
    }

    public void setLogged(Boolean logged) {
        isLogged = logged;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
