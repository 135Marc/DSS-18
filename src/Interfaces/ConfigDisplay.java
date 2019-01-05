package Interfaces;

import DetalhesExteriores.DetalheExterior;
import DetalhesInteriores.DetalheInterior;
import Items.Item;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class ConfigDisplay  implements Initializable {
    @FXML
    private TableView<Object> cart;
    private MainController mc;
    private MainView main;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadTable() {
        TableColumn<Object,String> tc3 = new TableColumn<>("Tipo");
        TableColumn<Object,Float> tc4 = new TableColumn<>("Preço(€)");
        tc3.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("preco"));
        tc3.setPrefWidth(150);
        tc4.setPrefWidth(102);
        String nome = mc.getConfigNome();
        String id = mc.getId();
        Configuracao cfg = mc.getConfig(id,nome);
        cart.getColumns().addAll(tc3,tc4);
        cart.getItems().addAll(atualizaItens(cfg));
        cart.getItems().addAll(atualizaDetExte(cfg));
        cart.getItems().addAll(atualizaDetalhesInteriores(cfg));
    }

    public Set<Item> atualizaItens(Configuracao cfg) {
        return cfg.getItemlist();
    }

    public Set<DetalheExterior> atualizaDetExte(Configuracao cfg) {
        return cfg.getOuterdetails();
    }

    public Set<DetalheInterior> atualizaDetalhesInteriores (Configuracao cfg) {
        return cfg.getInnerdetails();
    }

    public void itemFrame() { //NULL POINTER
        this.mc.displayItemFrame();
    }

    public void innerFrame() {this.mc.displayInnerFrame();}

    public void outterFrame() {this.mc.displayOutterFrame();}

    public void turnBack( ) { //NULL POINTER
        this.mc.displayConfigManager();
    }

    public void setMainController(MainController mc) {
        this.mc = mc;
    }

    public void init(MainView mv) {
        this.main = mv;
    }

    public  void pacotes(){
        this.mc.displayPacoteFrame();
    }

    public void submeter(){
        this.mc.getFabrica().addConfig(mc.getConfig(mc.getId(),mc.getConfigNome()));
        mc.getConfig(mc.getId(),mc.getConfigNome()).setSubmetida();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Configuração Submetida");
        alert.setHeaderText("A sua configuração foi submetida com sucesso");
        alert.showAndWait();
        this.mc.displayConfigManager();
    }



    public void avisoPacote(String errormsg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Remoção não efetuada");
        alert.setHeaderText("Ocorreu o seguinte erro:");
        alert.setContentText(errormsg);
        alert.showAndWait();
    }

    public void removeSelecao() {
        Object o = cart.getSelectionModel().getSelectedItem();
        String nome = mc.getConfigNome();
        String id = mc.getId();
        Configuracao cfg = mc.getConfig(id,nome);

        if (o instanceof Item){
            if(((Item) o).getEPacote()) avisoPacote("Não pode remover itens de um pacote!");
            else
            cfg.removeItem((Item) o);
        }
        if (o instanceof DetalheInterior){
            if(((DetalheInterior) o).getEPacote()) avisoPacote("Não pode remover itens de um pacote!");
            else
            cfg.removeDetInt((DetalheInterior) o);
        }
        if (o instanceof DetalheExterior){
            if(((DetalheExterior) o).getEPacote()) avisoPacote("Não pode remover itens de um pacote!");
            else
            cfg.removeDetExt((DetalheExterior) o);
        }

        this.mc.displayConfigEditor();
    }

}
