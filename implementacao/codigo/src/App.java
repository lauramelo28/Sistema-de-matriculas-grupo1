import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class App {
    static Scanner teclado = new Scanner(System.in);
    static Universidade universidade = new Universidade("Puc Minas");

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
                    realizarLogin();
                    break;
                case 2:
                    realizarCadastro();
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
        System.out.println("=================================================");
        System.out.println("| 1 - Realizar login                            |");
        System.out.println("| 2 - Realizar logoff                           |");
        System.out.println("| 0 - Sair                                      |");
        System.out.println("=================================================");
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
        System.out.println("Menu App Secretaria");
        System.out.println("=================================================");
        System.out.println("1 - Gerar currículo do semestre");
        System.out.println("2 - Cancelar matricula em discplina");
        System.out.println("=================================================");

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

    // Metodo para cadastrar um cliente na plataforma
    public static void realizarCadastro() {
        String nome, nomeUsuario, senha;
        System.out.println("==========================");
        System.out.println("--Cadastro de Cliente--");

        System.out.println("Nome: ");
        nome = teclado.nextLine();
        System.out.println("login: ");
        nomeUsuario = teclado.nextLine();
        System.out.println("Senha: ");
        senha = teclado.nextLine();
    }

    // Metodo para realizar o login de um cliente na plataforma
    public static void realizarLogin() {
        System.out.println("==========================");
        System.out.println("--Realizando login--");

        System.out.println("Digite seu login: ");
        String login = teclado.nextLine();
        
        System.out.println("Digite sua senha: ");
        String senha = teclado.nextLine();

        universidade.realizarLogin(login, senha);
    }

    // Metodo para realizar o logoff de um cliente na plataforma
    public static void realizarLogoff() {
        // Usuario.realizarLogoff();
        System.out.println("==========================");
        System.out.println("--Realizado logoff--");
        pausa();
    }

}
