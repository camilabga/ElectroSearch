package beans;

import java.util.Date;

public class Itens {
    private int id;
    private String nome;
    private String tipo;
    private String datasheet;
    private String descricao;
    private boolean disponivel;
    private Date data;
    private String matricula_usuario;
    private int tipoDeUsuario;
    // 1- TAL
    // 2 - Professor

    
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public String getMatricula_usuario() {
        return matricula_usuario;
    }
    public void setMatricula_usuario(String matricula_usuario) {
        this.matricula_usuario = matricula_usuario;
    }

    public int getTipoDeUsuario() {
        return tipoDeUsuario;
    }
    public void setTipoDeUsuario(int tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDatasheet() {
        return datasheet;
    }
    public void setDatasheet(String datasheet) {
        this.datasheet = datasheet;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
}
