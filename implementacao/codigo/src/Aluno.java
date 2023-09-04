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
    public String getCurso(){
        return this.nomeCurso;
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
        
        if (verificarQtdDisciplinas() && verificarDisciplinasOptativas() && verificarDisciplinasObrigatorias()){
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

    public boolean verificarDisciplinasOptativas(){
        int optativas = 0;
        for(Disciplina disciplina : disciplinasMatriculadas){
            if(disciplina.getTipoDisciplina() == TipoDisciplina.Optativa){
                optativas++;
            }
        }
        if(optativas == 2){
            return false;
        }
        return true;
    }

    public boolean verificarDisciplinasObrigatorias(){
        int obrigatorias = 0;
        for(Disciplina disciplina : disciplinasMatriculadas){
            if(disciplina.getTipoDisciplina() == TipoDisciplina.Obrigatoria){
                obrigatorias++;
            }
        }
        if(obrigatorias == 2){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return "Aluno;" + this.nome + ";" + this.cpf + ";" + this.dataNascimento + ";" + this.login + ";" + this.senha + ";" + this.matricula + ";" + this.nomeCurso;
    }

    //#endregion
}


