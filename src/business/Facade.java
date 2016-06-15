package business;

import beans.Itens;
import beans.Professor;
import beans.TAL;
import java.sql.SQLException;
import java.util.List;

public final class Facade {
    private static final Facade facade = new Facade();
    
    private Facade(){
    }    
    public static Facade getInstance(){
        return facade;
    }
    
        // Chamadas das funções referentes à classe Itens
    
    public boolean adicionarItem(String nome, String tipo, boolean disponivel, String datasheet, String descricao){
        return ManterItem.adicionarItem(nome, tipo, disponivel, datasheet, descricao);
    }
    public boolean alterarItem(int id, String nome, String tipo, boolean disponivel, String datasheet, String descricao){
        return ManterItem.atualizarItem(id, nome, tipo, disponivel, datasheet, descricao);
    }
    public boolean apagarItem(String nome){
        return ManterItem.excluirItem(nome);
    }
    public List<Itens> procurarItem(String search, int esc) throws SQLException{
        return ManterItem.procurarItem(search, esc);
    }
    public Itens acharItem(String nome){
        return ManterItem.acharItem(nome);
    }
    
    // Chamadas das funções referentes à classe TAL

    public List<TAL> pesquisarTAL(String nome, int esc) throws SQLException {
        return ManterTAL.pesquisarTAL(nome, esc);
    }
    public TAL procurarUsuario(String nome, String senha) throws SQLException{
        return ManterTAL.procurarUsuario(nome, senha);
    }
    public boolean AdicionarTal (String nome, String cpf, String matricula, String disciplina, String login, String senha) throws SQLException {
        return ManterTAL.adicionarTal(nome, cpf, matricula, disciplina, login, senha);
    }
    public boolean excluirTAL(String matricula) throws SQLException{
        return ManterTAL.excluirTAL(matricula);
    }
    public boolean atualizarTAL(boolean passwd, String nome, String disci, String senha, String cpf, String login, String mat, String novSenha) throws SQLException{
        return ManterTAL.atualizarTAL(passwd, nome, disci, senha, cpf, login, mat, novSenha);
    }
    public static List<TAL> selecionarTudoTAL (){
        return ManterTAL.selecionarTudo();
    }
    public TAL searchTAL (String matricula) {
        return ManterTAL.searchTAL(matricula);
    }
    
    // Chamadas das funções referentes à classe Professor
    
    public List<Professor> pesquisarProfessor(String nome, int esc) throws SQLException {
        return ManterProfessor.pesquisarProfessor(nome, esc);
    }
    public boolean AdicionarProfessor (String nome, String cpf, String matricula, String disciplina, String login, String senha) throws SQLException {
        return ManterProfessor.adicionarProfessor(nome, cpf, matricula, disciplina, login, senha);
    }
    public boolean excluirProfessor(String matricula) throws SQLException{
        return ManterProfessor.excluirProfessor(matricula);
    }
    public boolean atualizarProfessor(boolean passwd, String nome, String disci, String senha, String cpf, String login, String mat, String novSenha) throws SQLException{
        return ManterProfessor.atualizarProfessor(passwd, nome, disci, senha, cpf, login, mat, novSenha);
    }
    public Professor procurarProfessor(String nome, String senha) throws SQLException{
        return ManterProfessor.procurarUsuario(nome, senha);
    }
    public static List<Professor> selecionarTudoProfessor (){
        return ManterProfessor.selecionarTudo();
    }
    public Professor searchProfessor (String matricula) {
        return ManterProfessor.searchProfessor(matricula);
    }
    
}