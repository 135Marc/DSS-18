package Interfaces;

import java.util.Map;

public class MainController {
    private Utilizadores usersmap;

    public MainController() {
        this.usersmap = new Utilizadores();
    }

    public boolean hasUser(String id) {
        Map<String,Utilizador> umap = usersmap.getUserMap();
        return (umap.containsKey(id));
    }

    public boolean passwordMatches(String id,String password) {
        Utilizador u = usersmap.getUserMap().get(id);
        return (u.getPassword().equals(password));
    }

    public void addUser(String id, String password) {
        Utilizador u = new Utilizador(id,password);
        this.usersmap.addToMap(id,u);
    }

}
