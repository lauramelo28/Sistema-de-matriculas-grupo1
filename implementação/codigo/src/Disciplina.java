import java.util.List;

public class Disciplina {
    //#region ATRIBUTOS
    private String nome;
    private boolean ativa;
    private List<Aluno> alunosMatriculadas;
    private boolean periodoDeInscricaoLiberado;
    private Curso curso;

    private static final int MIN_DE_ALUNOS = 3;
    private static final int MAX_DE_ALUNOS = 60;
    //#endregion

    //#region MÉTODOS
    public void adicionarAluno(Aluno aluno){
        //Implementação do método
    }

    public void adicionarProfessor(Professor professor){
        //Implementação do método
    }

    public void encerrarDisciplina(){
        //Implementação do método
    }

    public List<Aluno> listarAlunosMatriculados(){
        //Implementação do método
        return null;
    }

    public boolean disciplinaAtiva(){
        //Implementação do método
        return false;
    }

    public boolean inscricaoLiberada(boolean liberarInscricao){
        //Implementação do método
        return false;
    }
    //#endregion
}
