import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner teclado = new Scanner(System.in);
    static Universidade universidade = new Universidade("Puc Minas");
    static Aluno alunoLogado;
    static Professor professorLogado;
    static Secretaria secretariaLogada;

    public static void main(String[] args) {
        int opcao;
        try {
            universidade.carregarUsuarios();
            universidade.carregarCursos();
            universidade.carregarDisciplinas();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        do {
            opcao = menuUniversidade();
            limparTela();
            switch (opcao) {
                case 1:
                    if (logarComoAluno()) {
                        menuAluno();
                    }
                    break;
                case 2:
                    if (logarComoProfessor()) {
                        menuProfessor();
                    }
                    break;
                case 3:
                    if (logarComoSecretaria()) {
                        menuSecretaria();
                    }
                    break;
                default:
                    break;
            }
            pausa();
        } while (opcao != 0);
        System.out.println("Obrigado! Ate breve :)");
    }

    // Menu geral da universidade
    public static int menuUniversidade() {
        limparTela();
        System.out.println("Menu Sistema de Matriculas");
        System.out.println("====================================================");
        System.out.println("| 1 - Area do aluno                                |");
        System.out.println("| 2 - Area do professor                            |");
        System.out.println("| 3 - Area da secretaria                           |");
        System.out.println("| 0 - Sair                                         |");
        System.out.println("====================================================");
        System.out.println(
                "Observacao (apenas para teste do sistema): Dados para logar como secretaria no arquivo 'usuarios.csv' login: carlos.alberto e senha: 159@alberto");
        System.out.print("\nDigite sua opção: ");
        int opcao = Integer.parseInt(teclado.nextLine());

        return opcao;
    }

    private static int opcoesAluno() {
        limparTela();
        int opcao = -1;
        do {
            System.out.println("Menu App Aluno");
            System.out.println("=================================================");
            System.out.println("| 1 - Realizar matricula em discplina            |");
            System.out.println("| 2 - Cancelar matricula em disciplina           |");
            System.out.println("| 3 - Listar disciplinas do curso                |");
            System.out.println("| 4 - Listar disciplinas matriculadas            |");
            System.out.println("| 5 - Valor total do semestre                    |");
            System.out.println("| 0 - Sair                                       |");
            System.out.println("=================================================");

            System.out.print("\nDigite sua opção: ");
            try {
                opcao = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida.");
            }
        } while (!(opcao >= 0 && opcao <= 9));

        return opcao;

    }

    // Menu para o Aluno
    private static void menuAluno() {
        int opcao = opcoesAluno();
        do {
            switch (opcao) {
                case 1:
                    matricularDisciplina();
                    break;
                case 2:
                    cadastrarUsuario("Professor");
                    break;
                case 3:
                    listarDisciplinasCurso(alunoLogado.getNomeCurso());
                    pausa();
                    break;
                case 4:
                    listarDisciplinasMatriculadas();
                    pausa();
                    break;
                case 5:
                    System.out.println("Valor total do semestre: " + alunoLogado.cobranca());
                    pausa();
                    break;
                default:
                    break;
            }
            opcao = opcoesAluno();
        } while (opcao != 0);
        realizarLogoff();

    }

    private static int opcoesSecretaria() {
        limparTela();
        int opcao = -1;
        do {
            System.out.println("Menu App Secretaria");
            System.out.println("=================================================");
            System.out.println("| 1 - Cadastrar aluno                            |");
            System.out.println("| 2 - Cadastrar professor                        |");
            System.out.println("| 3 - Adicionar membro a secretaria              |");
            System.out.println("| 4 - Cadastrar curso                            |");
            System.out.println("| 5 - Adicionar disciplinas a curso              |");
            System.out.println("| 6 - Listar cursos                              |");
            System.out.println("| 7 - Listar disciplinas de um curso             |");
            System.out.println("| 8 - Vincular professor a disciplina            |");
            System.out.println("| 4 - Cancelar matricula em discplina");
            System.out.println("| 0 - Sair");
            System.out.println("=================================================");

            System.out.print("\nDigite sua opção: ");
            try {
                opcao = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida.");
            }
        } while (!(opcao >= 0 && opcao <= 9));

        return opcao;

    }

    private static void menuSecretaria() {
        int opcao = opcoesSecretaria();
        do {
            switch (opcao) {
                case 1:
                    cadastrarUsuario("Aluno");
                    break;
                case 2:
                    cadastrarUsuario("Professor");
                    break;
                case 3:
                    cadastrarUsuario("Secretaria");
                    break;
                case 4:
                    cadastrarCurso();
                    break;
                case 5:
                    vincularDisciplinasCurso();
                    break;
                case 6:
                    listarCursos();
                    pausa();
                    break;
                case 7:
                    listarDisciplinasCurso(null);
                    pausa();
                    break;
                case 8:
                    vincularProfessorDisciplina();
                    pausa();
                    break;
                default:
                    break;
            }
            opcao = opcoesSecretaria();
        } while (opcao != 0);
        realizarLogoff();
    }

    private static void menuProfessor() {
        int opcao = opcoesProfessor();
        do {
            switch (opcao) {
                case 1:
                    cadastrarUsuario("Professor");
                    break;
                case 2:
                    verificarAlunosEmDisciplina();
                    break;
                case 3:
                    listarDisciplinasProfessor();
                    break;
                default:
                    break;
            }
            opcao = opcoesProfessor();
        } while (opcao != 0);
        realizarLogoff();

    }


    private static void verificarAlunosEmDisciplina() {
        listarDisciplinasProfessor();
        System.out.print("\nDigite o nome da disciplina: ");
        String nome = teclado.nextLine();
        Disciplina disciplina = professorLogado.getDisciplina(nome);
        System.out.println("\n" + disciplina.listarAlunosMatriculados());
    }

    private static int opcoesProfessor() {
        limparTela();
        int opcao = -1;
        do {
            System.out.println("Menu App Professor");
            System.out.println("=================================================");
            System.out.println("| 1 - Cadastrar professor                        |");
            System.out.println("| 2 - Listar alunos na disciplina                |");
            System.out.println("| 3 - Listar disciplinas                         |");
            System.out.println("| 0 - Sair");
            System.out.println("=================================================");

            System.out.print("\nDigite sua opção: ");
            try {
                opcao = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida.");
            }
        } while (!(opcao >= 0 && opcao <= 9));

        return opcao;
    }

    // metodo que limpa a tela no terminal
    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // metodo que faz uma pausa
    static void pausa() {
        System.out.println("Enter para continuar.");
        teclado.nextLine();
    }


    private static void listarDisciplinasProfessor() {
        System.out.println("Disciplinas disponiveis: ");
        try{
            for(Disciplina disciplina : professorLogado.listarDisciplinas()){
            System.out.println(disciplina.getNome());
        }
        }catch(Exception e){
            System.out.println("Professor não possui disciplinas");
        }
    }

    // Metodo para realizar o login de um aluno
    public static boolean logarComoAluno() {
        System.out.println("============ALUNO============");
        System.out.println("------ Realize o login ------");

        System.out.print("Digite seu nome de usuario: ");
        String login = teclado.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = teclado.nextLine();

        boolean loginEfetuado = false;
        try {
            alunoLogado = (Aluno) universidade.realizarLogin(login, senha);

            if (alunoLogado == null) {
                System.out.println("Login ou senha invalidos, tente logar novamente");
                return false;
            }

            loginEfetuado = true;
        } catch (ClassCastException e) {
            System.out.println("Erro ao fazer cadastro como aluno, tente novamente");
        }

        return loginEfetuado;
    }

    // Metodo para realizar o login de um professor
    public static boolean logarComoProfessor() {
        System.out.println("============PROFESSOR============");
        System.out.println("-------- Realize o login --------");

        System.out.print("Digite seu nome de usuario: ");
        String login = teclado.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = teclado.nextLine();

        boolean loginEfetuado = false;
        try {
            professorLogado = (Professor) universidade.realizarLogin(login, senha);

            if (professorLogado == null) {
                System.out.println("Login ou senha invalidos, tente logar novamente");
                return false;
            }

            loginEfetuado = true;
        } catch (ClassCastException e) {
            System.out.println("Erro ao fazer cadastro como professor, tente novamente");
        }
        return loginEfetuado;
    }

    // Metodo para realizar o login de um aluno
    public static boolean logarComoSecretaria() {
        System.out.println("============SECRETARIA============");
        System.out.println("-------- Realize o login ---------");

        System.out.print("Digite seu nome de usuario: ");
        String login = teclado.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = teclado.nextLine();

        boolean loginEfetuado = false;
        try {
            secretariaLogada = (Secretaria) universidade.realizarLogin(login, senha);

            if (secretariaLogada == null) {
                System.out.println("Login ou senha invalidos, tente logar novamente");
                return false;
            }

            loginEfetuado = true;
        } catch (ClassCastException e) {
            System.out.println("Erro ao fazer cadastro como secretaria, tente novamente");
        }
        return loginEfetuado;
    }

    // Metodo para realizar o logoff de um cliente na plataforma
    public static void realizarLogoff() {
        // Usuario.realizarLogoff();
        System.out.println("==========================");
        System.out.println("---- Realizado logoff----");
        universidade.realizarLogoff();
        pausa();
    }

    // Metodo para cadastrar alunos e professores no sistema
    public static void cadastrarUsuario(String tipoCadastro) {
        String nome, cpf, dataNascimento, nomeUsuario, senha, nomeCurso;

        System.out.println("===========================");
        System.out.println("-------- Cadastro  --------");

        System.out.print("Nome: ");
        nome = teclado.nextLine();

        System.out.print("CPF: ");
        cpf = teclado.nextLine();

        System.out.print("Data de Nascimento: ");
        dataNascimento = teclado.nextLine();

        System.out.print("Nome de Usuario: ");
        nomeUsuario = teclado.nextLine();

        System.out.print("Senha: ");
        senha = teclado.nextLine();

        switch (tipoCadastro) {
            case "Aluno":
                System.out.print("Nome do Curso: ");
                nomeCurso = teclado.nextLine();
                while (!existeCurso(nomeCurso)){
                    System.out.print("Curso nao encontrado, digite novamente: ");
                    nomeCurso = teclado.nextLine();
                }

                try {
                    universidade.adicionarAluno(nome, cpf, dataNascimento, nomeUsuario, senha, nomeCurso);
                } catch (ClassCastException | IOException e) {
                    System.out.println("Erro ao cadastrar aluno: " + e);
                }
                break;
            case "Professor":
                System.out.print("Nome do Curso: ");
                nomeCurso = teclado.nextLine();
                try {
                    universidade.adicionarProfessor(nome, cpf, dataNascimento, nomeUsuario, senha, nomeCurso);
                } catch (ClassCastException | IOException e) {
                    System.out.println("Erro ao cadastrar professor: " + e);
                }
                break;
            case "Secretaria":
                try {
                    universidade.adicionarSecretaria(nome, cpf, dataNascimento, nomeUsuario, senha);
                } catch (ClassCastException | IOException e) {
                    System.out.println("Erro ao cadastrar secretaria: " + e);
                }
                break;
            default:
                break;
        }
    }

    // Metodo para cadastrar curso
    private static void cadastrarCurso() {
        String nome;
        int numeroDeCreditos;
        List<Disciplina> disciplinas = new LinkedList<Disciplina>();

        System.out.println("===========================");
        System.out.println("---- Cadastro de Curso ----");

        System.out.print("Nome: ");
        nome = teclado.nextLine();

        System.out.print("Numero de Creditos: ");
        numeroDeCreditos = Integer.parseInt(teclado.nextLine());

        Curso curso = universidade.adicionarCurso(nome, numeroDeCreditos);
        if(curso != null){
            try {
                Universidade.salvarDadosNoArquivo("cursos", curso);
            } catch (IOException e) {
                System.out.println("Erro ao salvar dado no arquivo" + e);
            }
        }

        System.out.print("Deseja Adicionar Disciplinas ao Curso? (1- Sim | Outro digito para sair): ");
        String opcao = teclado.nextLine();

        if (opcao.equals("1")) {
            disciplinas = cadastrarDisciplinas(curso);
            universidade.cadastrarDisciplina(disciplinas);
        }
    }

    // Metodo para cadastrar disciplinas
    private static List<Disciplina> cadastrarDisciplinas(Curso curso) {
        String nome, tipoDisciplina;
        int numeroDeCreditos, semestre;
        List<Disciplina> disciplinas = new LinkedList<Disciplina>();

        System.out.println("================================");
        System.out.println("---- Cadastro de Disciplina ----");

        boolean adicionarDisciplinas = true;

        do {
            System.out.print("Nome: ");
            nome = teclado.nextLine();

            System.out.print("Numero de Creditos: ");
            numeroDeCreditos = Integer.parseInt(teclado.nextLine());

            System.out.print("Semestre: ");
            semestre = Integer.parseInt(teclado.nextLine());

            System.out.println("Tipos de Disciplina: ");
            int contador = 0;
            for (TipoDisciplina tipo : TipoDisciplina.values()) {
                System.out.println("[" + ++contador + "] " + tipo.toString());
            }

            System.out.print("\nOpcao: ");
            int opcaoDisciplina = Integer.parseInt(teclado.nextLine());

            while (opcaoDisciplina != 1 && opcaoDisciplina != 2) {
                System.out.print("Valor invalido, opcao: ");
                opcaoDisciplina = Integer.parseInt(teclado.nextLine());
            }

            tipoDisciplina = TipoDisciplina.values()[opcaoDisciplina - 1].toString();

            Disciplina disciplina = new Disciplina(nome, numeroDeCreditos, curso, semestre, tipoDisciplina);
            disciplinas.add(disciplina);
            try {
                Universidade.salvarDadosNoArquivo("disciplinas", disciplina);
            } catch (IOException e) {
                System.out.println("Erro ao salvar dado no arquivo" + e);
            }
            System.out.print("1- Para adicionar mais disciplinas | Outro digito para sair: ");
            String opcao = teclado.nextLine();
            adicionarDisciplinas = opcao.equals("1") ? true : false;
        } while (adicionarDisciplinas);

        System.out.println("================================");
        return disciplinas;
    }

    private static void vincularDisciplinasCurso() {
        listarCursos();
        System.out.print("Nome curso: ");
        String nomeCurso = teclado.nextLine();

        List<Disciplina> disciplinas = new LinkedList<Disciplina>();
        Curso curso = universidade.buscarCurso(nomeCurso);
        if (curso != null) {
            disciplinas = cadastrarDisciplinas(curso);
            universidade.cadastrarDisciplina(disciplinas);
        } else {
            System.out.println("Curso nao encontrado");
        }
    }

    private static void listarCursos() {
        System.out.println(universidade.listarCursos());
    }

    private static void listarDisciplinasCurso(String nomeCurso) {
        listarCursos();
        if(nomeCurso == null){
            System.out.print("Nome do curso para exibir as disciplinas: ");
            nomeCurso = teclado.nextLine();
        }

        Curso curso = universidade.buscarCurso(nomeCurso);
        if (curso != null) {
            System.out.println(universidade.listarDisciplinasCurso(curso));
        } else {
            System.out.println("Curso nao encontrado");
        }
    }

    private static void vincularProfessorDisciplina() {
        System.out.print("Nome professor: ");
        String nomeProfessor = teclado.nextLine();

        System.out.print("Nome da disciplina: ");
        String nomeDisciplina = teclado.nextLine();

        universidade.vincularProfessorDisciplina(nomeProfessor, nomeDisciplina);
    }

    private static void matricularDisciplina() {
        String nomeCurso = alunoLogado.getNomeCurso();
        Curso curso = universidade.buscarCurso(nomeCurso);

        System.out.println("Disciplinas disponiveis: ");
        listarDisciplinasCurso(nomeCurso);

        System.out.print("Disciplina que deseja se matricular: ");
        String nomeDisciplina = teclado.nextLine();

        Disciplina disciplina = curso.buscarDisciplina(nomeDisciplina);

        if (!disciplina.disciplinaDisponivel()) {
            System.out.println("Disciplina nao disponivel para inscricoes");
        } else {
            try {
                alunoLogado.matricularNaDisciplina(disciplina);
                disciplina.adicionarAluno(alunoLogado);
                System.out.println("Matricula efetuada");
            } catch (IllegalArgumentException e) {
                System.out.println(
                        "Nao foi possivel se matricular na disciplina " + nomeDisciplina + "\n" + e.getMessage());
            }
        }

    }

    private static void listarDisciplinasMatriculadas(){
        System.out.println(alunoLogado.toStringDisciplinasMatriculadas());
    }

    private static boolean existeCurso(String cursoDigitado){
        Curso curso = universidade.buscarCurso(cursoDigitado);

        if (curso != null) {
            return true;
        }
        else{
            return false;
        }
    }
}