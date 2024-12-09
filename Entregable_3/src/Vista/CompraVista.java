package Vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CompraVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

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
		
		String cripto = "BTC";										//esto tiene q ser la nomenclatura de la cripto a comprar 
		JLabel lblComprarCripto = new JLabel("COMPRAR "+cripto);
		lblComprarCripto.setForeground(Color.WHITE);
		lblComprarCripto.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblComprarCripto.setBounds(10, 11, 207, 49);
		contentPane.add(lblComprarCripto);
		
		String criptoNom = "Bitcoin";								//esto tiene q ser el nombre de la criptomoneda
		JLabel lblCripto = new JLabel(criptoNom);
		lblCripto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCripto.setForeground(Color.WHITE);
		lblCripto.setBounds(10, 83, 140, 14);
		contentPane.add(lblCripto);
		
		String precio = "66960.39";          //hay q convertir el valor real de la cotizacion a este string
		JLabel lblPrecioCripto = new JLabel(precio);
		lblPrecioCripto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioCripto.setForeground(Color.WHITE);
		lblPrecioCripto.setBounds(10, 100, 140, 14);
		contentPane.add(lblPrecioCripto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setBackground(Color.BLACK);
		comboBox.setForeground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel());
		comboBox.setBounds(240, 174, 104, 29);
		contentPane.add(comboBox);
		
		JButton btnConvertir = new JButton("CONVERTIR");
		btnConvertir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConvertir.setForeground(Color.WHITE);
		btnConvertir.setBackground(Color.BLACK);
		btnConvertir.setBounds(384, 174, 104, 29);
		contentPane.add(btnConvertir);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.DARK_GRAY);
		textField.setFont(new Font("Tahoma", Font.BOLD, 35));
		textField.setBounds(89, 148, 140, 80);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEquivalente = new JLabel("");
		lblEquivalente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEquivalente.setForeground(Color.WHITE);
		lblEquivalente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquivalente.setBounds(89, 259, 140, 29);
		contentPane.add(lblEquivalente);
		
		JButton bntConfirmar = new JButton("CONFIRMAR");
		bntConfirmar.setForeground(Color.WHITE);
		bntConfirmar.setFont(new Font("Tahoma", Font.BOLD, 13));
		bntConfirmar.setBackground(Color.BLACK);
		bntConfirmar.setBounds(120, 410, 120, 30);
		contentPane.add(bntConfirmar);
		
		JButton bntCancelar = new JButton("CANCELAR");
		bntCancelar.setBackground(Color.BLACK);
		bntCancelar.setFont(new Font("Tahoma", Font.BOLD, 13));
		bntCancelar.setForeground(Color.WHITE);
		bntCancelar.setBounds(269, 410, 120, 30);
		contentPane.add(bntCancelar);
	}
}
