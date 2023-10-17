public class User {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String showInputDialog) {
    }

    public String getMatricula() {
        return null;
    }
}

class UserAluno extends User {
    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    
    public String getMatriculaExterno() {
        return getMatricula();
    }
}
