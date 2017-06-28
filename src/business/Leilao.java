package business;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.org.apache.regexp.internal.recompile;

public class Leilao {
	private int id_leilao;
	private boolean tipo, ativo;
	private Usuario principal;
	private String data_inicio, data_fim;
	private ArrayList<Usuario> participantes;
	
	
	public Leilao( boolean tipo, boolean ativo, Usuario principal, String data_inicio, String data_fim) {
		super();
		this.id_leilao = id_leilao;
		this.tipo = tipo;
		this.ativo = ativo;
		this.principal = principal;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;		
		participantes = new ArrayList<Usuario>();
	}
	
	public Leilao(int id_leilao, boolean tipo, boolean ativo, Usuario principal, String data_inicio, String data_fim) {
		super();
		this.id_leilao = id_leilao;
		this.tipo = tipo;
		this.ativo = ativo;
		this.principal = principal;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;		
		participantes = new ArrayList<Usuario>();
	}
	
	public boolean  adicionarParticipante(Usuario usuario) {
		
		boolean aux = true;
		
		for(Usuario usu: participantes){
			if(usu.getCnpj_cpf().equalsIgnoreCase(usuario.getCnpj_cpf())){
				aux = false;				
			}			
		}
		
		if(aux == true){
			participantes.add(usuario);			
		}
		
		return aux;
	}


	public int getId_leilao() {
		return id_leilao;
	}


	public void setId_leilao(int id_leilao) {
		this.id_leilao = id_leilao;
	}


	public boolean isTipo() {
		return tipo;
	}


	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public Usuario getPrincipal() {
		return principal;
	}


	public void setPrincipal(Usuario principal) {
		this.principal = principal;
	}


	public String getData_inicio() {
		return data_inicio;
	}


	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}


	public String getData_fim() {
		return data_fim;
	}


	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}


	public ArrayList<Usuario> getParticipantes() {
		return participantes;
	}
	
	
	
	
	

}
