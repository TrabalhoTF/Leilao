package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Index extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		   try{
			    primaryStage = new Stage();
	            Parent root = FXMLLoader.load(getClass().getResource("CadastroFuncionario.fxml"));
	            stage.setTitle("Rent a Thing - Cadastrando novo Funcionario");
	            stage.setScene(new Scene(root, 400, 530));
	            stage.setX(350);
	            stage.setY(-5);
	            stage.show();
	        } catch (Exception e){
	            System.out.println(e);
	}

	public static void main(String[] args) {
		launch(args);
	}



}
