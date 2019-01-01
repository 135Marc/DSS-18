package Interfaces;

import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;
import java.util.Map;

public class Utilizador {
    private String username;
    private String password;
    private boolean isOn;

    public Utilizador() {
        this.username=this.password=null;
        this.isOn = false;
    }

    public Utilizador(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Utilizador (Utilizador u) {
        this.username= u.getUsername();
        this.password = u.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username =username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOn(){
        this.isOn = true;
    }

    public void setOff(){
        this.setOff();
    }

    public boolean getIsOn(){
        return this.isOn;
    }

}
