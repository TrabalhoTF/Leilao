package business;

import java.util.ArrayList;
public class Lote {
	private int id_lote;	
	private float preco;
	private ArrayList<Produto> produtos;
	
	public Lote(int id_lote, float preco) {
		setPreco(preco);
		setId_lote(id_lote);
		produtos = new ArrayList<Produto>();
	}
	
	public void setId_lote(int id_lote) {
		this.id_lote = id_lote;
	}

	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}	

	public int getId_lote() {
		return id_lote;
	}

	public boolean addProdduto(Produto produto ){
		boolean aux = true;
		for(Produto p: produtos){
			if(p.getId_produto() == produto.getId_produto()){
				aux = false;				
			}		 
		}
		
		if(aux == true){
			produtos.add(produto);			
		}
		
		return aux;
	}
	
	public boolean removeProduto(int id_produto){
		boolean aux = false;
		for(int i = 0; i < produtos.size(); i++){
			if(produtos.get(i).getId_produto() == id_produto){
				produtos.remove(i);
				aux = true;
			}			
		}
		
		return aux;		
	}
	
	public ArrayList<Produto> getListaProdutos(){
		return produtos;		
	}
	
	@Override
	public int hashCode()	{
		return getId_lote() * 37;
	}
	
	@Override
	public boolean equals(Object lote){
		if ((lote instanceof Lote) && ((Lote) lote).getId_lote() == (this.getId_lote())){
			return true;
		}else
			return false;
	}
}