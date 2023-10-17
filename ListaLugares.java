import javax.swing.*;
import java.awt.*;

public class ListaLugares {
    public JComboBox<String> listaLugares;

    public ListaLugares() {
        // Inicialize o JComboBox e adicione os itens
        String[] lugares = { "Entrada Principal", "Entrada de Automóveis", "Didática I", "Didática II", "Didática III",
                "Didática IV", "Didática V", "Didática VI", "Didática VII", "Resun", "Biblioteca", "Auditório",
                "Reitoria", "Laboratório" };
        listaLugares = new JComboBox<>(lugares);
        listaLugares.setPreferredSize(new Dimension(400, listaLugares.getPreferredSize().height));
    }

    public JComboBox<String> getListaLugares() {
        return listaLugares;
    }
}

