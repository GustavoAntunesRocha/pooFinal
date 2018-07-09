package interfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controle.Produto;
import controle.CampoInvalidoException;
import controle.Principal;
/**
 * Descrição de JanelaPesquisaProduto.
 * 
 * @author Gustavo Antunes Rocha
 */
public class JanelaPesquisaProduto extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldID;
	private JTextField textFieldNomeCompleto;
	private JLabel lblValores;
	private JTextField textFieldCompra;
	private JLabel lblDataDeCadastro;
	private JTextField textFieldQuantidade;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	JButton btnPesquisar;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;
	UtilDateModel model;
	private Produto produtoPesquisa;
	private JLabel lblTipo;
	private JTextField textFieldTipo;
	private JLabel lblCompra;
	private JTextField textFieldVenda;
	private JTextField textFieldId;
	
	/**
	 * Create the frame.
	 * 
	 */
	public JanelaPesquisaProduto() {
		setTitle("Pesquisa de Produtos");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 547, 385);
		contentPane = new JPanel();
		JScrollPane scrollPane = new JScrollPane(contentPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(scrollPane);
		contentPane.setLayout(new MigLayout("", "[200px,grow][300px,grow]", "[grow]"));
		
		JPanel panelPesquisa = new JPanel();
		panelPesquisa.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(panelPesquisa, "cell 0 0,grow");
		panelPesquisa.setLayout(new MigLayout("", "[grow]", "[30px][30px][30px]"));
		
		JLabel lblNome = new JLabel("Nome:");
		panelPesquisa.add(lblNome, "flowx,cell 0 0,alignx left");
		
		textFieldNome = new JTextField();
		panelPesquisa.add(textFieldNome, "cell 0 0,growx");
		textFieldNome.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		panelPesquisa.add(lblId, "flowx,cell 0 1");
		
		textFieldID = new JTextField();
		panelPesquisa.add(textFieldID, "cell 0 1");
		textFieldID.setColumns(10);
		
		btnPesquisar = new JButton("Pesquisar");
		panelPesquisa.add(btnPesquisar, "cell 0 2,alignx center");
		
		JPanel panelResultado = new JPanel();
		panelResultado.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(panelResultado, "cell 1 0,grow");
		panelResultado.setLayout(new MigLayout("", "[70px,grow,left]", "[20px][30px][20px][30px][20px][30px][][][30px][30px]"));
		JLabel lblNomeCompleto = new JLabel("Nome:");
		panelResultado.add(lblNomeCompleto, "flowx,cell 0 0");
		
		textFieldNomeCompleto = new JTextField();
		textFieldNomeCompleto.setEditable(false);
		panelResultado.add(textFieldNomeCompleto, "cell 0 1,growx");
		textFieldNomeCompleto.setColumns(10);
		
		lblTipo = new JLabel("Tipo:");
		panelResultado.add(lblTipo, "cell 0 2");
		
		textFieldTipo = new JTextField();
		textFieldTipo.setEditable(false);
		panelResultado.add(textFieldTipo, "cell 0 3,growx");
		textFieldTipo.setColumns(10);
		
		lblValores = new JLabel("Valores:");
		panelResultado.add(lblValores, "cell 0 4");
		
		lblCompra = new JLabel("Compra:");
		panelResultado.add(lblCompra, "flowx,cell 0 5");
		textFieldCompra = new JTextField();
		textFieldCompra.setEditable(false);
		
		panelResultado.add(textFieldCompra, "cell 0 5");
		textFieldCompra.setColumns(10);
		
		model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		lblDataDeCadastro = new JLabel("Data de cadastro:");
		panelResultado.add(lblDataDeCadastro, "cell 0 6");
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		panelResultado.add(datePicker, "cell 0 6,alignx left,aligny center");
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		panelResultado.add(lblQuantidade, "flowx,cell 0 8");
		textFieldQuantidade = new JTextField();
		textFieldQuantidade.setEditable(false);
		panelResultado.add(textFieldQuantidade, "cell 0 8");
		textFieldQuantidade.setColumns(10);
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		panelResultado.add(btnSalvar, "flowx,cell 0 9");
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		panelResultado.add(btnAlterar, "cell 0 9");
		btnCancelar = new JButton("Cancelar");
		panelResultado.add(btnCancelar, "cell 0 9");
		
		JLabel lblVenda = new JLabel("Venda:");
		panelResultado.add(lblVenda, "cell 0 5");
		
		textFieldVenda = new JTextField();
		textFieldVenda.setEditable(false);
		panelResultado.add(textFieldVenda, "cell 0 5");
		textFieldVenda.setColumns(10);
		
		JLabel lblIdID = new JLabel("ID:");
		panelResultado.add(lblIdID, "cell 0 8");
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		panelResultado.add(textFieldId, "cell 0 8");
		textFieldId.setColumns(10);
		
		btnSalvar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnPesquisar.addActionListener(this);
	}
	
	/**
	 * Descrição do método pesquisar
	 * @return Produto
	 */
	private Produto pesquisar(){
		Produto produto = null;
		if(!textFieldNome.getText().equals("")){
			produto = Produto.busca(textFieldNome.getText());
		}
		else if(!textFieldID.getText().equals("")){
			produto = Produto.busca(Integer.parseInt(textFieldID.getText()));
		}
		if(produto == null){
			return null;
		}
		textFieldNomeCompleto.setText(produto.getNome());
		textFieldTipo.setText(produto.getTipo());
		textFieldVenda.setText(String.valueOf(produto.getValorVenda()));
		textFieldCompra.setText(String.valueOf(produto.getValorCompra()));
		model.setValue(produto.getDataCadastro());
		model.setSelected(true);
		textFieldQuantidade.setText(String.valueOf(produto.getQuantidade()));
		textFieldId.setText(String.valueOf(produto.getId()));
		return produto;
	}
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource() == btnPesquisar){
				produtoPesquisa = pesquisar();
				if(produtoPesquisa != null){
					btnAlterar.setEnabled(true);
				}
				else{
					JOptionPane.showMessageDialog(this, "Produto não encontrado!");
				}
				
			}
			if (evento.getSource() == btnAlterar){
				btnSalvar.setEnabled(true);
				textFieldNomeCompleto.setEditable(true);
				textFieldTipo.setEditable(true);
				textFieldVenda.setEditable(true);
				textFieldCompra.setEditable(true);
				textFieldQuantidade.setEditable(true);
				btnSalvar.setEnabled(true);
			}
			if(evento.getSource() == btnCancelar){
				this.dispose();
			}
			if(evento.getSource() == btnSalvar){
				boolean cond = true;
				try{
					if(!Produto.ehNumero(textFieldQuantidade.getText() ) ){
						throw new CampoInvalidoException();
					}
					if(!Produto.ehNumero(textFieldCompra.getText() ) ){
						throw new CampoInvalidoException();
					}
					if(!Produto.ehNumero(textFieldVenda.getText() ) ){
						throw new CampoInvalidoException();
					}
					String nome = textFieldNomeCompleto.getText();
					String tipo = textFieldCompra.getText();
					float venda = Float.parseFloat(textFieldVenda.getText());
					float compra = Float.parseFloat(textFieldCompra.getText());
					int qtd = Integer.parseInt(textFieldQuantidade.getText());
					int index = Principal.produtoList.indexOf(produtoPesquisa);
					Produto produto = new Produto(nome, tipo, qtd, produtoPesquisa.getId(), compra, venda, produtoPesquisa.getDataCadastro());
					Principal.produtoList.set(index, produto);
					Principal.p.delete();
					Principal.p = new File("Produtos.bin"); 
					ObjectOutputStream oos;
					oos = Principal.openStream(Principal.p);
					for(int i = 0;i < Principal.produtoList.size();i++){
						oos.writeObject(Principal.produtoList.get(i));
					}
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (CampoInvalidoException e){
					JOptionPane.showMessageDialog(null, "Nos campos de Quantidade, Venda e Compra,\nutilizar somente numeros e ponto!",
							"Campo invalido",JOptionPane.ERROR_MESSAGE);
					cond = false;
				}finally{
					if(cond){
						this.dispose();
					}
					
				}
			}
		}
}
