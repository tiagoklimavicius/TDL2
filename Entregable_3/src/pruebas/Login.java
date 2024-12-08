package pruebas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

import DAO.*;
import Modelo.*;
import Interfaces.*;
import javax.swing.JCheckBox;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtContraseña;
	private JButton btnIngresar;
	private JLabel lblAcceso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 320);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("ACE WALLET");
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblLogin = new JLabel("INICIAR SESIÓN");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 20));
		lblLogin.setBounds(131, 6, 168, 59);
		contentPane.add(lblLogin);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(24, 76, 72, 31);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(131, 76, 204, 28);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContraseña.setBounds(24, 122, 85, 39);
		contentPane.add(lblContraseña);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(131, 129, 204, 28);
		contentPane.add(txtContraseña);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(157, 183, 130, 23);
		contentPane.add(btnIngresar);
		
		lblAcceso = new JLabel("");
		lblAcceso.setForeground(Color.WHITE);
		lblAcceso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcceso.setBounds(132, 239, 189, 31);
		contentPane.add(lblAcceso);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(btnIngresar==e.getSource()) {
			String email = txtEmail.getText();
			String contraseña = txtContraseña.getText();
			UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
			Usuario usuario = usuarioDAO.obtener(email);
			if(usuario == null) {
				lblAcceso.setText("Ingreso denegado");
			}
			else {
				lblAcceso.setText("Ingreso exitoso");
			}
		}
		
	}
}
