package Vista;

import java.awt.Color;
import DAO.*;
import Entidad.*;
import Interfaces.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class RegistroVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JPasswordField textContra;
	private JPasswordField textContra2;
	private JButton btnConfirmar;
	private JLabel lblEsUsuario;
	private JCheckBox chckbxTyC;
	private JButton btnIniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroVista frame = new RegistroVista();
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
	public RegistroVista() {
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
		
		JLabel lblSignUp = new JLabel("REGISTRO");
		lblSignUp.setBounds(0, 11, 514, 52);
		lblSignUp.setFont(new Font("Yu Gothic Medium", Font.BOLD, 30));
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSignUp);
		
		JLabel lblNombre = new JLabel("Nombres: ");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(35, 120, 95, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellidos: ");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setBounds(35, 160, 95, 14);
		contentPane.add(lblApellido);
		
		textNombre = new JTextField();
		textNombre.setBounds(169, 115, 210, 30);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(169, 155, 210, 30);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblInfo = new JLabel("Ingrese los datos a continuación:");
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setBounds(35, 74, 275, 30);
		contentPane.add(lblInfo);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(35, 200, 95, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setBounds(35, 240, 95, 14);
		contentPane.add(lblContraseña);
		
		textEmail = new JTextField();
		textEmail.setBounds(169, 195, 210, 30);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textContra = new JPasswordField();
		textContra.setBounds(169, 235, 210, 30);
		contentPane.add(textContra);
		textContra.setColumns(10);
		
		JLabel lblConfirmar = new JLabel("Confirmar");
		lblConfirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConfirmar.setForeground(Color.WHITE);
		lblConfirmar.setBounds(35, 280, 95, 14);
		contentPane.add(lblConfirmar);
		
		JLabel lblContraseña2 = new JLabel("contraseña:");
		lblContraseña2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContraseña2.setForeground(Color.WHITE);
		lblContraseña2.setBounds(35, 292, 95, 14);
		contentPane.add(lblContraseña2);
		
		textContra2 = new JPasswordField();
		textContra2.setBounds(169, 275, 210, 30);
		contentPane.add(textContra2);
		textContra2.setColumns(10);
		
		chckbxTyC = new JCheckBox("Acepto terminos y condiciones");
		chckbxTyC.setForeground(Color.WHITE);
		chckbxTyC.setBackground(Color.DARK_GRAY);
		chckbxTyC.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxTyC.setBounds(169, 323, 275, 23);
	//	chckbxTyC.addActionListener(this);
		contentPane.add(chckbxTyC);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setBackground(Color.DARK_GRAY);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmar.setBounds(180, 375, 147, 31);
	//	btnConfirmar.addActionListener(this);
		contentPane.add(btnConfirmar);
		
		lblEsUsuario = new JLabel("¿Ya tiene una cuenta?");
		lblEsUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEsUsuario.setForeground(Color.WHITE);
		lblEsUsuario.setBounds(80, 424, 205, 26);
		contentPane.add(lblEsUsuario);
		
		btnIniciar = new JButton("INICIAR SESIÓN");
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.setBackground(Color.DARK_GRAY);
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIniciar.setBounds(268, 427, 157, 23);
		contentPane.add(btnIniciar);
	}
	
	//getter y setter
	
	public JButton getBtnIniciar() {
		return btnIniciar;
	}
	
	public String getNombre() {
		return textNombre.getText();
	}
	
	public String getApellido() {
		return textApellido.getText();
	}
	
	public String getEmail() {
		return textEmail.getText();
	}
	
	public String getContraseña() {
		char[] passwordArray = textContra.getPassword();
		String contraseña = new String(passwordArray);
		return contraseña;
	}
	
	public String getContraseña2() {
		char[] passwordArray = textContra2.getPassword();
		String contraseña2 = new String(passwordArray);
		return contraseña2;
	}
	
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}
	
	public boolean isChckbxTyCSelected() {
	    return chckbxTyC.isSelected();
	}
	
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
	}
}
