import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MenuApp {
    public void abrirMenu() {
        JFrame frame = new JFrame("Menu");
        JPanel panel = new JPanel();
        ImageIcon frameIcon = new ImageIcon("assets/brasao_icon.png");
        frame.setIconImage(frameIcon.getImage());

        // Crie botões para "Abrir Mapa da UFS", "Ajuda" e "Ver Mapa"
        JButton openMapBtn = new JButton("Abrir Mapa da UFS");
        JButton helpBtn = new JButton("Ajuda");
        helpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame ajudaFrame = new JFrame("Ajuda");
                ajudaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ajudaFrame.setSize(500, 430);
                ajudaFrame.setLocationRelativeTo(null);
                ImageIcon frameIcon = new ImageIcon("assets/brasao_icon.png");
                ajudaFrame.setIconImage(frameIcon.getImage());

                JTextArea textoAjuda = new JTextArea();
                textoAjuda.setWrapStyleWord(true);
                textoAjuda.setLineWrap(true);
                textoAjuda.setEditable(false);
                textoAjuda.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                textoAjuda.setFont(new Font("Montserrat", Font.BOLD, 14));

                textoAjuda.setText("Bem-vindo(a) ao Sistema de SOS da UFS!\n\n"
                        + "Este sistema permite que você solicite ajuda em locais específicos da universidade.\n\n"
                        + "Para solicitar ajuda:\n"
                        + "1. Preencha o campo com sua matrícula.\n"
                        + "2. Selecione o local do problema e o tipo de ocorrência nos menus suspensos.\n"
                        + "3. Clique no botão 'SOS' para enviar sua solicitação de ajuda(você pode descrever o problema no campo que irá aparecer).\n\n"
                        + "4. Clique no botão enviar.\n"
                        + "Sua solicitação será enviada para o(a) segurança mais próximo de você, basta aguardar.\n\n"
                        + "Você também pode clicar no botão 'Ver Mapa' para visualizar o mapa da universidade.\n\n"
                        + "Para obter mais informações, entre em contato com o suporte.");

                JPanel painelAjuda = new JPanel(new BorderLayout());
                painelAjuda.add(new JScrollPane(textoAjuda), BorderLayout.CENTER);
                ajudaFrame.add(painelAjuda);
                ajudaFrame.setVisible(true);
            }
        });





        // Defina as cores dos botões
        openMapBtn.setBackground(Color.BLUE);
        helpBtn.setBackground(Color.GREEN); // Cor de Ajuda
        // Cor de Ver Mapa

        // Defina as cores do texto dos botões
        openMapBtn.setForeground(Color.WHITE);
        helpBtn.setForeground(Color.WHITE);
        panel.setLayout(new FlowLayout());
        panel.add(openMapBtn);
        panel.add(helpBtn);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setSize(420, 100);
        frame.setVisible(true);
        openMapBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    File imageFile = new File("assets/mapa_ufs.png");
                    BufferedImage image = ImageIO.read(imageFile);

                    JFrame mapaFrame = new JFrame("Mapa da UFS");
                    mapaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    mapaFrame.setSize(600, 800);
                    mapaFrame.setLocationRelativeTo(null);
                    ImageIcon frameIcon = new ImageIcon("assets/brasao_icon.png");
                    mapaFrame.setIconImage(frameIcon.getImage());

                    JPanel mapaPanel = new JPanel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                        }
                    };

                    mapaFrame.add(mapaPanel, BorderLayout.CENTER);
                    mapaFrame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Erro ao carregar a imagem do mapa.", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
