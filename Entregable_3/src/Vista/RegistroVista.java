package Vista;

import java.awt.Color;
import DAO.*;
import Entidad.*;
import Interfaces.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	private JTextField textContra;
	private JTextField textContra2;
	private JButton btnConfirmar;
	private JLabel lblEsUsuario;
	private JCheckBox chckbxTyC;
	private JLabel lblAceptarTyC;
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
		lblSignUp.setBounds(0, 11, 514, 38);
		lblSignUp.setFont(new Font("Yu Gothic Medium", Font.BOLD, 24));
		lblSignUp.setForeground(Color.WHITE);
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSignUp);
		
		JLabel lblNombre = new JLabel("Nombres: ");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(70, 135, 71, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellidos: ");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setBounds(70, 160, 71, 14);
		contentPane.add(lblApellido);
		
		textNombre = new JTextField();
		textNombre.setBounds(169, 132, 205, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(169, 157, 205, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblInfo = new JLabel("Ingrese los datos a continuación:");
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setBounds(10, 60, 213, 14);
		contentPane.add(lblInfo);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(70, 185, 71, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setForeground(Color.WHITE);
		lblContraseña.setBounds(70, 210, 71, 14);
		contentPane.add(lblContraseña);
		
		textEmail = new JTextField();
		textEmail.setBounds(169, 182, 205, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textContra = new JTextField();
		textContra.setBounds(169, 207, 205, 20);
		contentPane.add(textContra);
		textContra.setColumns(10);
		
		JLabel lblConfirmar = new JLabel("Confirmar");
		lblConfirmar.setForeground(Color.WHITE);
		lblConfirmar.setBounds(70, 235, 71, 14);
		contentPane.add(lblConfirmar);
		
		JLabel lblContraseña2 = new JLabel("contraseña:");
		lblContraseña2.setForeground(Color.WHITE);
		lblContraseña2.setBounds(70, 247, 71, 14);
		contentPane.add(lblContraseña2);
		
		textContra2 = new JTextField();
		textContra2.setBounds(169, 232, 205, 20);
		contentPane.add(textContra2);
		textContra2.setColumns(10);
		
		chckbxTyC = new JCheckBox("Acepto terminos y condiciones");
		chckbxTyC.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxTyC.setBounds(169, 259, 205, 23);
	//	chckbxTyC.addActionListener(this);
		contentPane.add(chckbxTyC);
		
		lblAceptarTyC = new JLabel("");
		lblAceptarTyC.setForeground(Color.RED);
		lblAceptarTyC.setBounds(116, 310, 205, 14);
		contentPane.add(lblAceptarTyC);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConfirmar.setBounds(153, 355, 205, 23);
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
		return textContra.getText();
	}
	
	public String getContraseña2() {
		return textContra2.getText();
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
