package business;

import persistence.DaoException;
import persistence.FacadePersistence;
import view.Fachada;

public class Application {
	
	public static FacadePersistence persistenceFac;
	public static Fachada viewFac;
	public static LeilaoFachada leilaoFac;
	
	public Application() throws DaoException, LeilaoException{
		this.persistenceFac = new FacadePersistence();
		this.viewFac = new Fachada();
		this.leilaoFac = new LeilaoFachada();
	}
	
	public static FacadePersistence getPersistenceFac() {
		return persistenceFac;
	}
	public static void setPersistenceFac(FacadePersistence persistenceFac) {
		Application.persistenceFac = persistenceFac;
	}
	public static LeilaoFachada getLeilaoFac() {
		return leilaoFac;
	}

	public static void setLeilaoFac(LeilaoFachada leilaoFac) {
		Application.leilaoFac = leilaoFac;
	}

	public static Fachada getViewFac() {
		return viewFac;
	}
	public static void setViewFac(Fachada viewFac) {
		Application.viewFac = viewFac;
	}	
}
