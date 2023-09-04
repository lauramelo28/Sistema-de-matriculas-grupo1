import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
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
        System.out.println("Observacao (apenas para teste do sistema): Dados para logar como secretaria no arquivo 'usuarios.csv' login: carlos.alberto e senha: 159@alberto");
        System.out.print("\nDigite sua opção: ");
        int opcao = Integer.parseInt(teclado.nextLine());

        return opcao;
    }

    // Menu para o Aluno
    private static void menuAluno() {
        System.out.println("Menu App Aluno");
        System.out.println("=================================================");
        System.out.println("1 - Realizar matricula em discplina");
        System.out.println("2 - Cancelar matricula em discplina");
        System.out.println("=================================================");

    }

    private static void menuSecretaria() {
        limparTela();

        System.out.println("Menu App Secretaria");
        System.out.println("=================================================");
        System.out.println("| 1 - Cadastrar aluno                           |");
        System.out.println("| 2 - Cadastrar professor                       |");
        System.out.println("| 3 - Adicionar membro a secretaria             |");
        System.out.println("| 3 - Gerar currículo do semestre");
        System.out.println("| 4 - Cancelar matricula em discplina");
        System.out.println("=================================================");

        System.out.print("\nDigite sua opção: ");
        int opcao = Integer.parseInt(teclado.nextLine());

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
            default:
                break;
        }

    }

    private static void menuProfessor() {
        System.out.println("Menu App Professor");
        System.out.println("=================================================");

        System.out.println("=================================================");

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

        switch(tipoCadastro){
            case"Aluno":
                System.out.print("Nome do Curso: ");
                nomeCurso = teclado.nextLine();
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
}