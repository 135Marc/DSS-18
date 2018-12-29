package Interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Carros {

    private HashMap<String, List<Configuracao>> listaConfigCliente;


    public Carros(){
        this.listaConfigCliente = new HashMap<>();
    }

    public void adicionaConfig(String id,Configuracao cfg){

        List<Configuracao> lista = new ArrayList<>();
        if(listaConfigCliente.get(id) != null) {
            lista = listaConfigCliente.get(id);
        }
        lista.add(cfg);
        this.listaConfigCliente.put(id,lista);
    }

    public boolean noConfig(String id){
        return listaConfigCliente.get(id).isEmpty();
    }

    public void removeConfig(String id,Configuracao a){
        List<Configuracao> lista = listaConfigCliente.get(id);

        lista.remove(a);

        listaConfigCliente.put(id,lista);
    }

    public List<Configuracao> getAllConfigs(String id){

        return this.listaConfigCliente.get(id);
    }

    public Configuracao getConfig(String id,String nome){

        for(Configuracao a : listaConfigCliente.get(id)){
            if(a.getNome().equals(nome)){
                return a;
            }
        }
        return null;
    }


}
