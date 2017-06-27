package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal {

	private JFrame frmLeilao;
	private JTable tLeiloes;
	private JTable tProdutosLeilao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmLeilao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLeilao = new JFrame();
		frmLeilao.setTitle("Leilao");
		frmLeilao.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/sources/leilao.png")));
		frmLeilao.setBounds(100, 100, 800, 600);
		frmLeilao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLeilao.getContentPane().setLayout(null);
		
		JLabel lblLeiloNmero = new JLabel("Leil\u00E3o N\u00FAmero:");
		lblLeiloNmero.setBounds(23, 27, 100, 16);
		frmLeilao.getContentPane().add(lblLeiloNmero);
		
		JLabel lblNatureza = new JLabel("Natureza:");
		lblNatureza.setBounds(299, 27, 56, 16);
		frmLeilao.getContentPane().add(lblNatureza);
		
		JLabel txtNatureza = new JLabel("oferta");
		txtNatureza.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNatureza.setBounds(367, 27, 56, 16);
		frmLeilao.getContentPane().add(txtNatureza);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAtualizar.setBounds(642, 23, 97, 25);
		frmLeilao.getContentPane().add(btnAtualizar);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(482, 27, 56, 16);
		frmLeilao.getContentPane().add(lblTipo);
		
		JLabel txtTipo = new JLabel("fechado");
		txtTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTipo.setBounds(525, 27, 56, 16);
		frmLeilao.getContentPane().add(txtTipo);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(465, 56, 48, 16);
		frmLeilao.getContentPane().add(lblUsuario);
		
		JLabel lblListaleiloes = new JLabel("Lista de Leiloes");
		lblListaleiloes.setBounds(35, 122, 123, 16);
		frmLeilao.getContentPane().add(lblListaleiloes);
		
		tLeiloes = new JTable();
		tLeiloes.setBounds(45, 139, 590, 102);
		frmLeilao.getContentPane().add(tLeiloes);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setBounds(42, 279, 56, 16);
		frmLeilao.getContentPane().add(lblProdutos);
		
		tProdutosLeilao = new JTable();
		tProdutosLeilao.setBounds(45, 308, 590, 164);
		frmLeilao.getContentPane().add(tProdutosLeilao);
		
		JLabel txtUsuario = new JLabel("usuario");
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtUsuario.setBounds(525, 56, 56, 16);
		frmLeilao.getContentPane().add(txtUsuario);
		
		JLabel txtNumLeilao = new JLabel("0001");
		txtNumLeilao.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtNumLeilao.setBounds(125, 27, 56, 16);
		frmLeilao.getContentPane().add(txtNumLeilao);
	}
}
