import java.util.List;

public class Aluno extends Usuario {

    //#region ATRIBUTOS
    private String matricula;
    private String nomeCurso;
    private List<Disciplina> disciplinasMatriculadas;

    private static final int MAX_DE_DISCIPLINAS = 4;

    public Aluno(String nome, String cpf, String dataNascimento, String login, String senha, boolean estaLogado) {
        super(nome, cpf, dataNascimento, login, senha, estaLogado);
        this.matricula = matricula;
        this.nomeCurso = nomeCurso;
    }
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

