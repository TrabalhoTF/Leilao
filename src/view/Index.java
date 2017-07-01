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
			Parent root = FXMLLoader.load(getClass().getResource("Index.fxml"));
			primaryStage.setTitle("Leilao - Menu");
			primaryStage.setScene(new Scene(root, 355, 460));
			primaryStage.show();
		} catch (Exception e){
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}



}
