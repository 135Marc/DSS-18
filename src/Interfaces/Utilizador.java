package Interfaces;

import javafx.beans.property.SimpleStringProperty;

public class Utilizador {
    private SimpleStringProperty username;
    private SimpleStringProperty password;

    public Utilizador() {
        this.username=this.password=null;
    }

    public Utilizador(String username, String password) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    public Utilizador (Utilizador u) {
        this.username.set(u.getUsername());
        this.password.set(u.getPassword());
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

}
