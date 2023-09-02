import java.util.List;

public class Professor extends Usuario {
   
    //#region ATRIBUTOS
    private List<Disciplina> disciplinas;
    private double horarioDaAula;

    public Professor(String nome, String cpf, String dataNascimento, String login, String senha, boolean estaLogado) {
        super(nome, cpf, dataNascimento, login, senha, estaLogado);
        this.horarioDaAula = horarioDaAula;
    }
    //#endregion

    //#region MÉTODOS
    public List<Aluno> verificarAlunosEmDisciplina(){
        //Implementação do método
        return null;
    }


    @Override
    public boolean realizarLogin(String loginDigitado, String senhaDigitada) {
        if (this.login.equals(loginDigitado) && this.senha.equals(senhaDigitada)) {
            this.logado = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void realizarLogoff() {
        if (logado) {
            this.logado = false;
        } 
    }

    @Override
    public boolean EstaLogado() {
        return logado;
    }

    //#endregion
}
