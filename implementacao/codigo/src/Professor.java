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
    /**
     * Método para listar os alunos em determinada disciplina do professor
     * @param Disciplina disciplina
     */
    public void verificarAlunosEmDisciplina(Disciplina disciplina){
        disciplina.listarAlunosMatriculados();
    }

    public void novaDisciplina(Disciplina disciplina){
        disciplinas.add(disciplina);
    }
    //#endregion
}
