import java.util.LinkedList;
import java.util.List;

public class Aluno extends Usuario {

    //#region ATRIBUTOS
    private String matricula;
    private String nomeCurso;
    private List<Disciplina> disciplinasMatriculadas;

    private static final int MAX_DE_DISCIPLINAS_OBRIGATORIAS = 4;
    private static final int MAX_DE_DISCIPLINAS_OPTATIVAS = 2;

    public Aluno(String nome, String cpf, String dataNascimento, String login, String senha, String matricula, String nomeCurso) {
        super(nome, cpf, dataNascimento, login, senha);
        this.matricula = matricula;
        this.disciplinasMatriculadas = new LinkedList<Disciplina>();
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

    public String getNomeCurso(){
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

    public String toStringDisciplinasMatriculadas(){
        String disciplinasToString = "";
        for(Disciplina disciplina : disciplinasMatriculadas){
            disciplinasToString += disciplina.toString() + "\n";
        }

        return disciplinasToString;
    }

    public List<Disciplina> listarDisciplinas(){
        return this.disciplinasMatriculadas;
    }

    private void verificarQtdDisciplinas() throws IllegalArgumentException{
        int qtdDisciplinasObrigatorias = 0;
        int qtdDisciplinasOptativas = 0;

        for(Disciplina disciplina : disciplinasMatriculadas){
            if(disciplina.getTipoDisciplina().equals("Obrigatoria"))
                qtdDisciplinasObrigatorias++;
            else if(disciplina.getTipoDisciplina().equals("Optativa"))
                qtdDisciplinasOptativas++;
        }

        if (qtdDisciplinasObrigatorias == MAX_DE_DISCIPLINAS_OBRIGATORIAS) {
            throw new IllegalArgumentException("Voce nao pode ser matricular em mais de 4 disciplinas obrigatorias");
        } else if (qtdDisciplinasOptativas == MAX_DE_DISCIPLINAS_OPTATIVAS) {
            throw new IllegalArgumentException("Voce nao pode ser matricular em mais de 2 disciplinas optativas");
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

    public String toString(){
        return "Aluno;" + this.nome + ";" + this.cpf + ";" + this.dataNascimento + ";" + this.login + ";" + this.senha + ";" + this.matricula + ";" + this.nomeCurso;
    }

    //#endregion
}


