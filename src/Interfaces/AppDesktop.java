package Interfaces;

import java.util.*;

public class AppDesktop {

    private Hashtable<String,String> userIdPass;
    private Set<Utilizador> users;
    private Fabrica fabrica;

    public AppDesktop() {
        this.userIdPass = new Hashtable<>();
        this.users = new HashSet<>();
        this.fabrica = new Fabrica();
    }

    public void registaUser(Utilizador a){
        userIdPass.putIfAbsent(a.getUsername(),a.getPassword());
        users.add(a);
    }

    public boolean userExiste(String id){
       return this.userIdPass.containsKey(id);
    }

    public Utilizador getUser(String id){
        for(Utilizador a : users){
            if(a.getUsername().equals(id)){
                return a;
            }
        }
        return  null;
    }

    public boolean passwoordMatch(String id,String pass){

        return userIdPass.get(id).equals(pass);
    }

    public Fabrica getFabrica(){
        return this.fabrica;
    }
}
