package business;

import java.util.ArrayList;
import java.util.HashMap;

import persistence.DaoException;
import persistence.FacadePersistence;
import sun.nio.cs.US_ASCII;

public class LeilaoFachada { 
	
	private FacadePersistence fachadaDao;	
	
	
	public LeilaoFachada() throws LeilaoException{			
		try {
			fachadaDao = new FacadePersistence();
			
		} catch (DaoException e) {
			throw new LeilaoException("ERRO AO CRIAR A FACHADA!", e);
		}		
		
		
    }
	
	// Cria um usuario e adiciona ele no BD
	
	public boolean cadastrarUsuario(String cnpj_cpf, String nome, String email) throws LeilaoException, DaoException {
		
		String cnpj_cpfValido = ValidadorDados.validarCpfCnpj(cnpj_cpf);
		String emailValido = ValidadorDados.validarEmail(email);
		
		if(cnpj_cpf != null){
			if(emailValido != null){
				Usuario user = new Usuario(cnpj_cpfValido, nome, emailValido);
						
					System.out.println("FAlta implementar metodo no cadastrar usuario");		
				
				fachadaDao.addUser(user);
			} else{
				new LeilaoException("E-mail invalido!"); 
			}
		} else {
			new LeilaoException("CPF/CNPJ invalido!"); 
		}
		
		return false;
	}
	
	//Retorna uma lista com todos os usuarios
	public ArrayList<Usuario> getListaTodosUsuarios() throws DaoException{
		ArrayList<Usuario> listaUsuarios = fachadaDao.getArrayListUsers();
		
		if(listaUsuarios == null){
			new DaoException("Não foi possivel gerar a lista com todos os usuarios cadastrados no BD!")	;					
		}
		return listaUsuarios;
	}
	
	// Retorna um usuario apartir do seu CPF ou CNPJ	
	public Usuario buscaUsuarioCPF(String cpf){
		
		return null;		
	}
	
	// Cria produto e adiciona no BD
	public boolean cadastrarProduto(int id_produto, Categoria categ, String descBreve, String descCompleta) throws DaoException{		
		Produto produto = new Produto(id_produto, categ, descBreve, descCompleta);			
		
		return fachadaDao.addProd(produto);	
	}
	
	//Retorna uma lista com os produtos cadastrados
	public ArrayList<Produto> listaProdutos() throws DaoException{
		ArrayList<Produto> listaProdutos = fachadaDao.getArrayListProd();
		
		if(listaProdutos == null){
			new DaoException("Não foi possivel gerar a lista com todos os produtos cadastrados no BD!")	;		
		}
		
		return listaProdutos;
	}
	
	// Retorna um produto apartir do id de produto informado	
	public Produto buscaProdutoId(int id_produto) throws DaoException{		
		Produto aux = null; 
		
		ArrayList<Produto> lista= listaProdutos();
		for(int i = 0; i < lista.size(); i++){
			if(lista.get(i).getId_produto() == id_produto){
				aux = lista.get(i);				
			}			
		}
		
		return aux;		
	}
	
	//cria um lote 
	public boolean cadastrarLote(int id_lote, float valor) throws DaoException{
		boolean aux = false;
		
		if(ValidadorDados.validarValor(valor)){
			
			Lote lote = new Lote(id_lote, valor);
			
			
			if(fachadaDao.addLote(lote) == false){
				throw new DaoException("Não foi possivel cadastrar o lote no BD!");				
			} else {
				aux = true;
			}			
						
		} else {
			new LeilaoException("Não criar o lote!")	;
		}
		
		return aux;		
	}
	
	// Retorna uma lista com os lotes
	public ArrayList<Lote> getListaLotes() throws DaoException{
		ArrayList<Lote> lista = fachadaDao.getArrayListLote();		
		return lista;
	}
	
	// busca um lote pelo id
	public Lote buscaLotePorId(int id_lote) throws DaoException{
		Lote aux = fachadaDao.getLoteById(id_lote);
		
		if(aux == null){
			throw new DaoException("Não foi possivel encontrar o lote no BD!");				
		}
		
		return aux;
	}
	
	// Adiciona um produto ao lote
	public boolean adicionarProdutoLote(int id_lote, int id_produto) throws DaoException{
		Lote lote = buscaLotePorId(id_lote);
		Produto prod = buscaProdutoId(id_produto);
		
		boolean aux = false;
		
		if(lote != null){
			if(prod != null){
				buscaLotePorId(id_lote).addProdduto(buscaProdutoId(id_produto));
				aux = true;
				
				fachadaDao.addLoteXProduto(id_lote, id_produto);
				
			} else{
				new DaoException("Não foi possivel encontrar o produto no BD!")	;
			}		
						
		}else{
			new DaoException("Não foi possivel encontrar o lote no BD!");
		}
		
		return aux;
	}
	
	
	// retorna uma lista de produtos apartir do id do lote
	public ArrayList<Produto> buscaListaProdutosIdLote(int id_lote ) throws DaoException{
		ArrayList<Produto> listaProd = fachadaDao.getArrayListProd();
		ArrayList<Integer> listaIdProduto = fachadaDao.getArrayListLoteXProd();
		ArrayList<Produto> listaProdFinal = new ArrayList<Produto>();
		
		

		return null;
	}	
}
