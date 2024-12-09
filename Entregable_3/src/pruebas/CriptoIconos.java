package pruebas;
import javax.swing.*;
import java.awt.*;

public class CriptoIconos {
    public static void main(String[] args) {
        // Crear el JFrame
        JFrame frame = new JFrame("Criptomonedas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Cargar la imagen del archivo PNG
        ImageIcon iconoBitcoin = new ImageIcon("src/Media/bitcoin.png");
        Image img = iconoBitcoin.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        iconoBitcoin = new ImageIcon(img);
        frame.getContentPane().setLayout(null);

        // Crear un JLabel con la imagen
        JLabel labelBitcoin = new JLabel("Bitcoin", iconoBitcoin, JLabel.LEFT);
        labelBitcoin.setBounds(50, 88, 50, 50);

        // Agregar el JLabel al JFrame
        frame.getContentPane().add(labelBitcoin);

        // Mostrar el JFrame
        frame.setVisible(true);
    }
}