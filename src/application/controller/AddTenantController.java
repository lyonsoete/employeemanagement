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

public class AddTenantController {

	@FXML
	TextField tenantName = new TextField();

	@FXML
	TextField tenantSurname = new TextField();

	@FXML
	TextField tenantEmail = new TextField();

	@FXML
	Button addTenantBtn = new Button();

	@FXML
	public void addTenant() {
		ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_tenantView());
	}

	@FXML
	public void cancel() {
		ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_tenantView());
	}

}
