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
	
	// 0 1 / 0 1 / 2 0 0 1
	// 0 1 2 3 4 5 6 7 8 9 
	
	// 2 3 : 5 9
	// 0 1 2 3 4
	@Override
	public int hashCode() {
		
		int a = 0;
		int b = 0;
		
		if(getCpf_cnpj().length() == 14){
			
							
		b =	Integer.parseInt(getCpf_cnpj().substring(0, 3)) +
			Integer.parseInt(getCpf_cnpj().substring(4, 7)) +
			Integer.parseInt(getCpf_cnpj().substring(8, 11)) +
			Integer.parseInt(getCpf_cnpj().substring(12, 14));					
			
		} else{
						
		b=	Integer.parseInt(getCpf_cnpj().substring(0, 2)) +
			Integer.parseInt(getCpf_cnpj().substring(3, 6)) +
			Integer.parseInt(getCpf_cnpj().substring(7, 10)) +
			Integer.parseInt(getCpf_cnpj().substring(11, 15)) +
			Integer.parseInt(getCpf_cnpj().substring(16, 18));
		}
		
		
		
//		a = (int)   (Integer.parseInt(getData().substring(0, 2)) +
//					Integer.parseInt(getData().substring(3, 5)) + 
//					Integer.parseInt(getData().substring(6, 10)) +
//		       
//					Integer.parseInt(getHora().substring(0, 2)) +
//					Integer.parseInt(getHora().substring(3, 5)) +
//		     
//					getValor());
				
								
		return a*b*37;
	}

//	@Override
//	public boolean equals(Object obj) {
//		boolean aux = false;
//
//		if(obj instanceof Lance){
//			if(((Lance) obj).getData().equalsIgnoreCase(this.getData())){
//				if(((Lance) obj).getHora().equalsIgnoreCase(this.getHora())){
//					if(((Lance) obj).getValor() == this.getValor()){
//						aux = true;							
//					}						
//				}					
//			}				
//		}	
//		return aux;
//	}
//	
	

}
