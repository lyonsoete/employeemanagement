package application.controller;

import application.hibernate.HibernateManager;
import application.view.ViewManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

  @FXML
  TextField username = new TextField();
  @FXML
  PasswordField password = new PasswordField();
  @FXML
  Button LoginBtn = new Button();
  @FXML
  Button quitBtn = new Button();

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }

  @FXML
  public void login() {
    ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_dashboardView());
  }

  @FXML
  public void quit() {
    HibernateManager.shutdown();
    ViewManager.getInstance().closeStage();
  }
}
