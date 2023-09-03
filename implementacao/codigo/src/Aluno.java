import java.util.List;

public class Aluno extends Usuario {

    //#region ATRIBUTOS
    private String matricula;
    private String nomeCurso;
    private List<Disciplina> disciplinasMatriculadas;

    private static final int MAX_DE_DISCIPLINAS = 4;

    public Aluno(String nome, String cpf, String dataNascimento, String login, String senha, String matricula, String nomeCurso) {
        super(nome, cpf, dataNascimento, login, senha);
        this.matricula = matricula;
        this.nomeCurso = nomeCurso;
    }
    //#endregion

    public String getLogin(){
        return this.login;
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
        if (verificarQtdDisciplinas()){
            this.disciplinasMatriculadas.add(disciplina);
        }
    }

    public void cancelarDisciplina(Disciplina disciplina){
        this.disciplinasMatriculadas.remove(disciplina);
    }

    public List<Disciplina> listarDisciplinas(){
        return this.disciplinasMatriculadas;
    }

    public boolean verificarQtdDisciplinas(){
        if (this.disciplinasMatriculadas.size() < MAX_DE_DISCIPLINAS) {
            return true;
        } else {
            return false;
        }
    }

    //#endregion
}

