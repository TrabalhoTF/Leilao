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
	
	@Override
	public String toString(){
		return "Nome: "+getNome()+"\nCNPJ/CPF: " + getCnpj_cpf()+"\nE-mail: "  + getEmail();		
	}
	
	@Override
	public int hashCode()	{
		int a = Integer.parseInt(getCnpj_cpf().substring(0, 3));
		int b = Integer.parseInt(getCnpj_cpf().substring(4, 7));
		int c = Integer.parseInt(getCnpj_cpf().substring(8, 11));
		int d = Integer.parseInt(getCnpj_cpf().substring(12, 14));
		System.out.println(a +" "+ b +" "+ c + " " + d);
		
		return (a *b *c * d) * 37;
	}
	
	
	public boolean equals2(Object usuario){
		if ((usuario instanceof Usuario) && ((Usuario) usuario).getCnpj_cpf() == (this.getCnpj_cpf())){
			return true;
		}else
			return false;
	}
	
}
