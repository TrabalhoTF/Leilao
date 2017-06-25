package Business;

public class Lance {
	private String hora;
	private String data;
	private int id_leilao, id_usuario;
	private float valor;
	
	public Lance(int id_leilao, int id_usuario, String data, String hora){
		setData(data);
		setHora(hora);
		setId_leilao(id_leilao);
		setId_usuario(id_usuario);
		setValor(valor);		
	}

	public int getId_leilao() {
		return id_leilao;
	}

	public void setId_leilao(int id_leilao) {
		this.id_leilao = id_leilao;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString(){
		return "Id leilão: "+ getId_leilao()+ 
			 "\nId do Usuario: " + getId_usuario() + 
			 "\nHora e data: "+ getData()+ " as " + getHora()+
			 "\nValor do lance: " +getValor();		
	}
	
	// 0 1 / 0 1 / 2 0 0 1
	// 0 1 2 3 4 5 6 7 8 9 
	
	// 2 3 : 5 9
	// 0 1 2 3 4
	@Override
	public int hashCode() {
		int aux = (Integer.parseInt(getData().substring(0, 2)) +
				   Integer.parseInt(getData().substring(3, 5)) + 
		           Integer.parseInt(getData().substring(6, 10)) +
		          
		           Integer.parseInt(getHora().substring(0, 2)) +
		           Integer.parseInt(getHora().substring(3, 5)) +
		          
		           getId_leilao() +
		           getId_usuario() ) *7 +
				  (int)getValor();
		return aux;
	}

	@Override
	public boolean equals(Object obj) {
		boolean aux = false;
		
		if(obj instanceof Lance){
			if((((Lance) obj).getId_leilao() + ((Lance) obj).getId_usuario()) 
			  == (this.getId_leilao() + this.getId_usuario())){
				if(((Lance) obj).getData().equalsIgnoreCase(this.getData())){
					if(((Lance) obj).getHora().equalsIgnoreCase(this.getHora())){
						if(((Lance) obj).getValor() == this.getValor()){
							aux = true;							
						}						
					}					
				}				
			}			
		}
		
		return aux;
	}
	
	

}
