package business;

import persistence.DaoException;
import persistence.FacadePersistence;
import view.Fachada;

public class Application {
	
	private FacadePersistence persistenceFac;
	private Fachada viewFac;
	private LeilaoFachada leilaoFac;
	
	public Application() throws DaoException, LeilaoException{
		this.persistenceFac = new FacadePersistence();
		this.viewFac = new Fachada();
		this.leilaoFac = new LeilaoFachada();
	}
	
	public  FacadePersistence getPersistenceFac() {
		return persistenceFac;
	}
	public  void setPersistenceFac(FacadePersistence persistenceFac) {
		this.persistenceFac = persistenceFac;
	}
	public  LeilaoFachada getLeilaoFac() {
		return leilaoFac;
	}

	public  void setLeilaoFac(LeilaoFachada leilaoFac) {
		this.leilaoFac = leilaoFac;
	}

	public  Fachada getViewFac() {
		return viewFac;
	}
	public  void setViewFac(Fachada viewFac) {
		this.viewFac = viewFac;
	}	
}
