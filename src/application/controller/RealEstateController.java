package application.controller;

import application.Enums.ObjectTypes;
import application.entity.Address;
import application.entity.RealEstate;
import application.service.RealEstateService;
import application.view.ViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class RealEstateController implements Initializable {

	private final String ERROR_PLZ = "Bitte geben Sie eine gültige Postleitzahl ein.";
	private final String ERROR_SQUARE_METERS = "Bitte geben Sie die Größe der Immobilie in Quadratmetern an.";
	private final String ERROR_SQUARE_METER_PRIZE_COLD = "Bitte geben Sie die Kaltmiete pro Quadratmeter an..";
	private final String ERROR_ADDITIONAL_COSTS = "Bitte geben Sie die Nebenkosten ein.";
	private final String ERROR_ALL = "Bitte geben füllen Sie zuerst alle Eingabefleder aus.";

	private final String PRIVATE = "privat";
	private final String COMMERCIAL = "gewerblich";
	private final String FLAT = "Wohnung";

	@FXML
	private final RealEstateService realEstateService = new RealEstateService();
	@FXML
	public TextField id = new TextField();
	@FXML
	public TextField objectNumber = new TextField();
	@FXML
	public ChoiceBox<String> objectType = new ChoiceBox<>();
	@FXML
	public ChoiceBox<String> objectDescription = new ChoiceBox<>();
	@FXML
	public TextField street = new TextField();
	@FXML
	public TextField number = new TextField();
	@FXML
	public TextField plz = new TextField();
	@FXML
	public TextField location = new TextField();
	@FXML
	public TextField squareMeters = new TextField();
	@FXML
	public TextField squareMeterPriceCold = new TextField();
	@FXML
	public TextField additionalCosts = new TextField();
	@FXML
	public TextArea notes = new TextArea();
	@FXML
	public ListView<RealEstate> realEstateList = new ListView<>();
	@FXML
	public Button saveBtn = new Button();
	@FXML
	public Button cancelBtn = new Button();
	@FXML
	public Button deleteBtn = new Button();
	@FXML
	public Button dashboardBtn = new Button();
	@FXML
	public Label errorText = new Label();
	@FXML
	public TextField additionalCostsPerSquareMeter = new TextField();
	@FXML
	public TextField squareMeterPriceWarm = new TextField();
	@FXML
	public TextField priceCold = new TextField();
	@FXML
	public TextField priceWarm = new TextField();

	public ObservableList<RealEstate> realEstatesObs = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		objectType.getItems().add(PRIVATE);
		objectType.getItems().add(COMMERCIAL);

		objectDescription.getItems().add(FLAT);
		objectDescription.getItems().add("Ladenlokal");
		objectDescription.getItems().add("Stellplatz");
		objectDescription.getItems().add("Garagenstellplatz");
		objectDescription.getItems().add("Tiefgaragenstellplatz");

		this.getList();
		this.clear();
	}

	public void realEstateClicked() {
		RealEstate realEstate = realEstateList.getSelectionModel().getSelectedItem();
		id.setText(String.valueOf(realEstate.getId()));
		objectNumber.setText(realEstate.getObjectNumber());
		objectType.setValue(realEstate.getObjectType().toString().equals("PRIVATE") ? PRIVATE : COMMERCIAL);
		objectDescription.setValue(realEstate.getObjectDescription());
		street.setText(realEstate.getAddress().getStreetName());
		number.setText(realEstate.getAddress().getNumber());
		plz.setText(String.valueOf(realEstate.getAddress().getPlz()));
		location.setText(realEstate.getAddress().getLocation());
		squareMeters.setText(String.valueOf(realEstate.getSquareMeters()));
		squareMeterPriceCold.setText(String.valueOf(realEstate.getSquareMeterPriceCold()));
		additionalCosts.setText(String.valueOf(realEstate.getAdditionalCosts()));
		notes.setText(realEstate.getNotes());
		saveBtn.setText("Aktualisieren");
		deleteBtn.setDisable(false);
	}

	@FXML
	public void save() {
		if (isValid()) {
			realEstateService.saveOrUpdate(new RealEstate("".equals(id.getText()) ? 0 : Integer.parseInt(id.getText()), objectNumber.getText(), "privat".equals(objectType.getValue()) ? ObjectTypes.PRIVATE : ObjectTypes.COMMERCIAL, objectDescription.getValue(), new Address(street.getText(), number.getText(), Integer.parseInt(plz.getText()), location.getText()), Double.parseDouble(squareMeters.getText()), Double.parseDouble(squareMeterPriceCold.getText()), Double.parseDouble(additionalCosts.getText()), notes.getText()));
			this.getList();
			this.clear();
		}
	}

	@FXML
	public void clear() {
		id.clear();
		objectNumber.clear();
		objectType.setValue(PRIVATE);
		objectDescription.setValue(FLAT);
		street.clear();
		number.clear();
		plz.clear();
		location.clear();
		squareMeters.clear();
		squareMeterPriceCold.clear();
		additionalCosts.clear();
		notes.clear();
		errorText.setText("");
		saveBtn.setText("Speichern");
		deleteBtn.setDisable(true);
	}

	@FXML
	public void delete() {
		realEstateService.delete(realEstateList.getSelectionModel().getSelectedItem());
		getList();
		clear();
	}

	@FXML
	public void dashboard() {
		ViewManager.getInstance().activateScene(ViewManager.getInstance().getScene_dashboardView());
	}

	private void getList() {
		this.realEstatesObs = realEstateService.getList();
		realEstateList.setItems(realEstatesObs);
	}

	private boolean isValid() {
		try {
			Integer.parseInt(plz.getText());
		} catch (Exception e) {
			errorText.setText(ERROR_PLZ);
			return false;
		}
		try {
			Double.parseDouble(squareMeters.getText());
		} catch (Exception e) {
			errorText.setText(ERROR_SQUARE_METERS);
			return false;
		}
		try {
			Double.parseDouble(squareMeterPriceCold.getText());
		} catch (Exception e) {
			errorText.setText(ERROR_SQUARE_METER_PRIZE_COLD);
			return false;
		}
		try {
			Double.parseDouble(additionalCosts.getText());
		} catch (Exception e) {
			errorText.setText(ERROR_ADDITIONAL_COSTS);
			return false;
		}
		if ("".equals(objectNumber.getText()) || objectType.getValue() == null || objectDescription.getValue() == null || "".equals(street.getText()) || "".equals(number.getText()) || "".equals(location.getText())) {
			errorText.setText(ERROR_ALL);
			return false;
		}
		return true;
	}
}
