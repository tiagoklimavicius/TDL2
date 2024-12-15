package Vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidad.Moneda;

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

public class CompraVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNumero;
	private JLabel lblComprarCripto;
	private JLabel lblCripto;
	private JLabel lblPrecioCripto;
	private JComboBox<String> comboBox;
	private JButton btnConvertir;
	private JLabel lblEquivalente;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JLabel lblCriptoImagen;
	private JLabel lblNombreUsuario;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompraVista frame = new CompraVista();
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
	public CompraVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
												
		lblComprarCripto = new JLabel("");
		lblComprarCripto.setHorizontalAlignment(SwingConstants.LEFT);
		lblComprarCripto.setForeground(Color.WHITE);
		lblComprarCripto.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblComprarCripto.setBounds(80, 11, 207, 49);
		contentPane.add(lblComprarCripto);
		
										
		lblCripto = new JLabel("");
		lblCripto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCripto.setForeground(Color.WHITE);
		lblCripto.setBounds(10, 83, 140, 14);
		contentPane.add(lblCripto);
		
		
		lblPrecioCripto = new JLabel("");
		lblPrecioCripto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioCripto.setForeground(Color.WHITE);
		lblPrecioCripto.setBounds(10, 100, 140, 14);
		contentPane.add(lblPrecioCripto);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setBackground(Color.BLACK);
		comboBox.setForeground(Color.WHITE);
		comboBox.setBounds(240, 174, 104, 29);
		contentPane.add(comboBox);
		
		btnConvertir = new JButton("CONVERTIR");
		btnConvertir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConvertir.setForeground(Color.WHITE);
		btnConvertir.setBackground(Color.BLACK);
		btnConvertir.setBounds(384, 174, 104, 29);
		contentPane.add(btnConvertir);
		
		textNumero = new JTextField();
		textNumero.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero.setForeground(Color.WHITE);
		textNumero.setBackground(Color.DARK_GRAY);
		textNumero.setFont(new Font("Tahoma", Font.BOLD, 35));
		textNumero.setBounds(89, 148, 140, 80);
		contentPane.add(textNumero);
		textNumero.setColumns(10);
		
		lblEquivalente = new JLabel("");
		lblEquivalente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEquivalente.setForeground(Color.WHITE);
		lblEquivalente.setHorizontalAlignment(SwingConstants.LEFT);
		lblEquivalente.setBounds(56, 260, 303, 29);
		contentPane.add(lblEquivalente);
		
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
		
		//IMAGEN DE LA CRIPTO
		
		lblCriptoImagen = new JLabel("", JLabel.LEFT);
		lblCriptoImagen.setBounds(10, 11, 50, 50);
		contentPane.add(lblCriptoImagen);
		
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
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnCerrar.setBounds(415, 28, 89, 23);
		contentPane.add(btnCerrar);
	}
	
	//getter y setter
	
	public void setNombreUsuario(String nombre) {
		lblNombreUsuario.setText(nombre);
	}
	
	public JButton getBtnCerrar() {
		return btnCerrar;
	}
	
	
	public void setIconoCripto(String nombreArchivo) {
		try {
	        // Crea el path completo de la imagen
	        String rutaImagen = "src/Media/" + nombreArchivo;

	        // Crea el nuevo icono escalado
	        ImageIcon iconoCripto = new ImageIcon(rutaImagen);
	        Image img = iconoCripto.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	        iconoCripto = new ImageIcon(img);

	        // Establece el icono en el JLabel
	        lblCriptoImagen.setIcon(iconoCripto);
	    } catch (Exception e) {
	        System.err.println("Error al cargar la imagen: " + e.getMessage());
	    } 
	}
	
	public double getCantidad() {
	    try {
	        return Double.parseDouble(textNumero.getText());															//revisar que no se cierre la ventana de compra por este error
	    } catch (NumberFormatException e) {
	        // Manejo de la excepción si el texto no es un número válido
	    	JOptionPane.showMessageDialog(this, "El valor ingresado no es un número válido" ,"Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}

	public void setCriptoN(String nom) {
		lblComprarCripto.setText(nom);
	}
	
	public void setCriptoNombre(String nombre) {
		lblCripto.setText(nombre.toUpperCase());
	}
	
	public void setPrecio(double precio) {
		lblPrecioCripto.setText("$" + String.valueOf(precio));
		
	}
	
	public void agregarItem(String fiat) {
		comboBox.addItem(fiat);
	}
	
	public String obtenerItem() {
		return (String) comboBox.getSelectedItem();
	}
	
	public JButton getBtnConvertir() {
		return btnConvertir;
	}
	
	public void setEquivalente(double equiv, Moneda moneda) {
		lblEquivalente.setText("EQUIVALE A "+String.format("%.8f", equiv)+" "+moneda.getNomenclatura());

	}
	
	public double getEquivalente() {
		return Double.parseDouble(lblEquivalente.getText());
	}
	
	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
}
