public abstract class Usuario {
    //#region ATRIBUTOS
    protected String nome;
    protected String cpf;
    protected String dataNascimento;
    protected String login;
    protected String senha;
    //#endregion

    //#region MÉTODOS
    public Usuario(String nome, String cpf, String dataNascimento, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.login = login; 
        this.senha = senha;
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
}
