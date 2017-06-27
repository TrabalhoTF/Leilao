package business;

import java.util.ArrayList;
import java.util.HashMap;

import persistence.DaoException;

public class LeilaoFachada { 
	
	private Usuario usuario;
	private Produto produto;
	private Lance lance;
	private Lote lote;
	
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Produto> listaProdutos;
	private ArrayList<Lote> listaLote;
	
	private HashMap<Integer, Lote> mapId_leilaoLote;
	
	
	public LeilaoFachada() throws DaoException{	
		listaUsuarios = new ArrayList<Usuario>();
		listaProdutos = new ArrayList<Produto>();
		listaLote = new ArrayList<Lote>();			
		
		mapId_leilaoLote = new HashMap<Integer, Lote>();
		
		throw new DaoException("ERRO AO CRIAR A FACHADA! ");
    }
	
	public boolean cadastrarUsuario(String cnpj_cpf, String nome, String email) throws LeilaoException {
		int cont = 0;
		boolean aux = false;	

		if(ValidadorDados.validarEmail(email)){
			cont = cont +1;
		}else{
			throw new LeilaoException("Email invalido");				
		}

		if(ValidadorDados.validarCpfCnpj(cnpj_cpf)){
			cont = cont +1;				
		}else{
			throw new LeilaoException("CPF/CNPJ invalido");
		}

		if(cont == 2){				
			for(Usuario user: listaUsuarios){
				if(user.getCnpj_cpf().equalsIgnoreCase(cnpj_cpf)){
					cont = cont +1;										
				} 
			}	
		}else {
			throw new LeilaoException("Usuário já cadastrado!");
		}

		if(cont == 2){
			usuario = new Usuario(cnpj_cpf, nome, email);
			listaUsuarios.add(usuario);
			aux = true;
		} 

		return aux;
	}

	public ArrayList<Usuario> getListaUsuario(){
		return listaUsuarios;
	}

	public boolean cadastrarProduto(int id_produto, Categoria categ, String descBreve, String descCompleta) throws DaoException{		
		produto = new Produto(id_produto, categ, descBreve, descCompleta);		
		return listaProdutos.add(produto);		
	}
	
	public boolean criarLote(int id_leilao, int id_lote, float preco) throws LeilaoException{
		boolean aux = false;
		if(ValidadorDados.validarValor(preco)){
			lote = new Lote(id_lote, preco);
			aux = listaLote.add(lote);
			
			if(mapId_leilaoLote.containsKey(id_leilao)== false){
				mapId_leilaoLote.put(id_leilao, lote);
				aux = true;
			}else{
				new LeilaoException("Já existe um lote cadastrado para esse leilao!");
			}	
			
		}else{
			new LeilaoException("Lote não cadastrado! Atribuia a ele um valor válido!");
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