import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Universidade {
    // #region ATRIBUTOS
    private String nome;
    private List<Usuario> usuarios;
    private Usuario usuarioLogado;

    private static final int MAX_DE_DISCIPLINAS = 4;

    public Universidade(String nome) {
        this.nome = nome;
    }

    public Usuario realizarLogin(String loginDigitado, String senhaDigitada) {
        Usuario usuario = this.usuarios.stream()
                .filter(a -> a.getLogin().equals(loginDigitado) && a.getSenha().equals(senhaDigitada))
                .findFirst()
                .orElse(null);

        this.usuarioLogado = usuario;

        return usuario;
    }

    public void realizarLogoff() {
        this.usuarioLogado = null;
    }

    public void carregarUsuarios() throws FileNotFoundException {
        try {
            LinkedList<String> listaUsuarios = new LinkedList<>();

            File arquivoUsuarios = new File("./implementacao/codigo/src/utils/usuarios.csv");
            Scanner entrada = new Scanner(arquivoUsuarios, "UTF-8");
            String linha = entrada.nextLine();
            while (entrada.hasNextLine()) {
                listaUsuarios.add(linha);
                linha = entrada.nextLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo de usuarios nao encontrado");
        }
    }

    public void processarUsuarios(LinkedList<String> listaUsuarios){
        for(String usuario : listaUsuarios){
            String[] dadosUsuario = usuario.split(";");
            String tipoUsuario = dadosUsuario[0];
            String nome = dadosUsuario[1];
            String cpf = dadosUsuario[2];
            String dataNascimento = dadosUsuario[3];
            String login = dadosUsuario[4];
            String senha = dadosUsuario[5];
            String curso;
            switch(tipoUsuario){
                case "Aluno":
                    String matricula = dadosUsuario[6];
                    curso = dadosUsuario[7];
                    adicionarAluno(nome, cpf, dataNascimento, login, senha, matricula, curso);
                    break;
                case "Professor":
                    curso = dadosUsuario[6];
                    adicionarProfessor(nome, cpf, dataNascimento, login, senha, curso);
                case "Secretaria":
                    adicionarSecretaria(nome, cpf, dataNascimento, login, senha);
            }
        }
    }

    private void adicionarAluno(String nome, String cpf, String dataNascimento, String login, String senha, String matricula, String curso){
        Aluno aluno = new Aluno(nome, cpf, dataNascimento, login, senha, matricula, curso);
        this.usuarios.add(aluno);
    }

    private void adicionarProfessor(String nome, String cpf, String dataNascimento, String login, String senha, String curso){
        Professor professor = new Professor(nome, cpf, dataNascimento, login, senha, curso);
        this.usuarios.add(professor);
    }

    public void adicionarSecretaria(String nome, String cpf, String dataNascimento, String login, String senha){
        Secretaria secretaria = new Secretaria(nome, cpf, dataNascimento, login, senha);
        this.usuarios.add(secretaria);
    }
}