import java.util.List;

public class Aluno extends Usuario {

    public Aluno(String nome, String cpf, String dataNascimento, String login, String senha) {
        super(nome, cpf, dataNascimento, login, senha);
    }

    //#region ATRIBUTOS
    private String matricula;
    private String nomeCurso;
    private List<Disciplina> disciplinasMatriculadas;

    private static final int MAX_DE_DISCIPLINAS = 4;
    //#endregion

    public String getNome(){
        return super.nome;
    }

    public String getMatricula(){
        return this.matricula;
    }

    //#region MÉTODOS
    public int gerenciarCreditos(){
        //Implementação do método
        return 0;
        
    }

    public void matricularNoCurso(String nomeCurso){
        //Implementação do método
    }

    public void matricularNaDisciplina(Disciplina disciplina){
        this.disciplinasMatriculadas.add(disciplina);
    }

    public void cancelarMatricula(Disciplina disciplina){
        this.disciplinasMatriculadas.remove(disciplina);
    }

    public List<Disciplina> listarDisciplinas(){
        return this.disciplinasMatriculadas;
    }

    public void realizarLogin(){
        //Implementação do método
    }

    public void realizarLogoff(){
        //Implementação do método
    }
    //#endregion
}

