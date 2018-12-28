package Interfaces;

import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;
import java.util.Map;

public class Utilizador {
    private SimpleStringProperty username;
    private SimpleStringProperty password;
    private Map<String,Configuracao> userconfigmap;

    public Utilizador() {
        this.username=this.password=null;
    }

    public Utilizador(String username, String password) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.userconfigmap = new HashMap<>();
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

    public void addConfig(Configuracao cfg) {
        this.userconfigmap.put(cfg.getNome(),cfg);
    }

    public void removeConfig(Configuracao cfg) {
        this.userconfigmap.remove(cfg);
    }

    public Map<String,Configuracao> getUserConfigMap() {
        return this.userconfigmap;
    }

    public void setUserConfigMap(Map<String,Configuracao> mapz) {
        this.userconfigmap=mapz;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Utilizador : ")
                .append(this.getUsername())
                .append( " está logado");
        return sb.toString();
    }

}
