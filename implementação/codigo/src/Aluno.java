import java.util.List;

public class Aluno extends Usuario {
    //#region ATRIBUTOS
    private String matricula;
    private String nomeCurso;
    private List<Disciplina> disciplinasMatriculadas;

    private static final int MAX_DE_DISCIPLINAS = 4;
    //#endregion

    //#region MÉTODOS
    public int gerenciarCreditos(){
        //Implementação do método
        return 0;
    }

    public void matricularNoCurso(String nomeCurso){
        //Implementação do método
    }

    public void matricularNaDisciplina(String nomeDisciplina){
        //Implementação do método
    }

    public void cancelarMatricula(String nomeDisciplina){
        //Implementação do método
    }

    public List<Disciplina> listarDisciplinas(){
        //Implementação do método
        return null;
    }
    //#endregion
}

