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

import controle.Usuario;
import controle.Principal;
import javax.swing.JPasswordField;

/**
 * Descrição de JanelaPesquisaUsuario.
 * 
 * @author Gustavo Antunes Rocha
 */
public class JanelaPesquisaUsuario extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldNomeCompleto;
	private JLabel lblDataDeCadastro;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JButton btnAlterar;
	JButton btnPesquisar;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;
	UtilDateModel model;
	private Usuario usuarioPesquisa;
	private JLabel lblSenha;
	private JPasswordField passwordField;
	
	/**
	 * Create the frame.
	 *  
	 */
	public JanelaPesquisaUsuario() {
		setTitle("Pesquisa de Usu\u00E1rios");
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 547, 284);
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
		
		btnPesquisar = new JButton("Pesquisar");
		panelPesquisa.add(btnPesquisar, "cell 0 2,alignx center");
		
		JPanel panelResultado = new JPanel();
		panelResultado.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		contentPane.add(panelResultado, "cell 1 0,grow");
		panelResultado.setLayout(new MigLayout("", "[70px,grow,left]", "[20px][30px][20px][30px][][30px]"));
		JLabel lblNomeCompleto = new JLabel("Nome:");
		panelResultado.add(lblNomeCompleto, "flowx,cell 0 0");
		
		textFieldNomeCompleto = new JTextField();
		textFieldNomeCompleto.setEditable(false);
		panelResultado.add(textFieldNomeCompleto, "cell 0 1,growx");
		textFieldNomeCompleto.setColumns(10);
		
		lblSenha = new JLabel("Senha:");
		panelResultado.add(lblSenha, "cell 0 2");
		
		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		panelResultado.add(passwordField, "cell 0 3,growx");
		
		model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		lblDataDeCadastro = new JLabel("Data de cadastro:");
		panelResultado.add(lblDataDeCadastro, "cell 0 4");
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		panelResultado.add(datePicker, "cell 0 4,alignx left,aligny center");
		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		panelResultado.add(btnSalvar, "flowx,cell 0 5");
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		panelResultado.add(btnAlterar, "cell 0 5");
		btnCancelar = new JButton("Cancelar");
		panelResultado.add(btnCancelar, "cell 0 5");
		
		btnSalvar.addActionListener(this);
		btnAlterar.addActionListener(this);
		btnCancelar.addActionListener(this);
		btnPesquisar.addActionListener(this);
	}
	
	/**
	 * Descrição do método pesquisar
	 * @return Usuario
	 */
	private Usuario pesquisar(){
		Usuario usuario = null;
		if(!textFieldNome.getText().equals("")){
			usuario = Usuario.busca(textFieldNome.getText());
		}
		if(usuario == null){
			return null;
		}
		textFieldNomeCompleto.setText(usuario.getNomeUsuario());
		passwordField.setText(usuario.getSenha());
		model.setValue(usuario.getDataCadastro());
		model.setSelected(true);
		return usuario;
	}
		@Override
		public void actionPerformed(ActionEvent evento) {
			if(evento.getSource() == btnPesquisar){
				usuarioPesquisa = pesquisar();
				if(usuarioPesquisa != null){
					btnAlterar.setEnabled(true);
				}
				else{
					JOptionPane.showMessageDialog(this, "Usuario não encontrado!");
				}
				
			}
			if (evento.getSource() == btnAlterar){
				btnSalvar.setEnabled(true);
				textFieldNomeCompleto.setEditable(true);
				passwordField.setEditable(true);
				btnSalvar.setEnabled(true);
			}
			if(evento.getSource() == btnCancelar){
				this.dispose();
			}
			if(evento.getSource() == btnSalvar){				
					//Recria o usuario Administrador
					Usuario usuarioAdm = new Usuario("Administrador", "123", Principal.usuarioList.get(0).getDataCadastro());
					Principal.usuarioList.set(0, usuarioAdm);
					
					//Cria um novo usuario com os dados dos campos
					String nome = textFieldNomeCompleto.getText();
					String senha = String.valueOf(passwordField.getPassword());
					int index = Principal.usuarioList.indexOf(usuarioPesquisa);
					Usuario usuario = new Usuario(nome, senha, usuarioPesquisa.getDataCadastro());
					Principal.usuarioList.set(index, usuario);
				try{
					//Apaga o arquivo de usuarios existente e cria um novo, adicionando todos da lista
					Principal.u.delete();
					Principal.u = new File("Usuarios.bin"); 
					ObjectOutputStream oos;
					oos = Principal.openStream(Principal.u);
					for(int i = 0;i < Principal.usuarioList.size();i++){
						oos.writeObject(Principal.usuarioList.get(i));
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
