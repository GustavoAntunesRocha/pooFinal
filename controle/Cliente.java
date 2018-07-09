/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package controle;

import java.io.Serializable;
import java.util.Date;

import controle.Cliente;
import controle.Pessoa;
// Start of user code (user defined imports)

// End of user code

/**
 * Descrição de Cliente.
 * 
 * @author Gustavo Antunes Rocha
 */
public class Cliente extends Pessoa implements Serializable{
	
	/**
	 * O construtor.
	 */
	public Cliente(String nome, String sexo, long cpf, String endereco, Date dataNascimento, Date dataCadastro, int id) {
		super(nome, sexo, cpf, endereco, dataNascimento, dataCadastro);
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Description of the property id.
	 */
	private int id;
	
	/**
	 * Descrição do método busca.
	 * @param nome 
	 * @return Cliente
	 */
	public static Cliente busca(String nome) {
		// Start of user code for method busca
		int i;
		for(i=0;i<Principal.clienteList.size();i++){
			if(Principal.clienteList.get(i).getNome().equals(nome)){
				return Principal.clienteList.get(i);
			}
		}
		return null;
		// End of user code
	}
	
	/**
	 * Descrição do método statico ehNumero
	 * @param string
	 * @return boolean
	 */
	public static boolean ehNumero(String string){
		if(string.matches("^[0-9]*[.]{0,1}[0-9]*$")){
			return true;
		}
		return false;
	}
	
	/**
	 * Descrição do método busca.
	 * @param id 
	 * @return Cliente
	 */
	public static Cliente busca(int id) {
		// Start of user code for method busca
		int i;
		for(i=0;i<Principal.clienteList.size();i++){
			if(Principal.clienteList.get(i).getId() == id){
				return Principal.clienteList.get(i);
			}
		}
		return null;
		// End of user code
	}

	// Start of user code (user defined methods for Cliente)

	// End of user code
	/**
	 * Returns id.
	 * @return id 
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets a value to attribute id. 
	 * @param newId 
	 */
	public void setId(int newId) {
		this.id = newId;
	}
	/**
	 * Returns sexo.
	 * @return sexo 
	 */
	public String getSexo() {
		return this.sexo;
	}

	/**
	 * Sets a value to attribute sexo. 
	 * @param newSexo 
	 */
	public void setSexo(String newSexo) {
		this.sexo = newSexo;
	}

	/**
	 * Returns cpf.
	 * @return cpf 
	 */
	public long getCpf() {
		return this.cpf;
	}

	/**
	 * Sets a value to attribute cpf. 
	 * @param newCpf 
	 */
	public void setCpf(long newCpf) {
		this.cpf = newCpf;
	}

	/**
	 * Returns nome.
	 * @return nome 
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Sets a value to attribute nome. 
	 * @param newNome 
	 */
	public void setNome(String newNome) {
		this.nome = newNome;
	}

	/**
	 * Returns dataNascimento.
	 * @return dataNascimento 
	 */
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	/**
	 * Sets a value to attribute dataNascimento. 
	 * @param newDataNascimento 
	 */
	public void setDataNascimento(Date newDataNascimento) {
		this.dataNascimento = newDataNascimento;
	}

	/**
	 * Returns endereco.
	 * @return endereco 
	 */
	public String getEndereco() {
		return this.endereco;
	}

	/**
	 * Sets a value to attribute endereco. 
	 * @param newEndereco 
	 */
	public void setEndereco(String newEndereco) {
		this.endereco = newEndereco;
	}

	/**
	 * Returns dataCadastro.
	 * @return dataCadastro 
	 */
	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	/**
	 * Sets a value to attribute dataCadastro. 
	 * @param newDataCadastro 
	 */
	public void setDataCadastro(Date newDataCadastro) {
		this.dataCadastro = newDataCadastro;
	}
}
