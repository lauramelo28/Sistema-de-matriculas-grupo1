import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Universidade {
    // #region ATRIBUTOS
    private String nome;
    private LinkedList<Usuario> usuarios;
    private LinkedList<Aluno> alunos;
    private LinkedList<Professor> professores;
    private LinkedList<Curso> cursos;
    private Usuario usuarioLogado;

    public Universidade(String nome) {
        this.nome = nome;
        this.usuarios = new LinkedList<Usuario>();
        this.alunos = new LinkedList<Aluno>();
        this.cursos = new LinkedList<Curso>();
        this.professores = new LinkedList<Professor>();
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
            processarUsuarios(listaUsuarios);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo de usuarios nao encontrado");
        }
    }

    public void processarUsuarios(LinkedList<String> listaUsuarios) {
        for (String usuario : listaUsuarios) {
            String[] dadosUsuario = usuario.split(";");
            String tipoUsuario = dadosUsuario[0];
            String nome = dadosUsuario[1];
            String cpf = dadosUsuario[2];
            String dataNascimento = dadosUsuario[3];
            String login = dadosUsuario[4];
            String senha = dadosUsuario[5];
            String curso;
            switch (tipoUsuario) {
                case "Aluno":
                    String matricula = dadosUsuario[6];
                    curso = dadosUsuario[7];
                    Aluno aluno = new Aluno(nome, cpf, dataNascimento, login, senha, matricula, curso);
                    this.usuarios.add(aluno);
                    this.alunos.add(aluno);
                    break;
                case "Professor":
                    curso = dadosUsuario[6];
                    Professor professor = new Professor(nome, cpf, dataNascimento, login, senha, curso);
                    this.usuarios.add(professor);
                    this.professores.add(professor);
                case "Secretaria":
                    Secretaria secretaria = new Secretaria(nome, cpf, dataNascimento, login, senha);
                    this.usuarios.add(secretaria);
            }
        }
    }

    public void adicionarAluno(String nome, String cpf, String dataNascimento, String login, String senha, String curso)
            throws ClassCastException, IOException {
        Secretaria secretaria = (Secretaria) usuarioLogado;
        String matricula = gerarMatriculaUnica();
        Aluno aluno = secretaria.cadastrarAluno(nome, cpf, dataNascimento, nome, senha, matricula, curso);
        this.usuarios.add(aluno);
        this.alunos.add(aluno);
        salvarDadosNoArquivo("usuarios", aluno);
    }

    public void adicionarProfessor(String nome, String cpf, String dataNascimento, String login, String senha,
            String curso) throws IOException {
        Secretaria secretaria = (Secretaria) usuarioLogado;
        Professor professor = secretaria.cadastrarProfessor(nome, cpf, dataNascimento, nome, senha, senha, curso);
        this.usuarios.add(professor);
        this.professores.add(professor);
        salvarDadosNoArquivo("usuarios", professor);
    }

    public void adicionarSecretaria(String nome, String cpf, String dataNascimento, String login, String senha)
            throws IOException {
        Secretaria secretaria = new Secretaria(nome, cpf, dataNascimento, login, senha);
        this.usuarios.add(secretaria);
        salvarDadosNoArquivo("usuarios", secretaria);
    }

    private String gerarMatriculaUnica() {
        Random random = new Random();
        String matricula = null;

        do {
            int numeroMatricula = random.nextInt(900000) + 100000;
            matricula = Integer.toString(numeroMatricula);
        } while (existeAlunoComMatricula(matricula));

        return matricula;
    }

    private boolean existeAlunoComMatricula(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    private static <T> void salvarDadosNoArquivo(String nomeArq, T item) throws IOException {
        FileWriter arquivo = new FileWriter("./implementacao/codigo/src/utils/" + nomeArq + ".csv", true);
        PrintWriter gravarDadoNoArquivo = new PrintWriter(arquivo);
        StringBuilder saida = new StringBuilder();
        saida.append("\n");
        saida.append(item.toString());
        gravarDadoNoArquivo.write(saida.toString());
        arquivo.close();
    }

    public Curso adicionarCurso(String nome, int numeroDeCreditos) {
        Secretaria secretaria = (Secretaria) usuarioLogado;

        Curso curso = secretaria.cadastrarCurso(nome, numeroDeCreditos);
        cursos.add(curso);

        return curso;
    }

    public void cadastrarDisciplina(List<Disciplina> disciplinas) {
        Secretaria secretaria = (Secretaria) usuarioLogado;

        for (Disciplina disciplina : disciplinas) {
            secretaria.cadastrarDisciplina(disciplina, disciplina.getCurso());
        }
    }

    public Curso buscarCurso(String nome) {
        return this.cursos.stream()
                .filter(a -> a.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    public String listarCursos() {
        String listagemCursos = "";
        for (Curso curso : cursos) {
            listagemCursos += curso.toString() + "\n";
        }
        return listagemCursos;
    }

    public String listarDisciplinasCurso(Curso curso) {
        return curso.listarDisciplinas();
    }

    public void vincularProfessorDisciplina(String nomeProfessor, String nomeDisciplina)
            throws IllegalArgumentException {
        Secretaria secretaria = (Secretaria) usuarioLogado;

        Professor professor = buscarProfessor(nomeProfessor);
        Disciplina disciplina = buscarDisciplina(nomeDisciplina);

        if (professor == null || disciplina == null) {
            throw new IllegalArgumentException("Professor ou disciplina não encontrados.");
        } else {
            secretaria.atribuirDisciplinaProfessor(professor, disciplina);
        }
    }

    private Professor buscarProfessor(String nome) {
        return this.professores.stream()
                .filter(a -> a.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    private Disciplina buscarDisciplina(String nome) {
        Curso curso = buscarCurso(nome);
        return curso.buscarDisciplina(nome);
    }

    public void carregarCursos() throws FileNotFoundException {
        try {
            LinkedList<String> listaCursos = new LinkedList<>();

            File arquivoUsuarios = new File("./implementacao/codigo/src/utils/cursos.csv");
            Scanner entrada = new Scanner(arquivoUsuarios, "UTF-8");
            String linha = entrada.nextLine();
            while (entrada.hasNextLine()) {
                listaCursos.add(linha);
                linha = entrada.nextLine();
            }
            entrada.close();
            processarCursos(listaCursos);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo de cursos nao encontrado");
        }
    }

    private void processarCursos(LinkedList<String> listaCursos) {
        for (String cursoLinha : listaCursos) {
            String[] dadosCurso = cursoLinha.split(";");
            String nomeCurso = dadosCurso[0];
            int numeroDeCreditos = Integer.parseInt(dadosCurso[1]);
            Curso curso = new Curso(nomeCurso, numeroDeCreditos);
            this.cursos.add(curso);
        }
    }

    public void carregarDisciplinas() throws FileNotFoundException {
        try {
            LinkedList<String> listaDisciplinas = new LinkedList<>();

            File arquivoUsuarios = new File("./implementacao/codigo/src/utils/disciplinas.csv");
            Scanner entrada = new Scanner(arquivoUsuarios, "UTF-8");
            String linha = entrada.nextLine();
            while (entrada.hasNextLine()) {
                listaDisciplinas.add(linha);
                linha = entrada.nextLine();
            }
            entrada.close();
            processarDisciplinas(listaDisciplinas);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo de disciplinas nao encontrado");
        }
    }

    private void processarDisciplinas(LinkedList<String> listaDisciplinas) {
        for (String disciplinaLinha : listaDisciplinas) {
            String[] dadosDisciplina = disciplinaLinha.split(";");
            String nomeCurso = dadosDisciplina[0];
            String nomeDisciplina = dadosDisciplina[1];
            int numeroDeCreditos = Integer.parseInt(dadosDisciplina[2]);
            int semestre = Integer.parseInt(dadosDisciplina[3]);
            String tipoDisciplina = dadosDisciplina[4];
            Curso curso = buscarCurso(nomeCurso);
            if (curso != null) {
                Disciplina disciplina = new Disciplina(nomeDisciplina, numeroDeCreditos, curso, semestre,
                        tipoDisciplina);
                curso.adicionarDisciplinas(disciplina);
            }

        }
    }
}