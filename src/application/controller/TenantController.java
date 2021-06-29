package application.controller;

import application.entity.Tenant;
import application.service.TenantService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import application.view.ViewManager;

import java.net.URL;
import java.util.ResourceBundle;

public class TenantController implements Initializable {

  @FXML
  Button dashboardBtn = new Button();
  @FXML
  Button newTenant = new Button();

  private final TenantService tenantService = new TenantService();

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }


  @FXML
  public void dashboard() {
    ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_dashboardView());
  }
  @FXML
  public void createTenant(){
    tenantService.createUser(new Tenant("Herr", "Lyon", "Söte", "LyonSoete"));
    ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_addTenantView());
  }

}
