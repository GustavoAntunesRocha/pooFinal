package interfaceGrafica;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controle.Principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;

public class JanelaLista extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();;
	private JComboBox comboBox;
	private JButton btnListar;

	/**
	 * Create the dialog.
	 */
	public JanelaLista() {
		setTitle("Listagem");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[100px][300px,grow]", "[grow]"));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(panel, "cell 0 0,alignx center,growy");
			{
				String[] opcoes = {"Clientes","Produtos","Serviços","Usuários"};
				panel.setLayout(new MigLayout("", "[68px]", "[20px][20px]"));
				comboBox = new JComboBox(opcoes);
				comboBox.setModel(new DefaultComboBoxModel(new String[] {"Clientes", "Produtos", "Servi\u00E7os", "Usu\u00E1rios", "Funcion\u00E1rios"}));
				panel.add(comboBox, "cell 0 0,alignx left,aligny top");
			}
			{
				btnListar = new JButton("Listar");
				panel.add(btnListar, "cell 0 1");
				btnListar.addActionListener(this);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			contentPanel.add(panel, "cell 1 0,grow");
			{
				
				table = new JTable(modelo);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table = new JTable(modelo);
				modelo.addColumn("Id");
				modelo.addColumn("Nome");
				//modelo.addColumn("Sexo");
				//modelo.addColumn("CPF");
				table.getColumnModel().getColumn(0).setPreferredWidth(10);
				table.getColumnModel().getColumn(1).setPreferredWidth(120);
				panel.setLayout(new GridLayout(0, 1, 0, 0));
				panel.add(table);
			}
		}
	}
	
	/**
	 * Descrição método pesquisarCliente
	 * @param modelo
	 */
	public static void pesquisarCliente(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		int i;
		for (i=0; i <= Principal.clienteList.size(); i++) {
			modelo.addRow(new Object[]{Principal.clienteList.get(i).getId(), 
					Principal.clienteList.get(i).getNome(), 
					//Principal.clienteList.get(i).getSexo(), 
					//Principal.clienteList.get(i).getCpf()
					});
		}
	}
	/**
	 * Descrição método pesquisarFuncionario 
	 * @param modelo
	 */
	public static void pesquisarFuncionario(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		int i;
		for (i=0; i <= Principal.funcionarioList.size(); i++) {
			modelo.addRow(new Object[]{Principal.funcionarioList.get(i).getId(), 
					Principal.funcionarioList.get(i).getNome(), 
					//Principal.clienteList.get(i).getSexo(), 
					//Principal.clienteList.get(i).getCpf()
					});
		}
	}
	
	/**
	 * Descrição método pesquisarServico
	 * @param modelo
	 */
	public static void pesquisarServico(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		int i;
		for (i=0; i <= Principal.servicoList.size(); i++) {
			modelo.addRow(new Object[]{Principal.servicoList.get(i).getId(), 
					Principal.servicoList.get(i).getNome(), 
					//Principal.servicoList.get(i).getSexo(), 
					//Principal.servicoList.get(i).getCpf()
					});
		}
	}
	
	/**
	 * Descrição método pesquisarUsuario
	 * @param modelo
	 */
	public static void pesquisarUsuario(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		int i;
		for (i=0; i <= Principal.usuarioList.size(); i++) {
			modelo.addRow(new Object[]{Principal.usuarioList.get(i).getNomeUsuario(), 
					//Principal.usuarioList.get(i).getNome(), 
					//Principal.servicoList.get(i).getSexo(), 
					//Principal.servicoList.get(i).getCpf()
					});
		}
	}
	
	/**
	 * Descrição método pesquisarProduto
	 * @param modelo
	 */
	public static void pesquisarProduto(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		int i;
		for (i=0; i <= Principal.produtoList.size(); i++) {
			modelo.addRow(new Object[]{Principal.produtoList.get(i).getId(), 
					Principal.produtoList.get(i).getNome(), 
					//Principal.produtoList.get(i).getSexo(), 
					//Principal.produtoList.get(i).getCpf()
					});
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnListar){
			if(comboBox.getSelectedIndex() == 0){
				pesquisarCliente(modelo);
			}
			if(comboBox.getSelectedIndex() == 1){
				pesquisarProduto(modelo);
			}
			if(comboBox.getSelectedIndex() == 2){
				pesquisarServico(modelo);
			}
			if(comboBox.getSelectedIndex() == 3){
				pesquisarUsuario(modelo);
			}
			if(comboBox.getSelectedIndex() == 4){
				pesquisarFuncionario(modelo);
			}
		}
	}

}
