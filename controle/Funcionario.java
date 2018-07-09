package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
/**
 * Descrição de Funcionario
 * @author Gustavo Antunes Rocha
 *
 */
public class Funcionario extends Pessoa implements Serializable{
	
	public Funcionario(String nome, String sexo, long cpf, String endereco, Date dataNascimento, Date dataCadastro,
			int id, float salarioH, float horasTrabalhadas) {
		super(nome, sexo, cpf, endereco, dataNascimento, dataCadastro);
		this.salarioH = salarioH;
		this.horasTrabalhadas = horasTrabalhadas;
		this.salarioTotal = calcSalario();
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float salarioH;
	private float horasTrabalhadas;
	private float salarioTotal;
	private static float mediaSalarial;
	private int id;
	/**
	 * Descrição do método calcSalario
	 * @return salarioTotal
	 */
	public float calcSalario(){
		return this.salarioH * this.horasTrabalhadas;
	}
	
	/**
	 * Description of the method busca.
	 * @param nome 
	 * @return Funcionario
	 */
	public static Funcionario busca(String nome) {
		int i;
		for(i=0;i<Principal.funcionarioList.size();i++){
			if(Principal.funcionarioList.get(i).getNome().equals(nome)){
				return Principal.funcionarioList.get(i);
			}
		}
		return null;
	}

	/**
	 * Description of the method busca.
	 * @param id 
	 * @return Funcionario
	 */
	public static Funcionario busca(int id) {
		int i;
		for(i=0;i<Principal.funcionarioList.size();i++){
			if(Principal.funcionarioList.get(i).getId() == id){
				return Principal.funcionarioList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Descrição de calcMediaSalarial
	 * @param funcionarioList
	 */
	public static float calcMediaSalarial(ArrayList <Funcionario> funcionarioList){
		int i;
		Funcionario.mediaSalarial = 0F;
		float aux = 0F;
		for(i=0; i < funcionarioList.size(); i++){
			aux += funcionarioList.get(i).salarioTotal;
		}
		Funcionario.mediaSalarial = aux / funcionarioList.size();
		return Funcionario.mediaSalarial;
	}
	public int getId(){
		return this.id;
	}
	public float getSalarioTotal(){
		return this.salarioTotal;
	}
	public void setHorasTrabalhadas(float horasTrabalhadas){
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public float getHorasTrabalhadas(){
		return this.horasTrabalhadas;
	}
	public void setSalarioH(float salarioH){
		this.salarioH = salarioH;
	}
	public float getSalarioH(){
		return this.salarioH;
	}
	@Override
	public String getSexo() {
		// TODO Auto-generated method stub
		return this.sexo;
	}

	@Override
	public void setSexo(String newSexo) {
		// TODO Auto-generated method stub
		this.sexo = newSexo;
	}

	@Override
	public long getCpf() {
		// TODO Auto-generated method stub
		return this.cpf;
	}

	@Override
	public void setCpf(long newCpf) {
		// TODO Auto-generated method stub
		this.cpf = newCpf;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public void setNome(String newNome) {
		// TODO Auto-generated method stub
		this.nome = newNome;
	}

	@Override
	public Date getDataNascimento() {
		// TODO Auto-generated method stub
		return this.dataNascimento;
	}

	@Override
	public void setDataNascimento(Date newDataNascimento) {
		// TODO Auto-generated method stub
		this.dataNascimento = newDataNascimento;
	}

	@Override
	public String getEndereco() {
		// TODO Auto-generated method stub
		return this.endereco;
	}

	@Override
	public void setEndereco(String newEndereco) {
		// TODO Auto-generated method stub
		this.endereco = newEndereco;
	}

	@Override
	public Date getDataCadastro() {
		// TODO Auto-generated method stub
		return this.dataCadastro;
	}

	@Override
	public void setDataCadastro(Date newDataCadastro) {
		// TODO Auto-generated method stub
		this.dataCadastro = newDataCadastro;
	}

}
