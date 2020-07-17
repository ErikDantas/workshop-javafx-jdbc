package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.service.DepartmentService;

public class DepartmentListController implements Initializable{

	private DepartmentService service;
	
	@FXML
	private Button btnNewDepartment;
	
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tablecolumnId;
	
	@FXML
	private TableColumn<Department, String> tablecolumnname;
	
	@FXML
	private ObservableList<Department> obslist;
	
	@FXML
	public void onNewBtnDepartment() {
		System.out.println("Click");
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializableNodes();
		
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}


	private void initializableNodes() {
		tablecolumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tablecolumnname.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		
		
	}
	public void UpdateTableView() {
		if(service==null) {
			Alerts.showAlerts("Service Null", "There isnt a Service Instance", "Please, instante a service", AlertType.ERROR);
		}else {
			List<Department> list = service.FindAll();
			obslist = FXCollections.observableArrayList(list);
			tableViewDepartment.setItems(obslist);
		}
	}

}
