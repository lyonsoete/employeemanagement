package application.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Objects;

public class ViewManager {

  private static ViewManager viewmanager = null;

  private Scene scene_loginView = null;
  private Scene scene_dashboardView = null;
  private Scene scene_realEstateView = null;
  private Scene scene_tenantView = null;
  private Scene scene_additionalCostsView = null;
  private Scene scene_documentsView = null;
  private Scene scene_usersView = null;
  private Scene scene_addTenantView = null;
  private Scene scene_addRealEstateView = null;

  private Stage primarystage = null;

  private ViewManager() {
    try {
      Pane pane_loginView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginView.fxml")));
      Pane pane_dashboardView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboardView.fxml")));
      Pane pane_realEstateView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("realEstateView.fxml")));
      Pane pane_tenantView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tenantView.fxml")));
      Pane pane_additionalCostsView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("additionalCostsView.fxml")));
      Pane pane_documentsView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("documentsView.fxml")));
      Pane pane_usersView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("usersView.fxml")));
      Pane pane_addTenantView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addTenantView.fxml")));
      Pane pane_addRealEstateView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("addRealEstateView.fxml")));


      this.scene_loginView = new Scene(pane_loginView);
      this.scene_dashboardView = new Scene(pane_dashboardView);
      this.scene_realEstateView = new Scene(pane_realEstateView);
      this.scene_tenantView = new Scene(pane_tenantView);
      this.scene_additionalCostsView = new Scene(pane_additionalCostsView);
      this.scene_documentsView = new Scene(pane_documentsView);
      this.scene_usersView = new Scene(pane_usersView);
      this.scene_addTenantView = new Scene(pane_addTenantView);
      this.scene_addRealEstateView = new Scene(pane_addRealEstateView);


    } catch (Exception e) {
      Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
      alert.showAndWait();
    }
  }

  public static ViewManager getInstance() {
    if (ViewManager.viewmanager == null) {
      ViewManager.viewmanager = new ViewManager();
    }
    return ViewManager.viewmanager;
  }

  public void activateScene(Scene scene) {
    this.primarystage.setScene(scene);
    this.primarystage.show();
  }

  public void setStage(Stage primaryStage) {
    this.primarystage = primaryStage;
  }

  public void closeStage() {
    this.primarystage.close();
  }

  public Scene getScene_loginView() {
    return scene_loginView;
  }

  public Scene getScene_dashboardView() {
    return this.scene_dashboardView;
  }

  public Scene getScene_realEstateView() {
    return scene_realEstateView;
  }

  public Scene getScene_tenantView() {
    return scene_tenantView;
  }

  public Scene getScene_additionalCostsView() {
    return scene_additionalCostsView;
  }

  public Scene getScene_documentsView() {
    return scene_documentsView;
  }

  public Scene getScene_usersView() {
    return scene_usersView;
  }

  public Scene getScene_addTenantView() { return scene_addTenantView; }

  public Scene getScene_addRealEstateView() { return scene_addRealEstateView; }

}
