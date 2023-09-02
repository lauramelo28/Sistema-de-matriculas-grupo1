import java.util.List;

public class Secretaria extends Usuario {

    public Secretaria (String nome, String cpf, String dataNascimento, String login, String senha, boolean estaLogado) {
        super(nome, cpf, dataNascimento, login, senha, estaLogado);
    }



    //#region MÉTODOS
    public List<String> gerarCurriculo(Curso curso){
        //Implementação do método
        return null;
    }

    public void cadastrarDisciplina(Disciplina disciplina){
        //Implementação do método
    }

    public void cadastrarCurso(Curso curso){
        //Implementação do método
    }

    public void cadastrarProfessor(Professor professor){
        //Implementação do método
    }

    public void cadastrarAluno(Aluno aluno){
        //Implementação do método
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

    public void liberarPeriodoMatricula(String nomeDisciplina){
        //Implementação do método
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
