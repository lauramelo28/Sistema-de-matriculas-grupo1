import java.util.List;

public class Professor extends Usuario {
   
    //#region ATRIBUTOS
    private List<Disciplina> disciplinas;
    private double horarioDaAula;
    private String curso;

    public Professor(String nome, String cpf, String dataNascimento, String login, String senha, String curso) {
        super(nome, cpf, dataNascimento, login, senha);
        this.curso = curso;
    }
    //#endregion

    //#region MÉTODOS
    public List<Aluno> verificarAlunosEmDisciplina(){
        //Implementação do método
        return null;
    }

    //#endregion
}
