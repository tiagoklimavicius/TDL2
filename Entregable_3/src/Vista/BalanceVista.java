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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JToggleButton;

public class BalanceVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNombreUsuario;
	private JButton btnCerrar;
	private JLabel lblBalance;
	private JButton btnExportar;
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
		
		btnCerrar = new JButton("Cerrar sesión");
		btnCerrar.setBounds(415, 28, 89, 23);
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(btnCerrar);
		
		lblBalance = new JLabel("BALANCE ");
		lblBalance.setBounds(25, 11, 285, 60);
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblBalance);
		
		table = new JTable();
		table.setFont(new Font("Yu Gothic Medium", Font.BOLD, 15));
		DefaultTableModel model = new DefaultTableModel(
			    new Object[][] {}, // Vacío al inicio
			    new String[] { "Imagen", "Nombre", "Monto" } // Nombres de las columnas
			) {
			    private static final long serialVersionUID = 1L;

			    @Override
			    public boolean isCellEditable(int row, int column) {
			        // Todas las celdas son no editables
			        return false;
			    }

			    @Override
			    public Class<?> getColumnClass(int columnIndex) {
			        if (columnIndex == 0) {
			            return ImageIcon.class; // Primera columna es de tipo ImageIcon
			        } else if (columnIndex == 2) {
			            return Double.class; // Precio debe ser Double para ordenar correctamente
			        }
			        return String.class; // Las demás columnas son texto
			    }
			};
			
		table.setModel(model);	
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

		// Aplicar el renderizador solo a las columnas de Nombre y Precio
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); // Columna "Nombre"
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer); // Columna "Precio"
		
		// Ajustar ancho de las columnas
        table.getColumnModel().getColumn(0).setPreferredWidth(20); // Imagen
        table.getColumnModel().getColumn(1).setPreferredWidth(150); // Nombre
        table.getColumnModel().getColumn(2).setPreferredWidth(80);  // Precio
        table.setRowHeight(60); // Altura para las imágenes

        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);	
        
        // Agregar la tabla al JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(25, 129, 463, 226);
        contentPane.add(scrollPane);
		
		btnExportar = new JButton("Exportar como CSV");
		btnExportar.setBounds(169, 366, 141, 23);
		contentPane.add(btnExportar);
		
		btnTransacciones = new JButton("Mis Operaciones");
		btnTransacciones.setBounds(100, 400, 125, 50);
		contentPane.add(btnTransacciones);
		
		btnCotizaciones = new JButton("Cotizaciones");
		btnCotizaciones.setBounds(255, 400, 125, 50);
		contentPane.add(btnCotizaciones);
		
		btnFondos = new JButton("Ingresar Fondos");
		btnFondos.setBounds(354, 52, 150, 23);
		btnFondos.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnFondos);
	}
	
	//getter y setter
	
	public double getBalance() {
	    double total = 0.0;
	    DefaultTableModel model = (DefaultTableModel) table.getModel();

	    for (int i = 0; i < model.getRowCount(); i++) {
	        Object value = model.getValueAt(i, 2);
	         total += (Double) value; // Sumar el valor
	    }
	    return total;
	}
	
	public void setBalance(double balance) {
		lblBalance.setText("BALANCE: $"+String.format("%.2f", balance));
	}
	
	
	public JTable getTabla() {
		return table;
	}
	
	public void llenarTabla(String icon, String nombre, double precio) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.addRow(new Object[]{
                resizeImage(icon), // Imagen
                nombre, // Nombre
                precio // Monto
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
	
	public JButton getBtnCerrar() {
		return btnCerrar;
	}
	
	public JButton getBtnExportar() {
		return btnExportar;
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
