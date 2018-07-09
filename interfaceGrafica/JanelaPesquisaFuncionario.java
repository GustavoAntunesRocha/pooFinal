package interfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controle.Funcionario;
import controle.Principal;
/**
 * Descrição de JanelaPesquisaFuncionario.
 * 
 * @author Gustavo Antunes Rocha
 */
public class JanelaPesquisaFuncionario extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldID;
	private JTextField textFieldNomeCompleto;
	private JLabel lblSexo;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JLabel lblCpf;
	private JTextField textFieldCPF;
	private JLabel lblDataDeNascimento;
	private JLabel lblEndereo;
	private JTextField textFieldEndereco;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	JButton btnPesquisar;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;
	UtilDateModel model;
	private Funcionario funcionarioPesquisa;
	private JLabel lblSalarioH;
	private JTextField textFieldSalarioH;
	private JLabel lblSalarioTotal;
	private JTextField textFieldSalarioTotal;
	private JLabel lblHorasTrabalhadas;
	private JTextField textFieldHoras;
	
	/**
	 * Create the dialog.
	 * 
	 */
	public JanelaPesquisaFuncionario() {
		setTitle("Pesquisa de Funcionarios");
		setModal(true);
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 547, 438);
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
		panelResultado.setLayout(new MigLayout("", "[70px,grow,left]", "[20px][30px][20px][30px][20px][30px][][][30px][30px][30px][30px]"));
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		panelResultado.add(lblNomeCompleto, "flowx,cell 0 0");
		
		ButtonGroup grupo = new ButtonGroup();
		textFieldNomeCompleto = new JTextField();
		textFieldNomeCompleto.setEditable(false);
		panelResultado.add(textFieldNomeCompleto, "cell 0 1,growx");
		textFieldNomeCompleto.setColumns(10);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setEnabled(false);
		panelResultado.add(rdbtnMasculino, "flowx,cell 0 3");
		grupo.add(rdbtnMasculino);
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setEnabled(false);
		panelResultado.add(rdbtnFeminino, "cell 0 3");
		grupo.add(rdbtnFeminino);
		
		lblCpf = new JLabel("CPF:");
		panelResultado.add(lblCpf, "cell 0 4");
		textFieldCPF = new JTextField();
		
		panelResultado.add(textFieldCPF, "cell 0 5,growx");
		textFieldCPF.setColumns(10);
		lblSexo = new JLabel("Sexo:");
		panelResultado.add(lblSexo, "cell 0 2");
		
		model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		panelResultado.add(lblDataDeNascimento, "cell 0 6");
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		panelResultado.add(datePicker, "cell 0 6,alignx left,aligny center");
		
		lblEndereo = new JLabel("Endere\u00E7o:");
		panelResultado.add(lblEndereo, "cell 0 7");
		textFieldEndereco = new JTextField();
		textFieldEndereco.setEditable(false);
		panelResultado.add(textFieldEndereco, "cell 0 8,growx");
		textFieldEndereco.setColumns(10);
		
		lblSalarioH = new JLabel("Salario / h:");
		panelResultado.add(lblSalarioH, "flowx,cell 0 9");
		
		lblHorasTrabalhadas = new JLabel("Horas trabalhadas:");
		panelResultado.add(lblHorasTrabalhadas, "flowx,cell 0 10");
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		panelResultado.add(btnSalvar, "flowx,cell 0 11");
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		panelResultado.add(btnAlterar, "cell 0 11");
		btnCancelar = new JButton("Cancelar");
		panelResultado.add(btnCancelar, "cell 0 11");
		
		textFieldSalarioH = new JTextField();
		textFieldSalarioH.setEditable(false);
		panelResultado.add(textFieldSalarioH, "cell 0 9");
		textFieldSalarioH.setColumns(10);
		
		lblSalarioTotal = new JLabel("Salario total:");
		panelResultado.add(lblSalarioTotal, "cell 0 9");
		
		textFieldSalarioTotal = new JTextField();
		textFieldSalarioTotal.setEditable(false);
		panelResultado.add(textFieldSalarioTotal, "cell 0 9");
		textFieldSalarioTotal.setColumns(10);
		
		textFieldHoras = new JTextField();
		panelResultado.add(textFieldHoras, "cell 0 10");
		textFieldHoras.setColumns(10);
		
		btnSalvar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnPesquisar.addActionListener(this);
	}
	
	/**
	 * Descrição do método pesquisar
	 * @return Funcionario
	 */
	private Funcionario pesquisar(){
		Funcionario funcionario = null;
		if(!textFieldNome.getText().equals("")){
			funcionario = Funcionario.busca(textFieldNome.getText());
		}
		else if(!textFieldID.getText().equals("")){
			funcionario = Funcionario.busca(Integer.parseInt(textFieldID.getText()));
		}
		if(funcionario == null){
			return null;
		}
		textFieldNomeCompleto.setText(funcionario.getNome());
		if(funcionario.getSexo().equals("Masculino")){
			rdbtnMasculino.setSelected(true);
		}
		else{
			rdbtnFeminino.setSelected(true);
		}
		textFieldCPF.setText(String.valueOf(funcionario.getCpf()));
		model.setValue(funcionario.getDataNascimento());
		model.setSelected(true);
		textFieldEndereco.setText(funcionario.getEndereco());
		textFieldSalarioH.setText(String.valueOf(funcionario.getSalarioH()));
		textFieldSalarioTotal.setText(String.valueOf(funcionario.calcSalario()));
		textFieldHoras.setText(String.valueOf(funcionario.getHorasTrabalhadas()));
		return funcionario;
	}
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource() == btnPesquisar){
				funcionarioPesquisa = pesquisar();
				if(funcionarioPesquisa != null){
					btnAlterar.setEnabled(true);
				}
				else{
					JOptionPane.showMessageDialog(this, "Funcionario não encontrado!");
				}
				
			}
			if (evento.getSource() == btnAlterar){
				btnSalvar.setEnabled(true);
				textFieldNomeCompleto.setEditable(true);
				rdbtnMasculino.setEnabled(true);
				rdbtnFeminino.setEnabled(true);
				textFieldCPF.setEditable(true);
				textFieldEndereco.setEditable(true);
				btnSalvar.setEnabled(true);
				textFieldSalarioH.setEditable(true);
				textFieldHoras.setEditable(true);
			}
			if(evento.getSource() == btnCancelar){
				this.dispose();
			}
			if(evento.getSource() == btnSalvar){
				String nome = textFieldNomeCompleto.getText();
				String sexo;
				if(rdbtnMasculino.isSelected()){
					sexo = "Masculino";
				}
				else {
					sexo = "Feminino";
				}
				long cpf = Long.parseLong(textFieldCPF.getText());
				Date data = (Date) datePicker.getModel().getValue();
				String endereco = textFieldEndereco.getText();
				int index = Principal.funcionarioList.indexOf(funcionarioPesquisa);
				float salarioH = Float.parseFloat(textFieldSalarioH.getText());
				float horas = Float.parseFloat(textFieldHoras.getText());
				Funcionario funcionario = new Funcionario(nome, sexo, cpf, endereco, data, funcionarioPesquisa.getDataCadastro(), 
						funcionarioPesquisa.getId(),salarioH,horas);
				Principal.funcionarioList.set(index, funcionario);
				Principal.c.delete();
				Principal.c = new File("Funcionarios.bin"); 
				ObjectOutputStream oos;
				try {
					oos = Principal.openStream(Principal.c);
					for(int i = 0;i < Principal.funcionarioList.size();i++){
						oos.writeObject(Principal.funcionarioList.get(i));
					}
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.dispose();
			}
		}
}
