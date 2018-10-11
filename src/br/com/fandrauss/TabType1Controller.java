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
public class TabType1Controller implements Initializable, TabContent {

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
        // Adicionando confirmação na ação de fechamento da aba
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Deseja realmente fechar a aba?",
                ButtonType.YES, ButtonType.NO);
        
        alert.setTitle("Fechar");

        alert.showAndWait().ifPresent((b) -> {
            if (b.equals(ButtonType.YES)) {
                    closeTab();
            }
        });

    }

    @Override
    public String tabTitle() {
        return "Tab type 1";
    }

}
