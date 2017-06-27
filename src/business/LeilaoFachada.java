package business;

import java.util.ArrayList;
import java.util.HashMap;

import persistence.DaoException;

public class LeilaoFachada { 
	
	
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<Produto> listaProdutos;
	private ArrayList<Lote> listaLote;
	private ArrayList<Leilao> listaLeilao;
	
	private HashMap<Integer, Lote> mapId_leilaoLote;
	
	
	public LeilaoFachada() throws DaoException{	
		listaUsuarios = new ArrayList<Usuario>();
		listaProdutos = new ArrayList<Produto>();
		listaLote = new ArrayList<Lote>();			
		
		mapId_leilaoLote = new HashMap<Integer, Lote>();
		
		throw new DaoException("ERRO AO CRIAR A FACHADA! ");
    }
	
	public boolean cadastrarUsuario(String cnpj_cpf, String nome, String email) throws LeilaoException {
		Usuario usuario = null;
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
		Produto produto = new Produto(id_produto, categ, descBreve, descCompleta);		
		return listaProdutos.add(produto);		
	}
	
	public boolean criarLoteAdtibuirLeilao(int id_leilao, int id_lote, float preco) throws LeilaoException{
		Lote lote;
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
	
	public HashMap<Integer, Lote> getMapId_leilaoLote(){
		return mapId_leilaoLote;
	}
	
	public boolean adicionarProdutoLote( int id_leilao, int id_lote, int id_produto ) throws LeilaoException{
		boolean aux = false;
		Produto prodAux = null;
		for(Lote lo: listaLote){
			if(lo.getId_lote() == id_lote){
				for(Produto prod :listaProdutos){
					if(prod.getId_produto() == id_produto){
						prodAux = prod;
						lo.addProdduto(prod);
					}					
				}

			}			
		}		

		
		if(prodAux == null){
			new LeilaoException("Produto não encontrado!");
		} else {
			if(mapId_leilaoLote.containsKey(id_leilao)){	
				mapId_leilaoLote.get(id_leilao).addProdduto(prodAux);		
				aux = true;
			} else {
				new LeilaoException("Leilão não encontrado!");
			}
		}
		return aux;		
	}	
	
	public boolean criarLeilao(int id_leilao, boolean tipo, boolean ativo, Usuario principal, String data_inicio,String data_fim) throws LeilaoException{
		boolean aux = false;
		int cont = 0;		
		Usuario usuarioAux= principal;
		
		if(ValidadorDados.compararDatas(data_inicio, data_fim) == 1){
			cont = cont +1;						
		}else if(ValidadorDados.compararDatas(data_inicio, data_fim) == -1){
			new LeilaoException("Datas invalidas! Data de final não pode ser menor que a data inicial!");			
		} else{
			new LeilaoException("Formato invalido para datas!");
		}
		
		if(usuarioAux != null){
			cont = cont +1;				
		}else{
			new LeilaoException("Usuario invalido!");
		}
		
		if(cont == 2){	
			for(Leilao lei: listaLeilao){
				if(lei.getId_leilao()== id_leilao){
					cont = 0;					
				}				
			}
		}
		
		if(cont == 2){
			aux = true;
			Leilao leilaoAux = new Leilao(id_leilao, tipo, ativo, principal, data_inicio, data_fim);	
			listaLeilao.add(leilaoAux);
		} else {
			new LeilaoException("Leilao já existente!");
		}			
		return aux;
	}
	
	// gera uma lista de acordo com os parametros escolhidos
	// se tipo = false leilao por demanda
	// se tipo = true leilao comum
	// se ativo = true leilao ativo
	// se ativo = false leilao encerrado
	public ArrayList<Leilao> getListaAtivosTipo(boolean tipo, boolean ativo){
		
		ArrayList<Leilao> listaAtivosInativos = new ArrayList<Leilao>();
		
		if(tipo == true && ativo == true){
			for(Leilao lei: listaLeilao){
				if(lei.isAtivo() == true && lei.isTipo() == true){
					listaAtivosInativos.add(lei);					
				}				
			}			
		}else if(tipo == false && ativo == true){
			for(Leilao lei: listaLeilao){
				if(lei.isAtivo() == false && lei.isTipo() == true){
					listaAtivosInativos.add(lei);					
				}				
			}
			
		}else if(tipo == true && ativo == false){
			for(Leilao lei: listaLeilao){
				if(lei.isAtivo() == true && lei.isTipo() == false){
					listaAtivosInativos.add(lei);					
				}				
			}
			
		}else {
			for(Leilao lei: listaLeilao){
				if(lei.isAtivo() == false && lei.isTipo() == false){
					listaAtivosInativos.add(lei);					
				}				
			}			
		}
		
		return listaAtivosInativos;
	}
	
}