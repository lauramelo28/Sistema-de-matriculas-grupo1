import java.util.List;

public class Curso {
    //#region ATRIBUTOS
    private String nome;
    private int numeroDeCreditos;
    private List<Disciplina> disciplinas;
    private List<Aluno> alunos;
    //#endregion

    //#region CONSTRUTORES
    public Curso(String nome, int numeroDeCreditos, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.numeroDeCreditos = numeroDeCreditos;
        this.disciplinas = disciplinas;
    }
    //#region MÉTODOS
    public String getNome() {
        return nome;
    }
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    public int getNumeroDeCreditos() {
        return numeroDeCreditos;
    }
    /**
     * Método para listar as disciplinas do curso
     * @return String com as disciplinas do curso
     */
    public String listarDisciplinas() {
        String disciplinasListada = "";
        for(Disciplina disciplina : disciplinas){
            disciplinasListada += disciplina.getNome() + "\n" + disciplina.getTipoDisciplina() + "\n";
        }
        return disciplinasListada;
    }

    /**
     * Método para incluir uma disciplina na lista de disciplinas do curso
     * @param disciplina
     */
    public void adicionarDisciplinas(Disciplina disciplina){
        this.disciplinas.add(disciplina);
    }

    public void numeroDeCreditos(){
       for(Disciplina disciplina : disciplinas){
           this.numeroDeCreditos += disciplina.getNumeroDeCreditos();
       }
    }
    public String gerarCurriculoSemestre(int semestre){
        String curriculo = "";
        for(Disciplina disciplina : disciplinas){
            if(disciplina.getSemestre() == semestre){
                curriculo += disciplina.getNome() + "\n";
            }
        }
        return curriculo;
    }
    /**
     * Método para listar os alunos do curso
     * @return String com os alunos do curso
     */
    public String listarAlunos() {
        String alunosListados = "";
        for(Aluno aluno : alunos){
            alunosListados += aluno.getNome() + "\n" + aluno.getMatricula() + "\n";
        }
        return alunosListados;
    }
    /**
     * Método para incluir um aluno na lista de alunos do curso
     */
    public void adicionarAluno(Aluno aluno){
        this.alunos.add(aluno);
    }
    //#endregion
}
