package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToggleButton;

public class BalanceVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNombreUsuario;
	private JButton btnDatosPrueba;
	private JButton btnCerrar;
	private JLabel lblBalance;
	private JButton btnExportar;
	private JButton btnMonto;
	private JButton btnCripto;
	private JButton btnTransacciones;
	private JButton btnCotizaciones;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceVista frame = new BalanceVista();
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
	public BalanceVista() {
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
		
		btnDatosPrueba = new JButton("Generar Datos de Prueba");
		btnDatosPrueba.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDatosPrueba.setBounds(340, 53, 164, 29);
		contentPane.add(btnDatosPrueba);
		
		btnCerrar = new JButton("Cerrar sesión");
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCerrar.setBounds(415, 28, 89, 23);
		contentPane.add(btnCerrar);
		
		lblBalance = new JLabel("BALANCE ");
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblBalance.setBounds(40, 100, 200, 60);
		contentPane.add(lblBalance);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.setBounds(50, 171, 284, 64);
		contentPane.add(table);
		
		btnExportar = new JButton("Exportar como CSV");
		btnExportar.setBounds(136, 265, 141, 23);
		contentPane.add(btnExportar);
		
		btnMonto = new JButton("Monto");
		btnMonto.setBounds(237, 148, 89, 23);
		contentPane.add(btnMonto);
		
		btnCripto = new JButton("Cripto");
		btnCripto.setBounds(136, 148, 89, 23);
		contentPane.add(btnCripto);
		
		btnTransacciones = new JButton("Mis Operaciones");
		btnTransacciones.setBounds(100, 373, 125, 50);
		contentPane.add(btnTransacciones);
		
		btnCotizaciones = new JButton("Cotizaciones");
		btnCotizaciones.setBounds(257, 373, 125, 50);
		contentPane.add(btnCotizaciones);
	}
	
	//getter y setter
	
	
	public void setNombreUsuario(String nombre) {
		lblNombreUsuario.setText(nombre);
	}
	
	public JButton getBtnDatosPrueba() {
		return btnDatosPrueba;
	}
	
	public JButton getBtnCerrar() {
		return btnCerrar;
	}
	
	public void setBalance(String balance) {
		lblBalance.setText(balance);
	}
	
	public JButton getBtnExportar() {
		return btnExportar;
	}
	
	public JButton getBtnMonto() {
		return btnMonto;
	}
	
	public JButton getBtnCripto() {
		return btnCripto;
	}
	
	public JButton getBtnTransacciones() {
		return btnTransacciones;
	}
	
	public JButton getBtnCotizaciones() {
		return btnCotizaciones;
	}
	
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
}
