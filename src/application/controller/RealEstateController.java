package application.controller;

import application.service.RealEstateService;
import application.view.ViewManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class RealEstateController implements Initializable {

  @FXML
  public Button dashboardBtn = new Button();
  @FXML
  public Button newRealEstate = new Button();

  private final RealEstateService realEstateService = new RealEstateService();

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }

  @FXML
  public void dashboard() {
    ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_dashboardView());
  }

  public void createRealEstate() {
    realEstateService.createRealEstate();
  }
}
