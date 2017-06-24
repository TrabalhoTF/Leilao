package business;

public class Lance {
	private String id_leilao, id_usuario, data, hora;
	private float valor;
	
	public Lance(String id_leilao, String id_usuario, String data, String hora){
		setData(data);
		setHora(hora);
		setId_leilao(id_leilao);
		setId_usuario(id_usuario);
		setValor(valor);		
	}

	public String getId_leilao() {
		return id_leilao;
	}

	public void setId_leilao(String id_leilao) {
		this.id_leilao = id_leilao;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
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
		int aux = Integer.parseInt(getData().substring(0, 1)) +
				  Integer.parseInt(getData().substring(3, 4)) + 
		          Integer.parseInt(getData().substring(6, 9)) +
		          
		          Integer.parseInt(getHora().substring(0, 1)) +
		          Integer.parseInt(getHora().substring(3, 4)) +
		          
		          Integer.parseInt(getId_leilao()) +
		          Integer.parseInt(getId_usuario()) +
		          
		          (int)getValor();
		return aux;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lance other = (Lance) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id_leilao == null) {
			if (other.id_leilao != null)
				return false;
		} else if (!id_leilao.equals(other.id_leilao))
			return false;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}
	
	

}
