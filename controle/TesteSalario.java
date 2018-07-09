package controle;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TesteSalario{

	@Test
	public void testSalarioTotal() {
		Funcionario funcionario = new Funcionario("Joao","Masculino",123123,"rua 3",null,null,2,10,20);
		assertEquals(200, funcionario.calcSalario(),0);
	}
	
	@Test
	public void testMedia(){
		Funcionario funcionario = new Funcionario("Joao","Masculino",123123,"rua 3",null,null,4,2,2);
		Funcionario funcionario2 = new Funcionario("Joao","Masculino",123123,"rua 3",null,null,5,3,3);
		ArrayList <Funcionario> funcionarioList = new ArrayList <Funcionario> ();
		funcionarioList.add(funcionario);
		funcionarioList.add(funcionario2);
		assertEquals(6.5, Funcionario.calcMediaSalarial(funcionarioList),0);
	}

}
