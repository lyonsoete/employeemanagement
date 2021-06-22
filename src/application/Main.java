package application;

import application.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("Immobilien- und Mieterverwaltung der HausBau GbR");
    ViewManager.getInstance().setStage(primaryStage);
    ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_loginView());
  }


  public static void main(String[] args) {
    launch(args);
  }
}
