/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package controle;

import controle.Produto;

import java.io.Serializable;
import java.util.Date;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Produto.
 * 
 * @author Gustavo Antunes Rocha
 */
public class Produto implements Serializable{
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
	private int id = 0;

	/**
	 * Description of the property dataCadastro.
	 */
	private Date dataCadastro = new Date();

	/**
	 * Description of the property quantidade.
	 */
	private int quantidade = 0;

	/**
	 * Description of the property valorCompra.
	 */
	private float valorCompra = 0F;

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

	// Start of user code (user defined attributes for Produto)

	// End of user code

	/**
	 * The constructor.
	 */
	public Produto(String nome, String tipo, int qtd, int id, float valorCompra, float valorVenda, Date data) {
		// Start of user code constructor for Produto)
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = qtd;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
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
	 * @return Produto
	 */
	public static Produto busca(String nome) {
		int i;
		for(i=0;i<Principal.produtoList.size();i++){
			if(Principal.produtoList.get(i).getNome().equals(nome)){
				return Principal.produtoList.get(i);
			}
		}
		return null;
	}

	/**
	 * Description of the method busca.
	 * @param id 
	 * @return Produto
	 */
	public static Produto busca(int id) {
		int i;
		for(i=0;i<Principal.produtoList.size();i++){
			if(Principal.produtoList.get(i).getId() == id){
				return Principal.produtoList.get(i);
			}
		}
		return null;
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
	 * Returns quantidade.
	 * @return quantidade 
	 */
	public Integer getQuantidade() {
		return this.quantidade;
	}

	/**
	 * Sets a value to attribute quantidade. 
	 * @param newQuantidade 
	 */
	public void setQuantidade(Integer newQuantidade) {
		this.quantidade = newQuantidade;
	}

	/**
	 * Returns valorCompra.
	 * @return valorCompra 
	 */
	public float getValorCompra() {
		return this.valorCompra;
	}

	/**
	 * Sets a value to attribute valorCompra. 
	 * @param newValorCompra 
	 */
	public void setValorCompra(float newValorCompra) {
		this.valorCompra = newValorCompra;
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

	/**
	 * Description of Usuario.
	 * 
	 * @author Gustavo Antunes Rocha
	 */
	public class Usuario {
		/**
		 * Description of the property nome.
		 */
		private String nome = "";

		/**
		 * Description of the property endereco.
		 */
		private String endereco = "";

		/**
		 * Description of the property cpf.
		 */
		private long cpf = 0L;

		/**
		 * Description of the property dataNascimento.
		 */
		private Date dataNascimento = new Date();

		/**
		 * Description of the property dataCadastro.
		 */
		private Date dataCadastro = new Date();

		// Start of user code (user defined attributes for Usuario)

		// End of user code

		/**
		 * The constructor.
		 */
		public Usuario() {
			// Start of user code constructor for Usuario)
			super();
			// End of user code
		}

		// Start of user code (user defined methods for Usuario)

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

}
