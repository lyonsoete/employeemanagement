package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import application.view.ViewManager;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

  @FXML
  Button logoutBtn = new Button();
  @FXML
  Button realEstateBtn = new Button();
  @FXML
  Button tenantBtn = new Button();
  @FXML
  Button additionalCostsBtn = new Button();
  @FXML
  Button documentsBtn = new Button();
  @FXML
  Button usersBtn = new Button();

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }

  @FXML
  public void quit() {

  }

  @FXML
  public void logout() {
    ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_loginView());
  }

  @FXML
  public void realEstate() {
    ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_realEstateView());
  }

  @FXML
  public void tenant() {
    ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_tenantView());
  }

  @FXML
  public void additionalCosts() {
    ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_additionalCostsView());
  }

  @FXML
  public void documents() {
    ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_documentsView());
  }

  public void users() {
    ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_usersView());
  }
}
