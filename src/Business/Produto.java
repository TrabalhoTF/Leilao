package Business;
public class Produto { 
	
	private int id_produto;
	private Categoria categ;
	private String descBreve;
	private String descCompleta;
	
	public Produto(int id_produto, Categoria categ, String descBreve, String descCompleta) {
		setCateg(categ);
		setId_produto(id_produto);
		setDescBreve(descBreve);
		setDescCompleta(descCompleta);		
	}
	
	public Categoria getCateg() {
		return categ;
	}
	
	public void setCateg(Categoria categ) {
		this.categ = categ;
	}
	
	public String getDescBreve() {
		return descBreve;
	}
	
	public void setDescBreve(String descBreve) {
		this.descBreve = descBreve;
	}
	
	public String getDescCompleta() {
		return descCompleta;
	}
	
	public void setDescCompleta(String descCompleta) {
		this.descCompleta = descCompleta;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	
	@Override
	public int hashCode()	{
		return getId_produto() * 37;
	}
	
	@Override
	public boolean equals(Object produto){
		if ((produto instanceof Produto) && ((Produto) produto).getId_produto() == (this.getId_produto())){
			return true;
		}else
			return false;
	}
	
}
