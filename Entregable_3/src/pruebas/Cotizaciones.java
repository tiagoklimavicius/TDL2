package pruebas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.SystemColor;

public class Cotizaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cotizaciones frame = new Cotizaciones();
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
	public Cotizaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCripto = new JLabel("CRIPTO");
		lblCripto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCripto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCripto.setForeground(Color.WHITE);
		lblCripto.setBounds(58, 40, 90, 30);
		contentPane.add(lblCripto);
		
		JLabel lblPrecio = new JLabel("ÚLTIMO PRECIO");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPrecio.setBounds(189, 40, 171, 30);
		contentPane.add(lblPrecio);
		
		//CONFIGURACION IMAGEN BITCOIN
		ImageIcon iconoBitcoin = new ImageIcon("src/Media/bitcoin.png");
        Image img = iconoBitcoin.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        iconoBitcoin = new ImageIcon(img);
		
		JLabel lblBtcImagen = new JLabel("Bitcoin", iconoBitcoin, JLabel.LEFT);
		lblBtcImagen.setBounds(40, 100, 50, 50);
		contentPane.add(lblBtcImagen);
		
		//CONFIGURACION IMAGEN ETHEREUM
		ImageIcon iconoEthereum = new ImageIcon("src/Media/ethereum.png");
        img = iconoEthereum.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        iconoEthereum = new ImageIcon(img);
		
		JLabel lblEthImagen = new JLabel("Ethereum", iconoEthereum, JLabel.LEFT);
		lblEthImagen.setBounds(40, 165, 50, 50);
		contentPane.add(lblEthImagen);
		
		//CONFIGURACION IMAGEN USDC
		ImageIcon iconoUsdc = new ImageIcon("src/Media/usdc.png");
        img = iconoUsdc.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        iconoUsdc = new ImageIcon(img);
		
		JLabel lblUsdcImagen = new JLabel("Usdc", iconoUsdc, JLabel.LEFT);
		lblUsdcImagen.setBounds(40, 230, 50, 50);
		contentPane.add(lblUsdcImagen);
		
		//CONFIGURACION IMAGEN USDT
				ImageIcon iconoUsdt = new ImageIcon("src/Media/usdt.png");
		        img = iconoUsdt.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		        iconoUsdt = new ImageIcon(img);
		
		JLabel lblUsdtImagen = new JLabel("Usdt", iconoUsdt, JLabel.LEFT);
		lblUsdtImagen.setBounds(40, 295, 50, 50);
		contentPane.add(lblUsdtImagen);
		
		//CONFIGURACION IMAGEN DOGECOIN
				ImageIcon iconoDoge = new ImageIcon("src/Media/dogecoin.png");
		        img = iconoDoge.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		        iconoDoge = new ImageIcon(img);
		
		JLabel lblDogeImagen = new JLabel("Dogecoin", iconoDoge, JLabel.LEFT);
		lblDogeImagen.setBounds(40, 360, 50, 50);
		contentPane.add(lblDogeImagen);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVolver.setBounds(220, 427, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblBtc = new JLabel("BTC");
		lblBtc.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBtc.setForeground(Color.WHITE);
		lblBtc.setBounds(116, 116, 46, 14);
		contentPane.add(lblBtc);
		
		JLabel lblEth = new JLabel("ETH");
		lblEth.setHorizontalAlignment(SwingConstants.CENTER);
		lblEth.setForeground(Color.WHITE);
		lblEth.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEth.setBounds(116, 183, 46, 14);
		contentPane.add(lblEth);
		
		JLabel lblUsdc = new JLabel("USDC");
		lblUsdc.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsdc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsdc.setForeground(Color.WHITE);
		lblUsdc.setBounds(116, 248, 46, 14);
		contentPane.add(lblUsdc);
		
		JLabel lblUsdt = new JLabel("USDT");
		lblUsdt.setForeground(Color.WHITE);
		lblUsdt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsdt.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsdt.setBounds(116, 313, 46, 14);
		contentPane.add(lblUsdt);
		
		JLabel lblDoge = new JLabel("DOGE");
		lblDoge.setForeground(Color.WHITE);
		lblDoge.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDoge.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoge.setBounds(116, 378, 46, 14);
		contentPane.add(lblDoge);
		
		JLabel lblPrecioBtc = new JLabel("New label");
		lblPrecioBtc.setBounds(227, 118, 100, 14);
		contentPane.add(lblPrecioBtc);
		
		JLabel lblPrecioEth = new JLabel("New label");
		lblPrecioEth.setBounds(227, 183, 100, 14);
		contentPane.add(lblPrecioEth);
		
		JLabel lblPrecioUsdc = new JLabel("New label");
		lblPrecioUsdc.setBounds(227, 248, 100, 14);
		contentPane.add(lblPrecioUsdc);
		
		JLabel lblPrecioUsdt = new JLabel("New label");
		lblPrecioUsdt.setBounds(227, 313, 100, 14);
		contentPane.add(lblPrecioUsdt);
		
		JLabel lblPrecioDoge = new JLabel("New label");
		lblPrecioDoge.setBounds(227, 378, 100, 14);
		contentPane.add(lblPrecioDoge);
		
		JButton btnComprarBtc = new JButton("COMPRAR");
		btnComprarBtc.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnComprarBtc.setForeground(Color.WHITE);
		btnComprarBtc.setBackground(SystemColor.textText);
		btnComprarBtc.setBounds(355, 114, 89, 23);
		contentPane.add(btnComprarBtc);
		
		JButton btnComprarEth = new JButton("COMPRAR");
		btnComprarEth.setForeground(Color.WHITE);
		btnComprarEth.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnComprarEth.setBackground(Color.BLACK);
		btnComprarEth.setBounds(355, 179, 89, 23);
		contentPane.add(btnComprarEth);
		
		JButton btnComprarUsdt = new JButton("COMPRAR");
		btnComprarUsdt.setForeground(Color.WHITE);
		btnComprarUsdt.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnComprarUsdt.setBackground(Color.BLACK);
		btnComprarUsdt.setBounds(355, 309, 89, 23);
		contentPane.add(btnComprarUsdt);
		
		JButton btnComprarDoge = new JButton("COMPRAR");
		btnComprarDoge.setForeground(Color.WHITE);
		btnComprarDoge.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnComprarDoge.setBackground(Color.BLACK);
		btnComprarDoge.setBounds(355, 374, 89, 23);
		contentPane.add(btnComprarDoge);
		
		JButton btnComprarUsdc = new JButton("COMPRAR");
		btnComprarUsdc.setForeground(Color.WHITE);
		btnComprarUsdc.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnComprarUsdc.setBackground(Color.BLACK);
		btnComprarUsdc.setBounds(355, 244, 89, 23);
		contentPane.add(btnComprarUsdc);
	}

}
