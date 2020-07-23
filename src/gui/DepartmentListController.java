package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import entities.Department;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
	public void onNewBtnDepartment(ActionEvent event) {
		Stage parentStage = Utils.currentStage(event);
		departmentFormView("/gui/DepartmentForm.fxml", parentStage);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializableNodes();
		
	}
	public void setDepartmentService(DepartmentService service) {
		this.service=service;
	}
	
	public void UpdateTableView() {
		if(service==null) {
			Alerts.showAlerts("Service Null", "There isnt a Service Instance", "Please, instante a service", AlertType.ERROR);
		}else {
			List<Department> list = service.findAll();
			obslist = FXCollections.observableArrayList(list);
			tableViewDepartment.setItems(obslist);
		}
	}

	private void initializableNodes() {
		tablecolumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tablecolumnname.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		
		
	}
	
	private void departmentFormView(String absolutname, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutname));
			Pane pane = loader.load();
			
			Stage dialogstage = new Stage();
			dialogstage.setTitle("New Department Data");
			dialogstage.setResizable(false);
			dialogstage.setScene(new Scene (pane));
			dialogstage.initOwner(parentStage);
			dialogstage.initModality(Modality.WINDOW_MODAL);
			dialogstage.showAndWait();
		}catch(IOException e) {
			Alerts.showAlerts("IO Exception", "Cannot show new dialog", e.getMessage(), AlertType.ERROR);
		}
		
	}

}
