import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class BotaoSOSGUI {
    private JFrame frame;
    ListaLugares listaLugaresPanel = new ListaLugares();
    public BotaoSOSGUI() {

        User user = new User();
        boolean matriculaValida = false;

        for (int tentativas = 1; tentativas <= 3; tentativas++) {
            String matricula = JOptionPane.showInputDialog(frame, "Digite sua matrícula:");

            if (MatriculaValidator.isValidMatricula(matricula)) {
                user.setMatricula(matricula);
                matriculaValida = true;
                break;
            } else {
                MatriculaValidator.showMatriculaError();
                JOptionPane.showMessageDialog(frame, "Tentativas restantes: " + (3 - tentativas));
            }
        }


        if (!matriculaValida) {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }


        frame = new JFrame("Sistema de SOS da UFS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 420);
        frame.setLocationRelativeTo(null);

        ImageIcon frameIcon = new ImageIcon("assets/brasao_icon.png");
        frame.setIconImage(frameIcon.getImage());

        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new BorderLayout());

        ImageIcon logoIcone = new ImageIcon("assets/logo_ufs.png");

        Image logoImagem = logoIcone.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH);
        logoIcone = new ImageIcon(logoImagem);

        JPanel painelLogo = new JPanel();
        painelLogo.add(new JLabel(logoIcone));
        painelLogo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelSuperior.add(painelLogo, BorderLayout.WEST);

        JLabel tituloLabel = new JLabel("Sistema de SOS");
        tituloLabel.setFont(new Font("Montserrat", Font.BOLD, 24));
        tituloLabel.setBorder(BorderFactory.createEmptyBorder(0, 65, 0, 0));

        painelSuperior.add(tituloLabel, BorderLayout.CENTER);

        JLabel labelSelecioneLugar = new JLabel("Selecione abaixo o local do problema:");
        labelSelecioneLugar.setFont(new Font("Montserrat", Font.BOLD, 14));
        labelSelecioneLugar.setHorizontalAlignment(JLabel.CENTER);
        painelSuperior.add(labelSelecioneLugar, BorderLayout.SOUTH);

        frame.add(painelSuperior, BorderLayout.NORTH);

        JPanel painelListaLugares = new JPanel();
        String[] lugares = { "Entrada Principal", "Entrada de Automóveis", "Didática I", "Didática II", "Didática III",
                "Didática IV", "Didática V", "Didática VI", "Didática VII", "Resun", "Biblioteca", "Auditório",
                "Reitoria", "Laboratório" };
        JComboBox<String> listaLugares = new JComboBox<>(lugares);
        listaLugares.setPreferredSize(new Dimension(400, listaLugares.getPreferredSize().height));
        ListaLugares lugares2  = new ListaLugares();
        JComboBox<String> listaLugare = lugares2.getListaLugares();

// Agora você pode chamar o método fazerAlgoComListaLugares passando o JComboBox como argumento

        painelListaLugares.add(listaLugares);

        JPanel painelListaOcorrencias = new JPanel(new GridLayout(2, 1));
        JLabel labelSelecionarOcorrencia = new JLabel("Selecione abaixo o tipo de ocorrência:");
        labelSelecionarOcorrencia.setFont(new Font("Montserrat", Font.BOLD, 14));
        labelSelecionarOcorrencia.setHorizontalAlignment(JLabel.CENTER);
        painelListaOcorrencias.add(labelSelecionarOcorrencia, BorderLayout.NORTH);

        String[] ocorrencias = { "Incêndio", "Assalto", "Atitude Suspeita", "Iluminação Prejudicada", "Se Perdeu", "Outro Tipo de Ocorrência(use a caixa de descrição)" };
        JComboBox<String> listaOcorrencias = new JComboBox<>(ocorrencias);
        listaOcorrencias.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        listaOcorrencias.setPreferredSize(new Dimension(400, listaOcorrencias.getPreferredSize().height));
        painelListaOcorrencias.add(listaOcorrencias);

        JPanel painelListas = new JPanel();

        painelListas.add(painelListaLugares);
        painelListas.add(painelListaOcorrencias);

        frame.add(painelListas);

        JPanel sosButtonPanel = new JPanel();
        BotaoSOS botaoSOS = new BotaoSOS("SOS");
        botaoSOS.setFont(new Font("Montserrat", Font.BOLD, 24));
        botaoSOS.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        botaoSOS.setEnabled(false);
        sosButtonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        sosButtonPanel.add(botaoSOS);

        frame.add(sosButtonPanel, BorderLayout.SOUTH);




        JButton buttomenu = new JButton("Menu");
        buttomenu.setBackground(new Color(0, 58, 106));
        buttomenu.setForeground(Color.WHITE);
        buttomenu.setPreferredSize(buttomenu.getPreferredSize());
        JPanel botaoMenuPanel = new JPanel();
        botaoMenuPanel.add(buttomenu);

        painelSuperior.add(botaoMenuPanel, BorderLayout.EAST);
        MenuApp abriuMenu=new MenuApp();
        buttomenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent m){
               abriuMenu.abrirMenu();
            }
        });


        listaLugares.setSelectedItem(null);
        listaOcorrencias.setSelectedItem(null);

        listaOcorrencias.setEnabled(false);
        listaLugares.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listaLugares.getSelectedItem() != null) {
                    listaOcorrencias.setEnabled(true);
                } else {
                    listaOcorrencias.setEnabled(false);
                    botaoSOS.setEnabled(false);
                }
            }
        });

        listaOcorrencias.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botaoSOS.setEnabled(listaOcorrencias.getSelectedItem() != null);
            }
        });


        frame.setVisible(true);
    }

    private boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BotaoSOSGUI();
            }
        });
    }
}



