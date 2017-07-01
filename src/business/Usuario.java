package business;

public class Usuario { 
	private String nome, email, cnpj_cpf;
	
	public Usuario(String cnpj_cpf, String nome, String email){
		setCnpj_cpf(cnpj_cpf);
		setEmail(email);
		setNome(nome);		
	}

	public String getCnpj_cpf() {
		return cnpj_cpf;
	}

	public void setCnpj_cpf(String cnpj_cpf) {
		this.cnpj_cpf = cnpj_cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
}
