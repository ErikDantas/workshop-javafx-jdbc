package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import db.DB;
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
import model.service.SellerService;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuitemseller;
	
	@FXML
	private MenuItem menuitemdepartment;
	
	@FXML
	private MenuItem menuitemabout;
	
	public void onMenuItemSeller() {
		/*loadNewView("/gui/SellerListView.fxml", (SellerListController controller) -> {
			controller.setSellerService(new SellerService());
			controller.updateList();
		});
		*/
	}
	public void onMenuItemDepartment() {
		loadNewView("/gui/DepartmentListView.fxml", (DepartmentListController controller) -> {
			controller.setDepartmentService(new DepartmentService());
			controller.UpdateTableView();
		});
	}
	public void onMenuItemAbout() {
		loadNewView("/gui/AboutView.fxml", x -> {});
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		DB.getConnection();
		
	}
	
	public synchronized <T> void loadNewView(String absolutName, Consumer<T> initializableAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainBox.getChildren().get(0);
			mainBox.getChildren().clear();
			mainBox.getChildren().add(mainMenu);
			mainBox.getChildren().addAll(newVBox.getChildren());			
			
			T controller = loader.getController();
			initializableAction.accept(controller);
			
		}catch(IOException e) {
			Alerts.showAlerts("IOException Error", "The new View cannot loader", e.getMessage(), AlertType.ERROR);
		}
	}

}
