import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TiposDeOcorrencia extends JFrame {
    private List<String> ocorrenciaSOS;
    private JComboBox<String> listaTipos;
    private JTextArea descricaoArea;

    public TiposDeOcorrencia() {
        ocorrenciaSOS = new ArrayList<>();
        listaTipos = new JComboBox<>(new String[]{"Incêndio", "Assalto", "Atitude Suspeita", "Iluminação Prejudicada", "Se Perdeu", "Outro Tipo de Ocorrência"});
        descricaoArea = new JTextArea(5, 30);

        JButton adicionarTipoButton = new JButton("Adicionar Tipo");
        adicionarTipoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTipo();
            }
        });

        setLayout(new FlowLayout());

        add(new JLabel("Selecione o Tipo de Ocorrência: "));
        add(listaTipos);
        add(adicionarTipoButton);
        add(new JLabel("Descrição: "));
        add(new JScrollPane(descricaoArea));
    }

    public void adicionarTipo() {
        String tipo = (String) listaTipos.getSelectedItem();
        if (!ocorrenciaSOS.contains(tipo)) {
            ocorrenciaSOS.add(tipo);
            JOptionPane.showMessageDialog(this, "Tipo de ocorrência adicionado com sucesso: " + tipo);
        } else {
            JOptionPane.showMessageDialog(this, "Esse tipo de ocorrência já foi adicionado.");
        }
    }

    public static void main(String[] args) {
        TiposDeOcorrencia frame = new TiposDeOcorrencia();
        frame.setTitle("Tipos de Ocorrência");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
