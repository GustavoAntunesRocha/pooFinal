package interfaceGrafica;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.Usuario;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class JanelaLogin extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JLabel lblUsurio;
	private JLabel lblSenha;
	public JButton okButton;
	private JButton cancelButton;
	private JLabel lblSenhaIncorreta;
	private JLabel lblUsurioIncorreto;

	/**
	 * Create the dialog.
	 */
	public JanelaLogin() {
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 253, 182);
		setTitle("Login");
		getContentPane().setLayout(new MigLayout("", "[247px]", "[103px][30px]"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, "cell 0 0,grow");
		contentPanel.setLayout(new MigLayout("", "[70px][140px][]", "[30px][30px][30px]"));
		
		lblSenhaIncorreta = new JLabel("Senha incorreta!");
		lblSenhaIncorreta.setForeground(Color.RED);
		contentPanel.add(lblSenhaIncorreta, "cell 0 2");
		lblSenhaIncorreta.setVisible(false);
		
		lblUsurioIncorreto = new JLabel("Usu\u00E1rio incorreto!");
		lblUsurioIncorreto.setForeground(Color.RED);
		contentPanel.add(lblUsurioIncorreto, "cell 1 2");
		lblUsurioIncorreto.setVisible(false);
		
		lblUsurio = new JLabel("Usu\u00E1rio");
		contentPanel.add(lblUsurio, "cell 0 0,alignx center");
		
		txtUsuario = new JTextField();
		lblUsurio.setLabelFor(txtUsuario);
		contentPanel.add(txtUsuario, "cell 1 0,grow");
		txtUsuario.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		contentPanel.add(lblSenha, "cell 0 1,alignx center");
		
		passwordField = new JPasswordField();
		lblSenha.setLabelFor(passwordField);
		contentPanel.add(passwordField, "cell 1 1,grow");
		
		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, "cell 0 1,grow");
		buttonPane.setLayout(new GridLayout(0, 2, 0, 0));
			
		okButton = new JButton("OK");
		buttonPane.add(okButton);
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);
			
		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}
	public void actionPerformed(ActionEvent evento) {
			if(evento.getSource() == okButton){
				lblUsurioIncorreto.setVisible(false);
				lblSenhaIncorreta.setVisible(false);
				Usuario usuario = Usuario.busca(txtUsuario.getText());
				if(usuario != null){
					if(String.valueOf(passwordField.getPassword()).equals(usuario.getSenha())){
						this.dispose();
						try {
							JanelaPrincipal frame = JanelaPrincipal.getInstance();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					else{
						lblSenhaIncorreta.setVisible(true);
					}
				}
				else{
					lblUsurioIncorreto.setVisible(true);
				}
			}
			if(evento.getSource() == cancelButton){
				this.dispose();
			}
	}
}
