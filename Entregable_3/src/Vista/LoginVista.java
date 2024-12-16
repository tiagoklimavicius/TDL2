package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
import Entidad.*;
import Interfaces.*;
import javax.swing.JCheckBox;

public class LoginVista extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtContraseña;
	private JButton btnIngresar;
	private JButton btnRegistrarse;
	private JLabel lblAun;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginVista frame = new LoginVista();
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
	public LoginVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 500);
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
		lblLogin.setFont(new Font("Yu Gothic Medium", Font.BOLD, 30));
		lblLogin.setBounds(0, 24, 514, 65);
		contentPane.add(lblLogin);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(37, 130, 72, 31);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmail.setBounds(157, 119, 221, 39);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContraseña.setBounds(28, 165, 99, 39);
		contentPane.add(lblContraseña);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(157, 170, 221, 39);
		contentPane.add(txtContraseña);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBackground(Color.DARK_GRAY);
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIngresar.setBounds(177, 250, 147, 31);
		contentPane.add(btnIngresar);
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrarse.setBackground(Color.DARK_GRAY);
		btnRegistrarse.setBounds(268, 427, 157, 23);
		contentPane.add(btnRegistrarse);
		
		lblAun = new JLabel("¿Aún no es usuario?");
		lblAun.setForeground(Color.WHITE);
		lblAun.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAun.setBounds(105, 429, 168, 14);
		contentPane.add(lblAun);
		
	}
	// Getter y Setter para btnIngresar
	public JButton getBtnIngresar() {
	    return btnIngresar;
	}

	public JButton getBtnRegistrarse() {
	   	return btnRegistrarse;
	}

	// Getter y Setter para txtContraseña
	public String getContraseña() {
		char[] passwordArray = txtContraseña.getPassword();
		String contraseña = new String(passwordArray);
		return contraseña;
	}

	// Getter y Setter para txtEmail
	public String getEmail() {
	    return txtEmail.getText();
	}
	
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Acceso exitoso", JOptionPane.INFORMATION_MESSAGE);
	}
}
