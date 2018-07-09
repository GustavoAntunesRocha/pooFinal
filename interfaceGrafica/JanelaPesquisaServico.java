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

import controle.Servico;
import controle.CampoInvalidoException;
import controle.Principal;

/**
 * Descrição de JanelaPesquisaServico.
 * 
 * @author Gustavo Antunes Rocha
 */
public class JanelaPesquisaServico extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldID;
	private JTextField textFieldNomeCompleto;
	private JLabel lblValores;
	private JTextField textFieldCusto;
	private JLabel lblDataDeCadastro;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	JButton btnPesquisar;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;
	UtilDateModel model;
	private Servico servicoPesquisa;
	private JLabel lblTipo;
	private JTextField textFieldTipo;
	private JLabel lblCusto;
	private JTextField textFieldVenda;
	private JTextField textFieldId;
	
	/**
	 * Create the frame.
	 * 
	 */
	public JanelaPesquisaServico() {
		setTitle("Pesquisa de Servi\u00E7os");
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
		panelResultado.setLayout(new MigLayout("", "[70px,grow,left]", "[20px][30px][20px][30px][20px][30px][][30px][30px]"));
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
		
		lblCusto = new JLabel("Custo:");
		panelResultado.add(lblCusto, "flowx,cell 0 5");
		textFieldCusto = new JTextField();
		textFieldCusto.setEditable(false);
		
		panelResultado.add(textFieldCusto, "cell 0 5");
		textFieldCusto.setColumns(10);
		
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
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		panelResultado.add(btnSalvar, "flowx,cell 0 8");
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		panelResultado.add(btnAlterar, "cell 0 8");
		btnCancelar = new JButton("Cancelar");
		panelResultado.add(btnCancelar, "cell 0 8");
		
		JLabel lblVenda = new JLabel("Venda:");
		panelResultado.add(lblVenda, "cell 0 5");
		
		textFieldVenda = new JTextField();
		textFieldVenda.setEditable(false);
		panelResultado.add(textFieldVenda, "cell 0 5");
		textFieldVenda.setColumns(10);
		
		JLabel lblIdID = new JLabel("ID:");
		panelResultado.add(lblIdID, "flowx,cell 0 7");
		
		textFieldId = new JTextField();
		textFieldId.setEditable(false);
		panelResultado.add(textFieldId, "cell 0 7");
		textFieldId.setColumns(10);
		
		btnSalvar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnPesquisar.addActionListener(this);
	}
	
	/**
	 * Descrição do método pesquisar
	 * @return Servico
	 */
	private Servico pesquisar(){
		Servico servico = null;
		if(!textFieldNome.getText().equals("")){
			servico = Servico.busca(textFieldNome.getText());
		}
		else if(!textFieldID.getText().equals("")){
			servico = Servico.busca(Integer.parseInt(textFieldID.getText()));
		}
		if(servico == null){
			return null;
		}
		textFieldNomeCompleto.setText(servico.getNome());
		textFieldTipo.setText(servico.getTipo());
		textFieldVenda.setText(String.valueOf(servico.getValorVenda()));
		textFieldCusto.setText(String.valueOf(servico.getCusto()));
		model.setValue(servico.getDataCadastro());
		model.setSelected(true);
		textFieldId.setText(String.valueOf(servico.getId()));
		return servico;
	}
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource() == btnPesquisar){
				servicoPesquisa = pesquisar();
				if(servicoPesquisa != null){
					btnAlterar.setEnabled(true);
				}
				else{
					JOptionPane.showMessageDialog(this, "Servico não encontrado!");
				}
				
			}
			if (evento.getSource() == btnAlterar){
				btnSalvar.setEnabled(true);
				textFieldNomeCompleto.setEditable(true);
				textFieldTipo.setEditable(true);
				textFieldVenda.setEditable(true);
				textFieldCusto.setEditable(true);
				btnSalvar.setEnabled(true);
			}
			if(evento.getSource() == btnCancelar){
				this.dispose();
			}
			if(evento.getSource() == btnSalvar){
				boolean cond = true;
				try{
					if(!Servico.ehNumero(textFieldCusto.getText() ) ){
						throw new CampoInvalidoException();
					}
					if(!Servico.ehNumero(textFieldVenda.getText() ) ){
						throw new CampoInvalidoException();
					}
					String nome = textFieldNomeCompleto.getText();
					String tipo = textFieldCusto.getText();
					float venda = Float.parseFloat(textFieldVenda.getText());
					float custo = Float.parseFloat(textFieldCusto.getText());
					int index = Principal.servicoList.indexOf(servicoPesquisa);
					Servico servico = new Servico(nome, tipo, venda, custo, servicoPesquisa.getId(), servicoPesquisa.getDataCadastro());
					Principal.servicoList.set(index, servico);
					Principal.s.delete();
					Principal.s = new File("Servicos.bin"); 
					ObjectOutputStream oos;
					oos = Principal.openStream(Principal.s);
					for(int i = 0;i < Principal.servicoList.size();i++){
						oos.writeObject(Principal.servicoList.get(i));
					}
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (CampoInvalidoException e){
					JOptionPane.showMessageDialog(null, "Nos campos de Venda e Custo,\nutilizar somente numeros e ponto!",
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
