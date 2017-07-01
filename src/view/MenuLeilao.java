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


public class MenuLeilao {

	public MenuLeilao() {
	}

	public void openCadastrarUsuario(ActionEvent event){
		try{
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("CadastrarUsuario.fxml"));
			stage.setTitle("Cadastro de Usuário");
			stage.setScene(new Scene(root, 370, 232));
			stage.show();
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
	public void openCadastrarLeilao(ActionEvent event){
		try{
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("CadastrarLeilao.fxml"));
			stage.setTitle("Cadastro de Leilão");
			stage.setScene(new Scene(root, 850, 670));
			stage.show();
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
	public void openCadastrarLance(ActionEvent event){
		try{
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("CadastrarLance.fxml"));
			stage.setTitle("Cadastro de Lance");
			stage.setScene(new Scene(root, 370, 210));
			stage.show();
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
	public void openCancelarLance(ActionEvent event){
		try{
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("CancelarLance.fxml"));
			stage.setTitle("Canlemaneto de Lance");
			stage.setScene(new Scene(root, 370, 170));
			stage.show();
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
	public void openVisualizar(ActionEvent event){
		try{
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Visualizar.fxml"));
			stage.setTitle("Visualização de Leilões");
			stage.setScene(new Scene(root, 977, 390));
			stage.show();
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
}