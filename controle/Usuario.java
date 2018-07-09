/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package controle;

import java.io.Serializable;
import java.util.Date;

// Start of user code (user defined imports)

// End of user code

/**
 * Descri��o de Usuario.
 * 
 * @author Gustavo Antunes Rocha
 */
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Descri��o da propriedade senha.
	 */
	private String senha;

	/**
	 * Descri��o da propriedade nomeUsuario.
	 */
	private String nomeUsuario;
	
	/**
	 * Descri��o da propriedade dataCadastro
	 */
	private Date dataCadastro;

	// Start of user code (user defined attributes for Usuario)

	// End of user code

	/**
	 * O construtor.
	 * @param nomeUsuario 
	 * @param senha 
	 */
	public Usuario(String nomeUsuario, String senha, Date dataCadastro) {
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
	}

	/**
	 * Descri��o do m�todo busca.
	 * @param nome 
	 * @return Usuario
	 */
	public static Usuario busca(String nome) {
		int i;
		for(i=0;i<Principal.usuarioList.size();i++){
			if(Principal.usuarioList.get(i).getNomeUsuario().equals(nome)){
				return Principal.usuarioList.get(i);
			}
		}
		return null;
	}

	
	/**
	 * Returns senha.
	 * @return senha 
	 */
	public String getSenha() {
		return this.senha;
	}

	/**
	 * Sets a value to attribute senha. 
	 * @param newSenha 
	 */
	public void setSenha(String newSenha) {
		this.senha = newSenha;
	}

	/**
	 * Returns nomeUsuario.
	 * @return nomeUsuario 
	 */
	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	/**
	 * Sets a value to attribute nomeUsuario. 
	 * @param newNomeUsuario 
	 */
	public void setNomeUsuario(String newNomeUsuario) {
		this.nomeUsuario = newNomeUsuario;
	}
	
	/**
	 * Atribui um valor ao atributo dataCadastro.
	 * @param dataCadastro
	 */
	public void setDataCadastro(Date dataCadastro){
		this.dataCadastro = dataCadastro;
	}
	
	/**
	 * Retorna dataCadastro
	 * @return dataCadastro
	 */
	public Date getDataCadastro(){
		return this.dataCadastro;
	}
}
