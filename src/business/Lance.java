package business;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lance {
	private int idLance;
	private LocalTime hora;
	private LocalDate data;
	private String cpf_cnpj;	
	private int idLeilao;
	private float valor;
	
	public int getIdLance() {
		return idLance;
	}

	public void setIdLance(int idLance) {
		this.idLance = idLance;
	}

	public int getIdLeilao() {
		return idLeilao;
	}

	public void setIdLeilao(int idLeilao) {
		this.idLeilao = idLeilao;
	}

;
	
	public Lance(String cpf_cnpj, int idLeilao, LocalDate data, LocalTime hora, float valor){
		setIdLeilao(idLeilao);
		setData(data);
		setHora(hora);
		setCpf_cnpj(cpf_cnpj);
		setValor(valor);		
	}
	
	public Lance(int idLance, int idLeilao, String cpf_cnpj, LocalDate  data, LocalTime hora, float valor){
		setIdLeilao(idLeilao);
		setIDLance(idLance);
		setData(data);
		setHora(hora);
		setCpf_cnpj(cpf_cnpj);
		setValor(valor);		
	}
	
	public int getIDLance(){
		return this.idLance;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public void setIDLance(int idLance){
		this.idLance = idLance;
	}
	
	@Override
	public String toString(){
		return
			 "\nId do Usuario: " + getCpf_cnpj() + 
			 "\nHora e data: "+ getData()+ " as " + getHora()+
			 "\nValor do lance: " +getValor();		
	}
}
