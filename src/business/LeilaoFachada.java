package business;

import java.util.ArrayList;

import persistence.LeilaoDAOException;

public class LeilaoFachada { 
	
	private LeilaoDAOException leilaoDao; 
	private Usuario usuario;
	private Produto produto;
	private Lance lance;
	private Lote lote;
	
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Produto> listaProdutos;
	private ArrayList<Lote> listaLote;
	
	
	public LeilaoFachada() throws LeilaoException {	
		listaUsuarios = new ArrayList<Usuario>();
		listaProdutos = new ArrayList<Produto>();
		listaLote = new ArrayList<Lote>();
		
				
        LeilaoDAOException ld = new LeilaoDAOException();
    }
	
	public boolean cadastrarUsuario(String cnpj_cpf, String nome, String email) throws LeilaoException {
		int cont = 0;
		boolean aux = false;	
		
		if(ValidadorDados.validarCpfCnpj(cnpj_cpf) == false){
			 throw new LeilaoException("CPF ou CNPJ invalido!");						
		}else{
			cont = cont +1;
		}
		
		if(ValidadorDados.validarEmail(email) == false){
			throw new LeilaoException("Email invalido");						
		}else{
			cont = cont +1;			
		}
		if(cont == 2){
			usuario = new Usuario(cnpj_cpf, nome, email);
			listaUsuarios.add(usuario);			
			aux = true;
		}		
		return aux;
	}
	
	public boolean cadastrarProduto(int id_produto, Categoria categ, String descBreve, String descCompleta) throws LeilaoDAOException{		
		produto = new Produto(id_produto, categ, descBreve, descCompleta);		
		return listaProdutos.add(produto);		
	}
	
	public boolean criarLote(int id_lote, float preco) throws LeilaoException{
		boolean aux = false;
		if(ValidadorDados.validarValor(preco)){
			lote = new Lote(id_lote, preco);
			aux = listaLote.add(lote);
		}				
		return aux;		
	}
	
	public boolean adicionarProdutoLote( int id_lote, int id_produto ){
		boolean aux = false;
		for(Lote lo: listaLote){
			if(lo.getId_lote() == id_lote){
				for(Produto prod :listaProdutos){
					if(prod.getId_produto() == id_produto){
						lo.addProdduto(prod);
						aux = true;
					}					
				}
								
			}			
		}
		return aux;
		
	}
	
	
	
	

	
}
