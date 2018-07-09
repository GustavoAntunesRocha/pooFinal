package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Descrição de JanelaPrincipal
 * @author Gustavo Antunes Rocha
 *
 */
public class JanelaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JanelaPrincipal instance;
	private JPanel contentPane;
	private JMenuItem mntmClientesCadastro;
	private JMenuBar menuBar;
	private JMenu mnAcesso;
	private JMenuItem mntmSair;
	private JMenuItem mntmProdutosCadastro;
	private JMenuItem mntmServiosCadastro;
	private JMenuItem mntmUsuariosCadastro;
	private JMenuItem mntmClientesPesquisa;
	private JMenuItem mntmProdutosPesquisa;
	private JMenuItem mntmServiosPesquisa;
	private JMenuItem mntmUsuriosPesquisa;
	private JMenu mnListagem;
	private JMenuItem mntmItens;
	private JMenuItem mntmFuncionrios;
	/**
	 * Launch the application.
	 */
	
	public static JanelaPrincipal getInstance(){
		if(instance==null){
        	instance = new JanelaPrincipal();        
            return instance;
        }
        return instance;
	}
	/**
	 * Create the frame.
	 */
	private JanelaPrincipal() {
		setTitle("Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnAcesso = new JMenu("Acesso");
		menuBar.add(mnAcesso);

		mntmSair = new JMenuItem("Sair");
		mnAcesso.add(mntmSair);

		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);

		mntmClientesCadastro = new JMenuItem("Clientes");
		mnCadastro.add(mntmClientesCadastro);

		mntmProdutosCadastro = new JMenuItem("Produtos");
		mnCadastro.add(mntmProdutosCadastro);

		mntmServiosCadastro = new JMenuItem("Servi\u00E7os");
		mnCadastro.add(mntmServiosCadastro);

		mntmUsuariosCadastro = new JMenuItem("Usu\u00E1rios");
		mnCadastro.add(mntmUsuariosCadastro);
		
		mntmFuncionrios = new JMenuItem("Funcion\u00E1rios");
		mnCadastro.add(mntmFuncionrios);

		JMenu mnPesquisas = new JMenu("Pesquisas");
		menuBar.add(mnPesquisas);

		mntmClientesPesquisa = new JMenuItem("Clientes");
		mnPesquisas.add(mntmClientesPesquisa);

		mntmProdutosPesquisa = new JMenuItem("Produtos");
		mnPesquisas.add(mntmProdutosPesquisa);

		mntmServiosPesquisa = new JMenuItem("Servi\u00E7os");
		mnPesquisas.add(mntmServiosPesquisa);

		mntmUsuriosPesquisa = new JMenuItem("Usu\u00E1rios");
		mnPesquisas.add(mntmUsuriosPesquisa);
		
		mnListagem = new JMenu("Listagem");
		menuBar.add(mnListagem);
		
		mntmItens = new JMenuItem("Itens");
		mnListagem.add(mntmItens);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		TrataEvento trata = new TrataEvento();
		mntmClientesCadastro.addActionListener(trata);
		mntmProdutosCadastro.addActionListener(trata);
		mntmServiosCadastro.addActionListener(trata);
		mntmUsuariosCadastro.addActionListener(trata);
		mntmClientesPesquisa.addActionListener(trata);
		mntmItens.addActionListener(trata);
		mntmSair.addActionListener(trata);
		mntmFuncionrios.addActionListener(trata);
	}
	
	private class TrataEvento implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource() == mntmClientesCadastro){
				try {
					JanelaCadastroCliente frame = new JanelaCadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(evento.getSource() == mntmProdutosCadastro){
				try {
					JanelaCadastroProduto frame = new JanelaCadastroProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(evento.getSource() == mntmServiosCadastro){
				try {
					JanelaCadastroServico frame = new JanelaCadastroServico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(evento.getSource() == mntmUsuariosCadastro){
				try {
					JanelaCadastroUsuario frame = new JanelaCadastroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(evento.getSource() == mntmClientesPesquisa){
				try{
					JanelaPesquisaCliente frame = new JanelaPesquisaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(evento.getSource() == mntmItens){
				try{
					JanelaLista frame = new JanelaLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(evento.getSource() == mntmSair){
				System.exit(0);
			}
			if(evento.getSource() == mntmFuncionrios){
				try{
					JanelaCadastroFuncionario frame = new JanelaCadastroFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
