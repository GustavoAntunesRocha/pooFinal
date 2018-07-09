/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package controle;

import java.io.Serializable;
import java.util.Date;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Pessoa.
 * 
 * @author Gustavo Antunes Rocha
 */
public abstract class Pessoa implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property sexo.
	 */
	protected String sexo;

	/**
	 * Description of the property cpf.
	 */
	protected long cpf;

	/**
	 * Description of the property nome.
	 */
	protected String nome;

	/**
	 * Description of the property dataNascimento.
	 */
	protected Date dataNascimento;

	/**
	 * Description of the property endereco.
	 */
	protected String endereco;

	/**
	 * Description of the property dataCadastro.
	 */
	protected Date dataCadastro;

	// Start of user code (user defined attributes for Pessoa)

	// End of user code

	/**
	 * The constructor.
	 */
	public Pessoa(String nome, String sexo, long cpf, String endereco, Date dataNascimento, Date dataCadastro) {
		// Start of user code constructor for Pessoa)
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		// End of user code
	}

	// Start of user code (user defined methods for Pessoa)

	// End of user code
	/**
	 * Returns sexo.
	 * @return sexo 
	 */
	public abstract String getSexo();
	

	/**
	 * Sets a value to attribute sexo. 
	 * @param newSexo 
	 */
	public abstract void setSexo(String newSexo);

	/**
	 * Returns cpf.
	 * @return cpf 
	 */
	public abstract long getCpf();

	/**
	 * Sets a value to attribute cpf. 
	 * @param newCpf 
	 */
	public abstract void setCpf(long newCpf);

	/**
	 * Returns nome.
	 * @return nome 
	 */
	public abstract String getNome();

	/**
	 * Sets a value to attribute nome. 
	 * @param newNome 
	 */
	public abstract void setNome(String newNome);

	/**
	 * Returns dataNascimento.
	 * @return dataNascimento 
	 */
	public abstract Date getDataNascimento();

	/**
	 * Sets a value to attribute dataNascimento. 
	 * @param newDataNascimento 
	 */
	public abstract void setDataNascimento(Date newDataNascimento);

	/**
	 * Returns endereco.
	 * @return endereco 
	 */
	public abstract String getEndereco();

	/**
	 * Sets a value to attribute endereco. 
	 * @param newEndereco 
	 */
	public abstract void setEndereco(String newEndereco);

	/**
	 * Returns dataCadastro.
	 * @return dataCadastro 
	 */
	public abstract Date getDataCadastro();

	/**
	 * Sets a value to attribute dataCadastro. 
	 * @param newDataCadastro 
	 */
	public abstract void setDataCadastro(Date newDataCadastro);

}
