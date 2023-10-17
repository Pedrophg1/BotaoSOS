import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


// Definição da classe Menu
public class MenuApp {
    // Método para exibir o menu
    public void abrirMenu() {
        // Implementação do método para exibir o menu
        JFrame frame = new JFrame("Menu");
        JPanel panel = new JPanel();
        JButton openMapBtn = new JButton("Abrir Mapa da UFS");

        // Definindo as cores
        panel.setBackground(Color.WHITE);
        openMapBtn.setBackground(Color.BLUE);
        openMapBtn.setForeground(Color.WHITE);

        panel.add(openMapBtn);
        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Ação do botão Abrir Mapa da UFS
        openMapBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    // Substitua o caminho com o caminho correto da imagem em seu computador
                    File file = new File("C:\\Users\\swyan\\Desktop\\1.png");
                    Image image = ImageIO.read(file);
                    ImageIcon icon = new ImageIcon(image);
                    JLabel label = new JLabel(icon);
                    JFrame imageFrame = new JFrame();
                    imageFrame.setSize(920, 920);
                    imageFrame.add(label);
                    imageFrame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Método principal para teste da classe
    
}
