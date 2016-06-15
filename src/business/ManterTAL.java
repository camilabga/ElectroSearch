package business;

import beans.TAL;
import static business.AdaptadorBDElectroSearch.abrirConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ManterTAL {

    public ManterTAL() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean adicionarTal(String nome, String cpf, String matricula, String disciplina, String login, String senha) {
        int regInseridos = 0;
        
        String matricula_log = SaberLogin.getInstance().getMatricula();

        String insertSQL = "insert into tal (nome, cpf, matricula, disciplina, login, senha, professor_matricula) VALUES ( ?, ?, ?, ?, ?, ?, ?);";

        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(insertSQL);
            ps.setString(1, nome);
            ps.setString(2, cpf);
            ps.setString(3, matricula);
            ps.setString(4, disciplina);
            ps.setString(5, login);
            ps.setString(6, senha);
            ps.setString(7, matricula_log);


            regInseridos = ps.executeUpdate();

            cnn.close();

        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }

        if (regInseridos == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean excluirTAL(String matricula) {
        System.out.println(matricula);
        String sql = "delete from tal where matricula like ?;";

        int regAlterados = 0;

        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, matricula);

            regAlterados = ps.executeUpdate();

            cnn.close();

        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }

        if (regAlterados == 1) {
            return true;
        }
        return false;
    }

    public static TAL procurarUsuario(String login, String senha) throws SQLException {
        String querySQL = "select * from tal where login like ? and senha like ?;";

//        rs = AdaptadorBDElectroSearch.consultarBanco(querySQL); 
        login = "%" + login + "%";
        senha = "%" + senha + "%";

        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(querySQL);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            rs.first();
            TAL tal = new TAL();
            tal.setNome(rs.getString("nome"));
            tal.setMatricula(rs.getString("matricula"));
            tal.setCpf(rs.getString("cpf"));
            tal.setLogin(rs.getString("login"));
            tal.setSenha(rs.getString("senha"));
            tal.setDisciplina(rs.getString("disciplina"));
            tal.setMatricula_ad("professor_matricula");
            cnn.close();

            return tal;

        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }

        return null;
    }

    public static boolean atualizarTAL(boolean passwd, String nome, String disci, String senha, String cpf, String login, String mat, String novSenha) {
        int regAlterados = 0;

        String insertSQL3 = "update tal SET nome = ? WHERE matricula = ?;";
        String insertSQL2 = "update tal SET disciplina = ? WHERE matricula = ?;";
        String insertSQL4 = "update tal SET cpf = ? WHERE matricula = ?;";
        String insertSQL1 = "update tal SET login = ? WHERE matricula = ?;";
        String insertSQL = "";
        if (passwd) {
            insertSQL = "update tal SET senha = ? WHERE matricula = ?;";

            try {
                Connection cnn = abrirConexao();
                PreparedStatement ps = cnn.prepareStatement(insertSQL);
                ps.setString(1, novSenha);
                ps.setString(2, mat);

                regAlterados = ps.executeUpdate();

                if (regAlterados != 1) {
                    return false;
                }

                cnn.close();

            } catch (SQLException e) {
                // se houve algum erro, uma exceção é gerada para informar o erro
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
            }
        }

        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(insertSQL1);
            ps.setString(1, login);
            ps.setString(2, mat);

            regAlterados = ps.executeUpdate();

            if (regAlterados != 1) {
                return false;
            }

            cnn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(insertSQL2);
            ps.setString(1, disci);
            ps.setString(2, mat);

            regAlterados = ps.executeUpdate();

            if (regAlterados != 1) {
                return false;
            }

            cnn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(insertSQL3);
            ps.setString(1, nome);
            ps.setString(2, mat);

            regAlterados = ps.executeUpdate();

            if (regAlterados != 1) {
                return false;
            }
            cnn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(insertSQL4);
            ps.setString(1, cpf);
            ps.setString(2, mat);

            regAlterados = ps.executeUpdate();

            if (regAlterados != 1) {
                return false;
            }
            cnn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    public static List<TAL> pesquisarTAL(String search, int esc) throws SQLException {
        List result = new LinkedList();

        String querySQL = "";

        search = "%" + search + "%";

        switch (esc) {
            case 1:
                querySQL = "select * from tal where matricula like ?;";
                break;
            case 2:
                querySQL = "select * from tal where nome like ?;";
                break;
            case 3:
                querySQL = "select * from tal where cpf like ?;";
                break;
        }

        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(querySQL);
            ps.setString(1, search);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    TAL tal = new TAL();
                    tal.setNome(rs.getString("nome"));
                    tal.setMatricula(rs.getString("matricula"));
                    tal.setCpf(rs.getString("cpf"));
                    tal.setLogin(rs.getString("login"));
                    tal.setSenha(rs.getString("senha"));
                    tal.setDisciplina(rs.getString("disciplina"));
                    tal.setMatricula_ad("professor_matricula");

                    result.add(tal);
                }
            } else {
                return null;
            }
            
            if (!result.isEmpty()) {
                return result;
            }
            
            cnn.close();
            
        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }
        return null;
    }

    public static List<TAL> selecionarTudo() {
        List result = new LinkedList();
        String querySQL = "select * from tal";

        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(querySQL);
            ResultSet rs = ps.executeQuery();
            if (rs == null) {
                return null;
            }
            while (rs.next()) {
                TAL tal = new TAL();
                tal.setNome(rs.getString("nome"));
                tal.setMatricula(rs.getString("matricula"));
                tal.setCpf(rs.getString("cpf"));
                tal.setLogin(rs.getString("login"));
                tal.setSenha(rs.getString("senha"));
                tal.setDisciplina(rs.getString("disciplina"));
                tal.setMatricula_ad("professor_matricula");

                result.add(tal);
            }

//            cnn.close();
            if (!result.isEmpty()) {
                return result;
            }
        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }
        return null;
    }

    public static TAL searchTAL(String matricula) {
        String querySQL = "select * from tal where matricula like ?;";

//        rs = AdaptadorBDElectroSearch.consultarBanco(querySQL); 
        matricula = "%" + matricula + "%";

        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(querySQL);
            ps.setString(1, matricula);
            ResultSet rs = ps.executeQuery();

            rs.first();
            TAL tal = new TAL();
            tal.setNome(rs.getString("nome"));
            tal.setMatricula(rs.getString("matricula"));
            tal.setCpf(rs.getString("cpf"));
            tal.setLogin(rs.getString("login"));
            tal.setSenha(rs.getString("senha"));
            tal.setDisciplina(rs.getString("disciplina"));
            tal.setMatricula_ad("professor_matricula");


            cnn.close();

            return tal;

        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }

        return null;
    }
}
