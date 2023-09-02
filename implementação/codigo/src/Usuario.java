public abstract class Usuario {
    //#region ATRIBUTOS
    protected String nome;
    protected String cpf;
    protected String dataNascimento;
    protected String login;
    protected String senha;
    private boolean logado;
    //#endregion

    //#region MÉTODOS
    public Usuario(String nome, String cpf, String dataNascimento, String login, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.login = login; 
        this.senha = senha;
        this.logado = false;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public String getDataNascimento(){
        return this.dataNascimento;
    }

    public String getLogin() {
        return this.login;
    }

    public String getSenha() {
        return this.senha;
    }
    
    public boolean realizarLogin(String loginDigitado, String senhaDigitada) {
        if (this.login.equals(loginDigitado) && this.senha.equals(senhaDigitada)) {
            this.logado = true;
            return true;
        } else {
            return false;
        }
    }

    public void realizarLogoff() {
        if (logado) {
            this.logado = false;
        } 
    }

    public boolean EstaLogado() {
        return logado;
    }
}
