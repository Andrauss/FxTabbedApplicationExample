package br.com.fandrauss;

import javafx.scene.control.Tab;
import javafx.scene.layout.Region;

/**
 * Interface para definir o comportamento de um controller de abas
 * @author andrauss
 */
public interface TabContent {
    
    void setRoot(Region region);
    
    Region getRoot();
    
    String tabTitle();
    
    void setTab(Tab tab);
    
    void onCloseRequest();
    
}
