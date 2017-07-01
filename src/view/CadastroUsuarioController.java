package view;

import javax.xml.ws.Action;

import business.LeilaoException;
import business.LeilaoFachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import persistence.DaoException;
import persistence.FacadePersistence;

public class CadastroUsuarioController {

	@FXML TextField textNome;
	@FXML TextField textCpf;
	@FXML TextField textEmail;
	/*--------------------------------------------------------*/
	LeilaoFachada facade;

	public  CadastroUsuarioController() throws LeilaoException {
		facade =  new LeilaoFachada();
	}

	@Action
	public boolean cadastrarUsuario() throws LeilaoException, DaoException{	
		try{
				this.facade.cadastrarUsuario(this.textCpf.getText(),
						this.textNome.getText(),
						this.textEmail.getText());
			}catch(Exception e ){
				e.printStackTrace();
				return false;
			}
			return true;
		}

	}
