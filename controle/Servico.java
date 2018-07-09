/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package controle;

import controle.Servico;

import java.io.Serializable;
import java.util.Date;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Servico.
 * 
 * @author Gustavo Antunes Rocha
 */
public class Servico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Description of the property nome.
	 */
	private String nome = "";

	/**
	 * Description of the property id.
	 */
	private Integer id = Integer.valueOf(0);

	/**
	 * Description of the property dataCadastro.
	 */
	private Date dataCadastro = new Date();

	/**
	 * Description of the property valorVenda.
	 */
	private float valorVenda = 0F;

	/**
	 * Description of the property custo.
	 */
	private float custo = 0F;

	/**
	 * Description of the property tipo.
	 */
	private String tipo = "";

	/**
	 * The constructor.
	 */
	public Servico(String nome, String tipo, float venda, float custo, int id, Date data) {
		// Start of user code constructor for Servico)
		this.nome = nome;
		this.tipo = tipo;
		this.valorVenda = venda;
		this.custo = custo;
		this.id = id;
		this.dataCadastro = data;
		// End of user code
	}
	
	/**
	 * Descrição do método ehNumero
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
	 * Description of the method busca.
	 * @param nome 
	 * @return Servico
	 */
	public static Servico busca(String nome) {
		int i;
		for(i=0;i<Principal.servicoList.size();i++){
			if(Principal.servicoList.get(i).getNome().equals(nome)){
				return Principal.servicoList.get(i);
			}
		}
		return null;
	}

	/**
	 * Description of the method busca.
	 * @param id 
	 * @return Servico
	 */
	public static Servico busca(Integer id) {
		int i;
		for(i=0;i<Principal.servicoList.size();i++){
			if(Principal.servicoList.get(i).getId() == id){
				return Principal.servicoList.get(i);
			}
		}
		return null;
	}

	// Start of user code (user defined methods for Servico)

	// End of user code
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
	 * Returns id.
	 * @return id 
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Sets a value to attribute id. 
	 * @param newId 
	 */
	public void setId(Integer newId) {
		this.id = newId;
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

	/**
	 * Returns valorVenda.
	 * @return valorVenda 
	 */
	public float getValorVenda() {
		return this.valorVenda;
	}

	/**
	 * Sets a value to attribute valorVenda. 
	 * @param newValorVenda 
	 */
	public void setValorVenda(float newValorVenda) {
		this.valorVenda = newValorVenda;
	}

	/**
	 * Returns custo.
	 * @return custo 
	 */
	public float getCusto() {
		return this.custo;
	}

	/**
	 * Sets a value to attribute custo. 
	 * @param newCusto 
	 */
	public void setCusto(float newCusto) {
		this.custo = newCusto;
	}

	/**
	 * Returns tipo.
	 * @return tipo 
	 */
	public String getTipo() {
		return this.tipo;
	}

	/**
	 * Sets a value to attribute tipo. 
	 * @param newTipo 
	 */
	public void setTipo(String newTipo) {
		this.tipo = newTipo;
	}

}
