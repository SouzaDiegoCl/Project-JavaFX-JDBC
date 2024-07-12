package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtName;

	@FXML
	private Label lblErrorName;

	@FXML
	private Button btnSave;

	@FXML
	private Button btnCancel;
	
	
	@FXML 
	public void onBtnSaveAction(){
		System.out.println("Save button");
	}

	@FXML 
	public void onBtnCancelAction(){
		System.out.println("Cancel Button");
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		intializeNodes();
	}
	
	private void intializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}

}
