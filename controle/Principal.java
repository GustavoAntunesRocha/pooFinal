/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/
package controle;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JDialog;
import interfaceGrafica.JanelaLogin;

/**
 * Description of Principal.
 * 
 * @author Gustavo Antunes Rocha
 */
public class Principal {
	// Start of user code (user defined attributes for Principal)
	public static File u;
	public static File c;
	public static File p;
	public static File s;
	public static File f;
	public static ArrayList <Usuario> usuarioList = new ArrayList <Usuario> ();
	public static ArrayList <Cliente> clienteList = new ArrayList <Cliente> ();
	public static ArrayList <Produto> produtoList = new ArrayList <Produto> ();
	public static ArrayList <Servico> servicoList = new ArrayList <Servico> ();
	public static ArrayList <Funcionario> funcionarioList = new ArrayList <Funcionario> ();
	// End of user code
	
	/**
	 * Inicializa a aplicação
	 * @param args
	 */
	public static void main(String[] args) {
	    
		
		u = new File("Usuarios.bin");
		c = new File("Clientes.bin");
		p = new File("Produtos.bin");
		s = new File("Servicos.bin");
		f = new File("Funcionarios.bin");
		try {
			carregaArquivos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaLogin dialog = new JanelaLogin();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Start of user code (user defined methods for Principal)
	/**
	 * Descrição do método openStream
	 * @param file
	 * @return ObjectOutputStream
	 * @throws IOException
	 */
	public static ObjectOutputStream openStream(File f) throws IOException {
		ObjectOutputStream oos = null;
		try{
		if (f.exists()) {
			FileOutputStream fos = new FileOutputStream(f, true);
			oos = new AppendingObjectOutputStream(fos);
		} else {
			FileOutputStream fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
		}
		} catch(IOException e){
			System.out.println(e);
		}
		return oos;
	}
	
	/**
	 * Descrição do método carregaArquivos
	 * @throws IOException
	 */
	public static void carregaArquivos() throws IOException{
		if(u.exists()){
			Usuario usuario;
			try{
			FileInputStream fi = new FileInputStream(u);
			ObjectInputStream oi = new ObjectInputStream(fi);
			usuario = (Usuario) oi.readObject();
			usuarioList.add(usuario);
			while((usuario = (Usuario) oi.readObject()) != null){
				usuarioList.add(usuario);
				usuario = (Usuario) oi.readObject();
			}
			oi.close();
			fi.close();
			} catch (IOException | ClassNotFoundException e){
				System.out.println(e);
			} 	
		}
		else{
			try{
			Date data = new Date(System.currentTimeMillis());
			Usuario usuarioAdm = new Usuario("Administrador", "123", data);
			usuarioList.add(usuarioAdm);
			ObjectOutputStream oos;
			FileOutputStream fos = new FileOutputStream(u);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(usuarioAdm);
			oos.close();
			}catch (IOException e){
				System.out.println(e);
			}
		}
		if(c.exists()){
			Cliente cliente;
			try{
			FileInputStream fi = new FileInputStream(c);
			ObjectInputStream oi = new ObjectInputStream(fi);
			cliente = (Cliente) oi.readObject();
			clienteList.add(cliente);
			while((cliente = (Cliente) oi.readObject()) != null){
				clienteList.add(cliente);
				cliente = (Cliente) oi.readObject();
			}
			oi.close();
			fi.close();
			} catch (IOException | ClassNotFoundException e){
				System.out.println(e);
			} 	
		}
		if(p.exists()){
			Produto produto;
			try{
			FileInputStream fi = new FileInputStream(p);
			ObjectInputStream oi = new ObjectInputStream(fi);
			produto = (Produto) oi.readObject();
			produtoList.add(produto);
			while((produto = (Produto) oi.readObject()) != null){
				produtoList.add(produto);
				produto = (Produto) oi.readObject();
			}
			oi.close();
			} catch (IOException | ClassNotFoundException e){
				System.out.println(e);
			} 	
		}
		if(s.exists()){
			Servico servico;
			try{
			FileInputStream fi = new FileInputStream(s);
			ObjectInputStream oi = new ObjectInputStream(fi);
			servico = (Servico) oi.readObject();
			servicoList.add(servico);
			while((servico = (Servico) oi.readObject()) != null){
				servicoList.add(servico);
				servico = (Servico) oi.readObject();
			}
			oi.close();
			} catch (IOException | ClassNotFoundException e){
				System.out.println(e);
			} 	
		}
		if(f.exists()){
			Funcionario funcionario;
			try{
			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			funcionario = (Funcionario) oi.readObject();
			funcionarioList.add(funcionario);
			while((funcionario = (Funcionario) oi.readObject()) != null){
				funcionarioList.add(funcionario);
				funcionario = (Funcionario) oi.readObject();
			}
			oi.close();
			} catch (IOException | ClassNotFoundException e){
				System.out.println(e);
			} 	
		}
	}
	// End of user code

}
