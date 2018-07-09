package interfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

import java.util.Date;
import java.util.Properties;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controle.CampoInvalidoException;
import controle.Cliente;
import controle.Funcionario;
import controle.Principal;

import javax.swing.JButton;
import javax.swing.JDialog;
/**
 * Description of JanelaCadastroCliente.
 * 
 * @author Gustavo Antunes Rocha
 */
public class JanelaCadastroFuncionario extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private UtilDateModel model;
	private JLabel lblSalarioh;
	private JTextField textFieldSalarioH;
	private JLabel lblHorasPorMs;
	private JTextField textFieldHoras;

	/**
	 * Create the frame.
	 */
	public JanelaCadastroFuncionario() {
		setModal(true);
		setTitle("Cadastro de Funcionário");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setFocusableWindowState(true);
		setBounds(100, 100, 376, 392);
		contentPane = new JPanel();
		JScrollPane scrollPane = new JScrollPane(contentPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(scrollPane);
		contentPane.setLayout(new MigLayout("", "[70px,grow,left]", "[20px][30px][20px][30px][20px][30px][][][30px][30px][30px]"));
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		contentPane.add(lblNomeCompleto, "cell 0 0");
		textFieldNomeCompleto = new JTextField();
		contentPane.add(textFieldNomeCompleto, "cell 0 1,growx");
		textFieldNomeCompleto.setColumns(10);
		ButtonGroup grupo = new ButtonGroup();
		lblSexo = new JLabel("Sexo:");
		contentPane.add(lblSexo, "cell 0 2");
		rdbtnMasculino = new JRadioButton("Masculino");
		grupo.add(rdbtnMasculino);
		contentPane.add(rdbtnMasculino, "flowx,cell 0 3");
		lblCpf = new JLabel("CPF:");
		contentPane.add(lblCpf, "cell 0 4");
		textFieldCPF = new JTextField();
		contentPane.add(textFieldCPF, "cell 0 5,growx");
		textFieldCPF.setColumns(10);
		
		model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		contentPane.add(lblDataDeNascimento, "cell 0 6");
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		contentPane.add(datePicker, "cell 0 6,alignx left,aligny center");
		
		lblEndereo = new JLabel("Endere\u00E7o:");
		contentPane.add(lblEndereo, "cell 0 7");
		textFieldEndereco = new JTextField();
		contentPane.add(textFieldEndereco, "cell 0 8,growx");
		textFieldEndereco.setColumns(10);
		
		lblSalarioh = new JLabel("Salario/h:");
		contentPane.add(lblSalarioh, "flowx,cell 0 9");
		btnSalvar = new JButton("Salvar");
		contentPane.add(btnSalvar, "flowx,cell 0 10");
		rdbtnFeminino = new JRadioButton("Feminino");
		grupo.add(rdbtnFeminino);
		contentPane.add(rdbtnFeminino, "cell 0 3");
		btnCancelar = new JButton("Cancelar");
		contentPane.add(btnCancelar, "cell 0 10");
		
		textFieldSalarioH = new JTextField();
		contentPane.add(textFieldSalarioH, "cell 0 9");
		textFieldSalarioH.setColumns(10);
		
		lblHorasPorMs = new JLabel("Horas por m\u00EAs:");
		contentPane.add(lblHorasPorMs, "cell 0 9");
		
		textFieldHoras = new JTextField();
		contentPane.add(textFieldHoras, "cell 0 9");
		textFieldHoras.setColumns(10);
		
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}

		@Override
		public void actionPerformed(ActionEvent evento) {
			boolean cond = true;
			if (evento.getSource() == btnSalvar) {
				try {
					if(!Cliente.ehNumero(textFieldCPF.getText())){
						throw new CampoInvalidoException();
					}
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
					Date dataC = new Date(System.currentTimeMillis());
					int id = Principal.funcionarioList.size();
					float salarioH = Float.parseFloat(textFieldSalarioH.getText());
					float horas = Float.parseFloat(textFieldHoras.getText());
					Funcionario funcionario = new Funcionario(nome, sexo, cpf, endereco, data, dataC, id, salarioH, horas);
					Principal.funcionarioList.add(funcionario);
					ObjectOutputStream oos;
				
					oos = Principal.openStream(Principal.f);
					oos.writeObject(funcionario);
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (CampoInvalidoException e){
					JOptionPane.showMessageDialog(null, "No campo CPF utilizar somente numeros!",
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
