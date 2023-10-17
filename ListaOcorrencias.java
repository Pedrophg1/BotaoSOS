import javax.swing.*;
import java.awt.*;

public class ListaOcorrencias extends JPanel {
    public ListaOcorrencias() {
        setLayout(new GridLayout(2, 1));
        JLabel labelSelecionarOcorrencia = new JLabel("Selecione abaixo o tipo de ocorrência:");
        labelSelecionarOcorrencia.setFont(new Font("Montserrat", Font.BOLD, 14));
        labelSelecionarOcorrencia.setHorizontalAlignment(JLabel.CENTER);
        add(labelSelecionarOcorrencia, BorderLayout.NORTH);

        String[] ocorrencias = { "Incêndio", "Assalto", "Atitude Suspeita", "Iluminação Prejudicada", "Se Perdeu", "Outro Tipo de Ocorrência(use a caixa de descrição)" };
        JComboBox<String> listaOcorrencias = new JComboBox<>(ocorrencias);
        listaOcorrencias.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        listaOcorrencias.setPreferredSize(new Dimension(400, listaOcorrencias.getPreferredSize().height));
        add(listaOcorrencias);
    }
}
