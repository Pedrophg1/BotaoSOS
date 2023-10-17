import javax.swing.JOptionPane;
public class MatriculaValidator {
    public static boolean isValidMatricula(String matricula) {
        if (matricula == null || matricula.length() != 12) {
            return false;
        }

        for (char c : matricula.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public static void showMatriculaError() {
        JOptionPane.showMessageDialog(null, "Erro: A matrícula deve ter 12 dígitos numéricos.", "Erro de Matrícula", JOptionPane.ERROR_MESSAGE);
    }
}
