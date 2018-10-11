/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fandrauss;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author andrauss
 */
public class TabType2Controller implements Initializable, TabContent {

    private Region root;
    private Tab tab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void setRoot(Region region) {
        this.root = region;
    }

    @Override
    public Region getRoot() {
        return root;
    }

    @Override
    public void setTab(Tab tab) {
        this.tab = tab;
    }

    @FXML
    private void closeTab() {
        tab.getTabPane().getTabs().remove(tab);
    }

    @Override
    public void onCloseRequest() {
        // Fechando a aba sem confirmação
       closeTab();
    }

    @Override
    public String tabTitle() {
        return "Tab type 2";
    }

}
