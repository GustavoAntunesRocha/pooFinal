package interfaceGrafica;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.CampoInvalidoException;
import controle.Principal;
import controle.Produto;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import java.awt.Color;

public class JanelaCadastroProduto extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldTipo;
	private JTextField textFieldQuantidade;
	private JTextField textFieldCompra;
	private JTextField textFieldVenda;
	private JButton btnSalvar;
	private JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public JanelaCadastroProduto() {
		setTitle("Cadastro de Produtos");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 376, 351);
		contentPane = new JPanel();
		JScrollPane scrollPane = new JScrollPane(contentPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(scrollPane);
		contentPane.setLayout(new MigLayout("", "[70px,grow,left]", "[20px][30px][20px][30px][20px][][20px][][][30px][30px]"));
		
		JLabel lblNome = new JLabel("Nome:");
		contentPane.add(lblNome, "cell 0 0");
		
		textFieldNome = new JTextField();
		contentPane.add(textFieldNome, "cell 0 1,growx");
		textFieldNome.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		contentPane.add(lblTipo, "cell 0 2");
		
		textFieldTipo = new JTextField();
		contentPane.add(textFieldTipo, "cell 0 3,growx");
		textFieldTipo.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		contentPane.add(lblQuantidade, "flowx,cell 0 4");
		
		textFieldQuantidade = new JTextField();
		contentPane.add(textFieldQuantidade, "cell 0 4");
		textFieldQuantidade.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		contentPane.add(separator, "cell 0 5,growx");
		
		JLabel lblValores = new JLabel("Valores:");
		contentPane.add(lblValores, "cell 0 6");
		
		JLabel lblCompra = new JLabel("Compra:");
		contentPane.add(lblCompra, "flowx,cell 0 7");
		
		textFieldCompra = new JTextField();
		contentPane.add(textFieldCompra, "cell 0 7");
		textFieldCompra.setColumns(10);
		
		JLabel lblVenda = new JLabel("Venda:");
		contentPane.add(lblVenda, "cell 0 7");
		
		textFieldVenda = new JTextField();
		contentPane.add(textFieldVenda, "cell 0 7");
		textFieldVenda.setColumns(10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.LIGHT_GRAY);
		contentPane.add(separator_3, "cell 0 8,growx");
		
		btnSalvar = new JButton("Salvar");
		contentPane.add(btnSalvar, "flowx,cell 0 10");
		
		btnCancelar = new JButton("Cancelar");
		contentPane.add(btnCancelar, "cell 0 10");
		
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
		
	}
	
		@Override
		public void actionPerformed(ActionEvent evento) {
			boolean cond = true;
			if (evento.getSource() == btnSalvar) {
				try {
					if(!Produto.ehNumero(textFieldQuantidade.getText() ) ){
						throw new CampoInvalidoException();
					}
					if(!Produto.ehNumero(textFieldCompra.getText() ) ){
						throw new CampoInvalidoException();
					}
					if(!Produto.ehNumero(textFieldVenda.getText() ) ){
						throw new CampoInvalidoException();
					}
					String nome = textFieldNome.getText();
					String tipo = textFieldTipo.getText();
					int qtd = Integer.parseInt(textFieldQuantidade.getText());
					float compra = Float.parseFloat(textFieldCompra.getText());
					float venda = Float.parseFloat(textFieldVenda.getText());
					
					Date dataC = new Date(System.currentTimeMillis());
					int id = Principal.produtoList.size();
					Produto produto = new Produto(nome, tipo, qtd, id, compra, venda, dataC);
					Principal.produtoList.add(produto);
					ObjectOutputStream oos;
				
					oos = Principal.openStream(Principal.p);
					oos.writeObject(produto);
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CampoInvalidoException e){
					JOptionPane.showMessageDialog(null, "Nos campos de Quantidade, Venda e Compra,\nutilizar somente numeros e ponto!",
							"Campo invalido",JOptionPane.ERROR_MESSAGE);
					cond = false;
				}finally{
					if(cond){
						this.dispose();
					}
					
				}
				
			}
			if(evento.getSource() == btnCancelar){
				this.dispose();
			}
		}

	
}
