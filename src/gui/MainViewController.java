package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuitemseller;
	
	@FXML
	private MenuItem menuitemdepartment;
	
	@FXML
	private MenuItem menuitemabout;
	
	public void onMenuItemSeller() {
		System.out.println("Seller");
	}
	public void onMenuItemDepartment() {
		System.out.println("Department");
	}
	public void onMenuItemAbout() {
		System.out.println("About");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
