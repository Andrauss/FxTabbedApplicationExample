/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fandrauss;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author andrauss
 */
public class MainController implements Initializable {

    @FXML
    private TabPane tabPaneRoot;

    @FXML
    void addTabType1(ActionEvent event) {
        addTab("/br/com/fandrauss/tabtype1.fxml");
    }

    @FXML
    void addTabType2(ActionEvent event) {
        addTab("/br/com/fandrauss/tabtype2.fxml");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabPaneRoot.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
    }

    /**
     * Método para adicionar as Abas
     * @param fxmlPath 
     */
    private void addTab(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Region root = loader.load(); // Carrega o painel principal do FXML
            TabContent tabContent = loader.getController(); // Obtém a instância do Controller
            tabContent.setRoot(root); // Passo o painel root para o controller

            // Criando a Aba
            Tab tab = new Tab(
                    tabContent.tabTitle(), // Obtendo o titulo a partir do controller
                    tabContent.getRoot()); // Obtendo o conteúdo da aba a partir do controller
            
            tab.setClosable(true); // Define que a aba pode ser fechada
            
            // Definindo a ação do botão fechar da aba
            tab.setOnCloseRequest((evt) -> {
                evt.consume(); // Cancela o evento de fechamento
                tabContent.onCloseRequest(); // Delega o evento de fechamento ao controller
            });
                
            // Passando a instância da aba para o controller
            tabContent.setTab(tab);
            
            // Adicionando a aba ao painel
            tabPaneRoot.getTabs().add(tab);
            tabPaneRoot.getSelectionModel().select(tab);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
