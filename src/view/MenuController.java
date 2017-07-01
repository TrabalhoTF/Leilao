package view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;
import javax.xml.ws.Action;
import javafx.event.ActionEvent;

public class MenuController {
	@FXML private MenuBar menuCadastro;

	public MenuController() {
	}

	@Action
	public void openCadastrarFuncionario(ActionEvent event){
		try{
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("CadastroFuncionario.fxml"));
			stage.setTitle("Rent a Thing - Cadastrando novo Funcionario");
			stage.setScene(new Scene(root, 400, 530));
			stage.setX(350);
			stage.setY(-5);
			stage.show();
		} catch (Exception e){
			System.out.println(e);
		}
	}

	@Action
	public void openCadastrarEquipamento(ActionEvent event){
		try{
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("CadastroEquipamento.fxml"));
			stage.setTitle("Rent a Thing - Cadastrando novo Equipamento");
			stage.setScene(new Scene(root, 400, 600));
			stage.setX(350);
			stage.setY(-5);
			stage.show();
		} catch (Exception e){
			System.out.println(e);
		}
	}
}