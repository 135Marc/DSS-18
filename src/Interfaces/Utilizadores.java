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

    public Map<String,Utilizador> getUserMap() {
        return this.usermap;
    }

    public void addToMap(String id,Utilizador u) {
        this.usermap.put(id,u);
    }

    public Utilizador getUser(String id) {
        return this.usermap.get(id);
    }
}
