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
import javax.swing.JScrollPane;
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
	private JButton btnFondos;
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
		
		setTitle("ACE WALLET");
		setResizable(false);
		setLocationRelativeTo(null);
		
		ImageIcon iconoUsuario = new ImageIcon("src/Media/usuario.png");
		Image img = iconoUsuario.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		iconoUsuario = new ImageIcon(img);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario", iconoUsuario, JLabel.LEFT);
		lblUsuario.setBounds(354, 5, 50, 50);
		contentPane.add(lblUsuario);
		
		lblNombreUsuario = new JLabel("");   
		lblNombreUsuario.setBounds(440, 11, 46, 14);
		lblNombreUsuario.setForeground(Color.WHITE);
		lblNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblNombreUsuario);
		
		btnDatosPrueba = new JButton("Generar Datos de Prueba");
		btnDatosPrueba.setBounds(340, 53, 164, 29);
		btnDatosPrueba.setFont(new Font("Tahoma", Font.BOLD, 10));
		contentPane.add(btnDatosPrueba);
		
		btnCerrar = new JButton("Cerrar sesión");
		btnCerrar.setBounds(415, 28, 89, 23);
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(btnCerrar);
		
		lblBalance = new JLabel("BALANCE ");
		lblBalance.setBounds(25, 11, 200, 60);
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblBalance);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {}, //vacio el inicio
			new String[] { "Imagen", "Nombre", "Precio" } //nombres de las columnas"
			) {
			
			  public boolean isCellEditable(int row, int column) {
			        // Todas las celdas son no editables
			        return false;
			    }
			/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int columnIndex){
				//primera columna es de tipo ImageIcon
				if(columnIndex == 0) {
					return ImageIcon.class;
				}
				return String.class; //ya que las demas columnas son texto
			}
		});
		
		// Ajustar ancho de las columnas
        table.getColumnModel().getColumn(0).setPreferredWidth(20); // Imagen
        table.getColumnModel().getColumn(1).setPreferredWidth(150); // Nombre
        table.getColumnModel().getColumn(2).setPreferredWidth(80);  // Precio
        table.setRowHeight(60); // Altura para las imágenes

        // Agregar la tabla al JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(48, 129, 400, 150);
        contentPane.add(scrollPane);

    // Método para llenar la tabla
 /*  private void llenarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.addRow(new Object[]{
                new ImageIcon("src/Media/pesosarg.png"), // Imagen
                "Pesos Argentinos", // Nombre
                "10000" // Precio
        });
        modelo.addRow(new Object[]{
                resizedIcon,
                "Bitcoin",
                "1"
        });
        modelo.addRow(new Object[]{
                new ImageIcon("src/Media/dogecoin.png"),
                "Dogecoin",
                "300"
        });				*/
		
		btnExportar = new JButton("Exportar como CSV");
		btnExportar.setBounds(170, 339, 141, 23);
		contentPane.add(btnExportar);
		
		btnMonto = new JButton("Monto");
		btnMonto.setBounds(235, 19, 89, 23);
		contentPane.add(btnMonto);
		
		btnCripto = new JButton("Cripto");
		btnCripto.setBounds(136, 19, 89, 23);
		contentPane.add(btnCripto);
		
		btnTransacciones = new JButton("Mis Operaciones");
		btnTransacciones.setBounds(100, 373, 125, 50);
		contentPane.add(btnTransacciones);
		
		btnCotizaciones = new JButton("Cotizaciones");
		btnCotizaciones.setBounds(257, 373, 125, 50);
		contentPane.add(btnCotizaciones);
		
		btnFondos = new JButton("Ingresar Fondos");
		btnFondos.setBounds(340, 84, 164, 23);
		btnFondos.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnFondos);
	}
	
	//getter y setter
	
	public void llenarTabla(String icon, String nombre, String precio) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.addRow(new Object[]{
                resizeImage(icon), // Imagen
                nombre, // Nombre
                precio // Precio
        });
	}
	
    public ImageIcon resizeImage(String nombreArchivo) {
    	ImageIcon originalIcon = new ImageIcon("src/Media/"+nombreArchivo);
    	Image resizedImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    	ImageIcon resizedIcon = new ImageIcon(resizedImage);
    	return resizedIcon;
    }
  
    
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
	
	public JButton getBtnFondos() {
		return btnFondos;
	}
	
	public void mostrarMensajeError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
}
