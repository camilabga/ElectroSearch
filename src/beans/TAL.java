package beans;
public class TAL {
    private String nome;
    private String matricula;
    private String cpf;
    private String login;
    private String senha;
    private String disciplina;
    private String matricula_ad;


    public String getCpf() {
        return cpf;
    }

    public String getMatricula_ad() {
        return matricula_ad;
    }

    public void setMatricula_ad(String matricula_ad) {
        this.matricula_ad = matricula_ad;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
}
