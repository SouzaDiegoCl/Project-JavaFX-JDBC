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
import model.services.DepartmentService;

public class MainViewController implements Initializable{

	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;

	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction");
	}
	@FXML
	public void onMenuItemDepartmentAction() {
		loadView2("/gui/DepartmentList.fxml");
	}
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/about.fxml");
	}
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	//synchronized garante que essa função não vai ser interrompida durante por conta do multi thread
	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVbox = loader.load();			
			
			Scene mainScene = Main.getMainScene();
			//getRoot() pega o primeiro elemento da view principal
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);//Guarda menu do main 
			mainVBox.getChildren().clear(); //Limpa tudo do main inclusive o menu, botoes, etc
			mainVBox.getChildren().add(mainMenu); //Adiciona o menu do main novamente
			mainVBox.getChildren().addAll(newVbox.getChildren());//Adiciona no main o conteudo(filhos) da nova janela
		}
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	private synchronized void loadView2(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVbox = loader.load();			
			
			Scene mainScene = Main.getMainScene();
			//getRoot() pega o primeiro elemento da view principal
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);//Guarda menu do main 
			mainVBox.getChildren().clear(); //Limpa tudo do main inclusive o menu, botoes, etc
			mainVBox.getChildren().add(mainMenu); //Adiciona o menu do main novamente
			mainVBox.getChildren().addAll(newVbox.getChildren());//Adiciona no main o conteudo(filhos) da nova janela
			
			DepartmentListController controller = loader.getController();
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();
		}
		catch(IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	

}
