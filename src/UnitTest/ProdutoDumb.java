package unitTest;

import business.*;

public class ProdutoDumb extends Produto {
	static String descBreve = "Prodduto de boa qualidade.";
	static String descCompleta = "Produto de boa qualidade fabricado na China e importado do Paraguai";

	public ProdutoDumb() {		
		super(12345, Categoria.INFORMATICA, descBreve, descCompleta);
	}

}
