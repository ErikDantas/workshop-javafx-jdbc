package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable{

	@FXML
	private Button btnNewDepartment;
	
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department, Integer> tablecolumnId;
	
	@FXML
	private TableColumn<Department, String> tablecolumnname;
	
	@FXML
	public void onNewBtnDepartment() {
		System.out.println("Click");
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializableNodes();
		
	}


	private void initializableNodes() {
		tablecolumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tablecolumnname.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
		
		
	}

}
