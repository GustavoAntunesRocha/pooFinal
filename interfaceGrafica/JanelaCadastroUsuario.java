package interfaceGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.util.Date;

import controle.Principal;
import controle.Usuario;

import javax.swing.JButton;
import javax.swing.JDialog;

public class JanelaCadastroUsuario extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNomeDeUsurio;
	private JTextField textFieldNomeUsuario;
	private JLabel lblSenha;
	private JPasswordField passwordField;
	private JButton btnSalvar;
	private JButton btnCancelar;
	
	/**
	 * Create the frame.
	 */
	public JanelaCadastroUsuario() {
		setTitle("Cadastro de Usu\u00E1rios");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 376, 218);
		contentPane = new JPanel();
		JScrollPane scrollPane = new JScrollPane(contentPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(scrollPane);
		contentPane.setLayout(new MigLayout("", "[70px,grow,left]", "[20px][30px][20px][30px][30px]"));

		lblNomeDeUsurio = new JLabel("Nome de usu\u00E1rio:");
		contentPane.add(lblNomeDeUsurio, "cell 0 0");

		textFieldNomeUsuario = new JTextField();
		contentPane.add(textFieldNomeUsuario, "cell 0 1,growx");
		textFieldNomeUsuario.setColumns(10);

		lblSenha = new JLabel("Senha:");
		contentPane.add(lblSenha, "cell 0 2");

		passwordField = new JPasswordField();
		contentPane.add(passwordField, "cell 0 3,growx");

		btnSalvar = new JButton("Salvar");
		contentPane.add(btnSalvar, "flowx,cell 0 4");
		
		btnCancelar = new JButton("Cancelar");
		contentPane.add(btnCancelar, "cell 0 4");
		
		btnSalvar.addActionListener(this);
		btnCancelar.addActionListener(this);
	}
	
		@Override
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource() == btnSalvar) {
				String nomeU = textFieldNomeUsuario.getText();
				String senha = String.valueOf(passwordField.getPassword());
				Date dataC = new Date(System.currentTimeMillis());
				Usuario usuario = new Usuario(nomeU, senha, dataC);
				Principal.usuarioList.add(usuario);
				ObjectOutputStream oos;
				try {
					oos = Principal.openStream(Principal.u);
					oos.writeObject(usuario);
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.dispose();
			}
			if(evento.getSource() == btnCancelar){
				this.dispose();
			}
		}
}
