package Interfaces;

import java.util.HashMap;
import java.util.Map;

public class Utilizadores {
    private Map<String,Utilizador> usermap;

    public Utilizadores() {
        this.usermap = new HashMap<>();
        Utilizador u = new Utilizador("Grande","gigante");
        Utilizador u1 = new Utilizador("Teste", "teste");
        usermap.put(u.getUsername(),u);
        usermap.put(u1.getUsername(),u1);
    }

    public boolean hasUser(String id) {
        return (this.usermap.containsKey(id));
    }


    public boolean passwordMatches(String id,String password) {
        Utilizador u = this.usermap.get(id);
        return (u.getPassword().equals(password));
    }

    public void addUser(String id, String password) {
            Utilizador u = new Utilizador(id,password);
            this.usermap.put(id,u);
    }
}
