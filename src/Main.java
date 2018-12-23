import DetalhesExteriores.DetalheExterior;
import Items.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Main {

    public static void main (String [] args){
        Jante a = new Jante();
        a.setTipo("Liga Leve");
        a.setPreco(2);
        a.setEspessura(15);
        System.out.println(a);
    }
}
