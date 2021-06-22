package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import application.view.ViewManager;

import java.net.URL;
import java.util.ResourceBundle;

public class TenantController implements Initializable {

  @FXML
  Button dashboardBtn = new Button();

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }


  @FXML
  public void dashboard() {
    ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_dashboardView());
  }
}
