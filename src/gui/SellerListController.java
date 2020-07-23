package gui;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import entities.Seller;
import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.service.SellerService;

public class SellerListController implements Initializable {

	private SellerService sellerservice;
		
	@FXML
	private Label lbtitulo;
	
	@FXML
	private Button btnNew;
	
	@FXML
	private TableView<Seller> tableViewSeller;
	
	@FXML
	private TableColumn<Seller, Integer> tcid;
	
	@FXML
	private TableColumn<Seller, String> tcname;
	
	@FXML
	private TableColumn<Seller, String> tcemail;
	
	@FXML
	private TableColumn<Seller, Date> tcbirthdate;

	@FXML
	private TableColumn<Seller, Double> tcbasesalary;
	
	@FXML
	private TableColumn<Seller, Integer> tcdepartmentid;
	
	@FXML
	private ObservableList<Seller> obsseller;
	
	public void setSellerService(SellerService service) {
		this.sellerservice=service;
	}
	
	public void updateList() {
		if(sellerservice==null) {
			Alerts.showAlerts("Service Null", "There isnt a Service Instance", "Please, instante a service", AlertType.ERROR);
		}else {
				List<Seller> list = sellerservice.findAll();
				obsseller = FXCollections.observableArrayList(list);
				tableViewSeller.setItems(obsseller);

		}
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializableNodes();

		
	}
	private void initializableNodes() {
		tcid.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tcname.setCellValueFactory(new PropertyValueFactory<>("Name"));
		tcemail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		tcbirthdate.setCellValueFactory(new PropertyValueFactory<>("BirthDate"));
		tcbasesalary.setCellValueFactory(new PropertyValueFactory<>("BaseSalary"));
		tcdepartmentid.setCellValueFactory(new PropertyValueFactory<>("Department Id"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewSeller.prefHeightProperty().bind(stage.heightProperty());
		
	}

}
