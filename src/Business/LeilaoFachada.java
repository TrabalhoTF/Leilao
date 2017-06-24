package Business;

import Persistence.LeilaoDAOException;

public class LeilaoFachada { 
	
	private LeilaoDAOException leilaoDao; 
	private Usuario usuario;
	
	public LeilaoFachada() throws LeilaoException {		
				
        LeilaoDAOException ld = new LeilaoDAOException();
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
