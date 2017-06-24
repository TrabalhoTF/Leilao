package business;

import persistence.LeilaoDAOBD;

public class LeilaoFachada { 
	
	private LeilaoDAOBD leilaoDao; 
	private Usuario usuario;
	
	public LeilaoFachada() throws LeilaoException {		
				
        leilaoDao = new LeilaoDAOBD();
    }
	
	public boolean cadastrarUsuario(String cnpj_cpf, String nome, String email) throws LeilaoException {
		boolean aux = false;	
		
		if(ValidadorDados.validarCpfCnpj(cnpj_cpf) == false){
			 throw new LeilaoException("CPF ou CNPJ invalido!");						
		}
		
		if(ValidadorDados.validarEmail(email)){
			throw new LeilaoException("Email invalido");						
		}
		
		usuario = new Usuario(cnpj_cpf, nome, email);
		
		return aux;
	}

	
}
