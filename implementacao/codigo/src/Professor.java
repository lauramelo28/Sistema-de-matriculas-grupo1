import java.util.List;

public class Professor extends Usuario {
   
    //#region ATRIBUTOS
    private List<Disciplina> disciplinas;
    private double horarioDaAula;
    private String curso;

    public Professor(String nome, String cpf, String dataNascimento, String login, String senha, String curso) {
        super(nome, cpf, dataNascimento, login, senha);
        this.curso = curso;
    }
    //#endregion

    //#region MÉTODOS
    /**
     * Método para listar os alunos em determinada disciplina do professor
     * @param Disciplina disciplina
     */
    public void verificarAlunosEmDisciplina(Disciplina disciplina){
        disciplina.listarAlunosMatriculados();
    }

    public void novaDisciplina(Disciplina disciplina){
        disciplinas.add(disciplina);
    }

    public String toString(){
        return "Professor;" + this.nome + ";" + this.cpf + ";" + this.dataNascimento + ";" + this.login + ";" + this.senha + ";" + this.curso;
    }
    //#endregion

    public void listarDisciplinas() {
        for(Disciplina disciplina : disciplinas){
            System.out.println(disciplina.getNome());
        }
    }

    public Disciplina getDisciplina(String nomeDisciplina) {
        for(Disciplina disciplina : disciplinas){
            if(disciplina.getNome() == nomeDisciplina){
                return disciplina;
            }
        }
        return null;
    }
}
