import java.util.LinkedList;
import java.util.List;

public class Disciplina {
    //#region ATRIBUTOS
    private String nome;
    private boolean ativa;
    private List<Aluno> alunosMatriculados;
    private Professor professor;
    private boolean periodoDeInscricaoLiberado = true; 
    private Curso curso;
    private int numeroDeCreditos;
    private int semestre;
    private static final int MIN_DE_ALUNOS = 3;
    private static final int MAX_DE_ALUNOS = 60;
    private String tipoDisciplina;
    //#endregion

    //#region CONSTRUTORES
    public Disciplina(String nome, int numeroDeCreditos, Curso curso, int semestre, String tipoDisciplina){
        this.nome = nome;
        this.numeroDeCreditos = numeroDeCreditos;
        this.curso = curso;
        this.semestre = semestre;
        this.tipoDisciplina = tipoDisciplina;
        this.alunosMatriculados = new LinkedList<Aluno>();
    }
    //#region MÉTODOS
    public String getNome(){
        return this.nome;
    }
    public boolean getAtiva(){
        return this.ativa;
    }
    public List<Aluno> getAlunosMatriculados(){
        return this.alunosMatriculados;
    }
    public Professor getProfessor(){
        return this.professor;
    }
    public Curso getCurso(){
        return this.curso;
    }
    public int getSemestre(){
        return this.semestre;
    }
    public String getTipoDisciplina(){
        return this.tipoDisciplina;
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

    public boolean disciplinaDisponivel(){
        if((this.alunosMatriculados.size() > MIN_DE_ALUNOS && this.alunosMatriculados.size() < MAX_DE_ALUNOS && !periodoDeInscricaoLiberado) || periodoDeInscricaoLiberado){
            this.ativa = true;
            return true;
        }else{
            this.ativa = false;
            return false;
        }
    }

    public String formatDisciplinas(){
        return this.nome + " | " + this.tipoDisciplina + " | Creditos:" + this.numeroDeCreditos;
    }

    public String toString(){
        return this.curso.getNome() + ";" + this.nome + ";" + this.numeroDeCreditos + ";" + this.semestre + ";" + this.tipoDisciplina;
    }
    //#endregion
}