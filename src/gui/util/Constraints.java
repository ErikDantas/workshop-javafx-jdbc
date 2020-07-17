package gui.util;

import javafx.scene.control.TextField;

public class Constraints {
	public static void setTextFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldvalue, newvalue) ->{
			if(newvalue!=null && !newvalue.matches("\\d*")) {
				txt.setText(oldvalue);
			}
		});
	}
	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldvalue, newvalue) -> {
			if(newvalue!=null && !newvalue.matches("\\d*([\\.]\\d*)?")) {
				txt.setText(oldvalue);
			}
		});
	}
	public static void setTextFieldMaxLenght(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldvalue, newvalue) -> {
			if(newvalue!=null && newvalue.length() > max) {
				txt.setText(oldvalue);
			}
		});
	}
}
