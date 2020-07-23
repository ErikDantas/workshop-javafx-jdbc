package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable{

	@FXML
	private TextField tfid;
	
	@FXML
	private TextField tfname;
	
	@FXML
	private Label lberror;
	
	@FXML
	private Button btnsave;
	
	@FXML
	private Button btncancel;
	
	@FXML
	public void onClickBtnSave() {
		System.out.println("Click Save");
	}
	
	@FXML
	public void onClickBtnCancel() {
		System.out.println("Click Cancel");
	}		
			
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializableNodes();
		
	}
	
	private void initializableNodes() {
		Constraints.setTextFieldInteger(tfid);
		Constraints.setTextFieldMaxLenght(tfname, 20);
	}

}
