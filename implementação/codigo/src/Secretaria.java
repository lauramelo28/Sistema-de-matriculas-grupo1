import java.util.List;

public class Secretaria extends Usuario {

    private List<Curso> cursos;
    private List<Aluno> alunos;
    private List<Professor> professores;


    public Secretaria (String nome, String cpf, String dataNascimento, String login, String senha, boolean estaLogado) {
        super(nome, cpf, dataNascimento, login, senha, estaLogado);
    }



    //#region MÉTODOS
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

    public void cadastrarProfessor(Professor professor){
        professores.add(professor);
    }

    public void cadastrarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public double gerarCobrancaFinanceira(String nomeAluno){
        //Implementação do método
        return 0.0;
    }

    public void atualizarInformacoesDisciplina(Disciplina disciplina){
        //Implementação do método
    }

    public void atualizarInformacoesProfessor(Professor professor){
        //Implementação do método
    }

    public void atualizarInformacoesAluno(Aluno aluno){
        //Implementação do método
    }

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
