import java.util.List;

public class Professor extends Usuario {
    public Professor(String nome, String cpf, String dataNascimento, String login, String senha) {
        super(nome, cpf, dataNascimento, login, senha);
        //TODO Auto-generated constructor stub
    }

    //#region ATRIBUTOS
    private List<Disciplina> disciplinas;
    private double horarioDaAula;
    //#endregion

    //#region MÉTODOS
    public List<Aluno> verificarAlunosEmDisciplina(){
        //Implementação do método
        return null;
    }
    //#endregion
}
