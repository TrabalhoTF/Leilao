package view;

import business.Usuario;
import business.UsuarioTableModel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaUsuario extends JFrame {
	
	UsuarioTableModel tableModel = new UsuarioTableModel();
	
	
	
	private JPanel contentPane;
	private JTable jTUsuarios;
	private JTextField txtUsuario;
	private JTextField txtCnpjCpf;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario frame = new TelaUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Criacao do Frame
	 */
	
	public TelaUsuario() {

		jTUsuarios.setModel(tableModel);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jTUsuarios = new JTable();
		jTUsuarios.setBounds(32, 170, 491, 217);
		contentPane.add(jTUsuarios);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setBounds(27, 13, 56, 16);
		contentPane.add(lblUsuarios);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(32, 66, 56, 16);
		contentPane.add(lblNome);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(32, 81, 205, 22);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblCnpjCpf = new JLabel("CNPJ/CPF:");
		lblCnpjCpf.setBounds(32, 105, 84, 16);
		contentPane.add(lblCnpjCpf);
		
		txtCnpjCpf = new JTextField();
		txtCnpjCpf.setBounds(32, 121, 205, 22);
		contentPane.add(txtCnpjCpf);
		txtCnpjCpf.setColumns(10);
		
		JLabel lblEmail = new JLabel("e-mail:");
		lblEmail.setBounds(265, 66, 56, 16);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(265, 81, 258, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		        Usuario p = new Usuario(null,null,null);
		        p.setNome(txtUsuario.getText());
		        p.setCnpj_cpf(txtCnpjCpf.getText());
		        p.setEmail(txtEmail.getText());
		        
		        tableModel.addRow(p);
				
			}
		});
		btnCadastrar.setBounds(265, 120, 97, 25);
		contentPane.add(btnCadastrar);
	}
}
