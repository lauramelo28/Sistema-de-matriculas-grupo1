import java.util.List;

public class Secretaria extends Usuario {

    private List<Curso> cursos;
    private List<Aluno> alunos;
    private List<Professor> professores;

    public Secretaria (String nome, String cpf, String dataNascimento, String login, String senha) {
        super(nome, cpf, dataNascimento, login, senha);
    }
    
    //#region MÉTODOS
    /**
     * Recebe um curso e um semestre e retorna o currículo do curso no semestre informado
     * @param curso1
     * @param semestre
     * @return String com o currículo
     */
    public String gerarCurriculo(Curso curso1, int semestre){
        for(Curso curso : cursos){
            if(curso.getNome().equals(curso1.getNome())){
                return curso.gerarCurriculoSemestre(semestre);
            }
        }
        return null;
    }

    public void cadastrarDisciplina(Disciplina disciplina){
        Disciplina discplinaNova = new Disciplina(disciplina.getNome(), disciplina.getNumeroDeCreditos(), disciplina.getCurso(), disciplina.getSemestre(), disciplina.getTipoDisciplina());
        for(Curso curso : cursos){
            if(curso.getNome().equals(disciplina.getCurso().getNome())){
                curso.adicionarDisciplinas(discplinaNova);
            }
        }
    }

    public void cadastrarCurso(Curso curso){
        cursos.add(curso);        
    }

    public Professor cadastrarProfessor(String nome, String cpf, String dataNascimento, String nomeUsuario, String senha, String matricula, String nomeCurso){
        Professor professor = new Professor(nome, cpf, dataNascimento, login, senha, nomeCurso);
        return professor;
    }

    public Aluno cadastrarAluno(String nome, String cpf, String dataNascimento, String nomeUsuario, String senha, String matricula, String nomeCurso){
        Aluno aluno = new Aluno(nome, cpf, dataNascimento, nomeUsuario, senha, matricula, nomeCurso);
        return aluno;
    }

    /**
     * 
     * @param nomeAluno String
     * @return valor double
     */
    public double gerarCobrancaFinanceira(String nomeAluno){
        List<Disciplina> disciplinasAluno = null;
        double valor = 0.0;

       for(Aluno aluno : alunos){
           if(aluno.getNome().equals(nomeAluno)){
                disciplinasAluno = aluno.listarDisciplinas();
           }
        }
        for(int i = 0; i <= disciplinasAluno.size(); i++){
            valor = disciplinasAluno.get(i).getNumeroDeCreditos() * 100;
        }

        return valor;
    }

    /**
     * Recebe um professor e a discplina a ser atribuida a ele
     * @return void
     */
    public void atribuirDisciplinaProfessor(Professor professor, Disciplina disciplina){
        for(Professor prof : professores){
            if(prof.getNome().equals(professor.getNome())){
                disciplina.adicionarProfessor(professor);
                professor.novaDisciplina(disciplina);
            }
        }

    }

    /**
     * Recebe o nome de uma Disciplina (String) e um Curso (String) e libera a inscrição para a disciplina (boolean
     * @return void
     */

    public void liberarPeriodoMatricula(String nomeDisciplina, String nomeCurso){
        for(Curso curso : cursos){
            if(curso.getNome().equals(nomeCurso)){
                for(Disciplina disciplina : curso.getDisciplinas()){
                    if(disciplina.getNome().equals(nomeDisciplina)){
                        disciplina.inscricaoLiberada(true);
                    }
                }
            }
        }
    }

    @Override
    public String toString(){
        return "Secretaria;" + this.nome + ";" + this.cpf + ";" + this.dataNascimento + ";" + this.login + ";" + this.senha;
    }
    
    //#endregion
}
