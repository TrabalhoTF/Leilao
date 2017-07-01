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

		if(cnpj_cpf.length() == 14){
			int a = Integer.parseInt(getCnpj_cpf().substring(0, 3));
			int b = Integer.parseInt(getCnpj_cpf().substring(4, 7));
			int c = Integer.parseInt(getCnpj_cpf().substring(8, 11));
			int d = Integer.parseInt(getCnpj_cpf().substring(12, 14));


			return ((a + b) * (c + d)) * 37;

		} else{
			// XX.XXX.XXX/0001-XX
			int a = Integer.parseInt(getCnpj_cpf().substring(0, 2));
			int b = Integer.parseInt(getCnpj_cpf().substring(3, 6));
			int c = Integer.parseInt(getCnpj_cpf().substring(7, 10));
			int d = Integer.parseInt(getCnpj_cpf().substring(11, 15));
			int e = Integer.parseInt(getCnpj_cpf().substring(16, 18));

			//	System.out.println(getCnpj_cpf().substring(0,2)+" "+getCnpj_cpf().substring(3,6)+" "+ getCnpj_cpf().substring(7,10)+" "+getCnpj_cpf().substring(11,14)+" "+getCnpj_cpf().substring(16, 18));

			return ( (a + b) * (c + d)  + e) * 37;			
		}


	}

	@Override
	public boolean equals(Object usuario){
		if ((usuario instanceof Usuario) && ((Usuario) usuario).getCnpj_cpf() == (this.getCnpj_cpf())){
			return true;
		}else
			return false;
	}


}