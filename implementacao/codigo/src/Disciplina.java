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
    private int semestre;
    private static final int MIN_DE_ALUNOS = 3;
    private static final int MAX_DE_ALUNOS = 60;
    private TipoDisciplina TipoDisciplina;
    //#endregion

    //#region CONSTRUTORES
    public Disciplina(String nome, int numeroDeCreditos, Curso curso, int semestre, TipoDisciplina tipoDisciplina){
        this.nome = nome;
        this.numeroDeCreditos = numeroDeCreditos;
        this.curso = curso;
        this.semestre = semestre;
        this.TipoDisciplina = tipoDisciplina;
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
    public TipoDisciplina getTipoDisciplina(){
        return this.TipoDisciplina;
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
