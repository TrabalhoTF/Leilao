package view;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class IndexController extends Application{

	@FXML Button cadastroUser;	
	@FXML Button cadastroLeilao;
	@FXML Button cadastroLance;	
	@FXML Button cancelarLance;
	@FXML Button visualizar;
	MenuLeilao menu = new MenuLeilao();

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

	public void  handle(ActionEvent event){
		if(event.getTarget().equals(this.cadastroUser)){
			this.menu.openCadastrarUsuario(new ActionEvent());
		}else 
			if(event.getTarget().equals(this.cadastroLeilao)){
				this.menu.openCadastrarLeilao(new ActionEvent());
			}else 
				if(event.getTarget().equals(this.cadastroLance)){
					this.menu.openCadastrarLance(new ActionEvent());
				}else 
					if(event.getTarget().equals(this.cancelarLance)){
						this.menu.openCancelarLance(new ActionEvent());
					}else 
						if(event.getTarget().equals(this.visualizar)){
							this.menu.openVisualizar(new ActionEvent());
						}
		
	}

}
