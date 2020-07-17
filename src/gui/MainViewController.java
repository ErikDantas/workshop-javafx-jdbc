package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.service.DepartmentService;

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
		loadNewViewDepartment("/gui/DepartmentListView.fxml");
	}
	public void onMenuItemAbout() {
		loadNewView("/gui/AboutView.fxml");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public synchronized void loadNewView(String absolutName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainBox.getChildren().get(0);
			mainBox.getChildren().clear();
			mainBox.getChildren().add(mainMenu);
			mainBox.getChildren().addAll(newVBox.getChildren());			
			
			
		}catch(IOException e) {
			Alerts.showAlerts("IOException Error", "The new View cannot loader", e.getMessage(), AlertType.ERROR);
		}
	}
	public synchronized void loadNewViewDepartment(String absolutName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainBox.getChildren().get(0);
			mainBox.getChildren().clear();
			mainBox.getChildren().add(mainMenu);
			mainBox.getChildren().addAll(newVBox.getChildren());			
			
			DepartmentListController controller = loader.getController();
			controller.setDepartmentService(new DepartmentService());
			controller.UpdateTableView();
			
		}catch(IOException e) {
			Alerts.showAlerts("IOException Error", "The new View cannot loader", e.getMessage(), AlertType.ERROR);
		}		
	}

}
