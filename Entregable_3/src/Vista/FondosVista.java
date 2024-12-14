package Vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FondosVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNumero;
	private JComboBox<String> comboBox;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JLabel lblNombreUsuario;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FondosVista frame = new FondosVista();
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
	public FondosVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setBackground(Color.BLACK);
		comboBox.setForeground(Color.WHITE);
		comboBox.setBounds(285, 174, 104, 61);
		contentPane.add(comboBox);
		
		textNumero = new JTextField();
		textNumero.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero.setForeground(Color.WHITE);
		textNumero.setBackground(Color.DARK_GRAY);
		textNumero.setFont(new Font("Tahoma", Font.BOLD, 35));
		textNumero.setBounds(80, 148, 175, 116);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfirmar.setBackground(Color.BLACK);
		btnConfirmar.setBounds(120, 410, 120, 30);
		contentPane.add(btnConfirmar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBounds(269, 410, 120, 30);
		contentPane.add(btnCancelar);
		
		JLabel lblIngresarFondos = new JLabel("INGRESAR FONDOS");
		lblIngresarFondos.setForeground(Color.WHITE);
		lblIngresarFondos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblIngresarFondos.setHorizontalAlignment(SwingConstants.LEFT);
		lblIngresarFondos.setBounds(40, 19, 215, 29);
		contentPane.add(lblIngresarFondos);
		
		JLabel lblIngrese = new JLabel("Ingrese monto y moneda fiat a comprar:");
		lblIngrese.setForeground(Color.WHITE);
		lblIngrese.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngrese.setBounds(10, 92, 270, 29);
		contentPane.add(lblIngrese);
		
		ImageIcon iconoUsuario = new ImageIcon("src/Media/usuario.png");
		Image img = iconoUsuario.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		iconoUsuario = new ImageIcon(img);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario", iconoUsuario, JLabel.LEFT);
		lblUsuario.setBounds(354, 5, 50, 50);
		contentPane.add(lblUsuario);
		
		lblNombreUsuario = new JLabel("");   
		lblNombreUsuario.setForeground(Color.WHITE);
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreUsuario.setBounds(440, 11, 46, 14);
		contentPane.add(lblNombreUsuario);
		
		btnCerrar = new JButton("Cerrar sesión");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCerrar.setBounds(415, 28, 89, 23);
		contentPane.add(btnCerrar);
	}
	
	//getter y setter
	
	public double getCantidad() {
	    try {
	        return Double.parseDouble(textNumero.getText());															//revisar que no se cierre la ventana de compra por este error
	    } catch (NumberFormatException e) {
	        // Manejo de la excepción si el texto no es un número válido
	    	JOptionPane.showMessageDialog(this, "El valor ingresado no es un número válido" ,"Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	public void agregarItem(String fiat) {
		comboBox.addItem(fiat);
	}
	
	public String obtenerItem() {
		return (String) comboBox.getSelectedItem();
	}
	
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public void setNombreUsuario(String nombre) {
		lblNombreUsuario.setText(nombre);
	}
	
	public JButton getBtnCerrar() {
		return btnCerrar;
	}
	
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
}