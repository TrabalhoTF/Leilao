package business;

import persistence.DaoException;
import persistence.FacadePersistence;
import view.Fachada;

public class Main {
	
	public static Fachada fachadaView;	
	public static FacadePersistence fachadaPersistence;

	public Main() throws DaoException{
		fachadaView = new Fachada();
		this.fachadaPersistence = new FacadePersistence();
	}
}
