import java.util.List;

public class Disciplina {
    //#region ATRIBUTOS
    private String nome;
    private boolean ativa;
    private List<Aluno> alunosMatriculados;
    private Professor professor;
    private boolean periodoDeInscricaoLiberado; 
    private Curso curso;
    private int numeroDeCreditos;
    private static final int MIN_DE_ALUNOS = 3;
    private static final int MAX_DE_ALUNOS = 60;
    //#endregion

    //#region CONSTRUTORES
    public Disciplina(String nome, int numeroDeCreditos, Curso curso){
        this.nome = nome;
        this.numeroDeCreditos = numeroDeCreditos;
        this.curso = curso;
    }
    //#region MÉTODOS
    public String getNome(){
        return this.nome;
    }
    public int getNumeroDeCreditos(){
        return this.numeroDeCreditos;
    }
    public boolean adicionarAluno(Aluno aluno){
        if(disciplinaDisponivel()){
            this.alunosMatriculados.add(aluno);
            return true;
        }else{
            return false;
        }
    }

    public void adicionarProfessor(Professor professor){
        this.professor = professor;
    }

    public void encerrarDisciplina(){
        this.ativa = false;
    }

    public String listarAlunosMatriculados(){
        String alunosListados = "";
        for(Aluno aluno: alunosMatriculados){
           alunosListados += aluno.getNome() + "\n" + aluno.getMatricula() + "\n";
        }
        return alunosListados;
    }

    public void inscricaoLiberada(boolean liberarInscricao){
        this.periodoDeInscricaoLiberado = liberarInscricao;
    }

    private boolean disciplinaDisponivel(){
        if(this.alunosMatriculados.size() > MIN_DE_ALUNOS && this.alunosMatriculados.size() < MAX_DE_ALUNOS && periodoDeInscricaoLiberado){
            this.ativa = true;
            return true;
        }else{
            this.ativa = false;
            return false;
        }
    }    
    //#endregion
}
