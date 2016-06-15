package business;

import beans.Itens;
import static business.AdaptadorBDElectroSearch.abrirConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ManterItem {

    public static boolean adicionarItem(String nome, String tipo, boolean disponivel, String datasheet, String descricao) {
        int regInseridos = 0;
        String matricula = SaberLogin.getInstance().getMatricula();
        int tipoDeUsuario = SaberLogin.getInstance().getTipodeusuario();

        java.sql.Date data = ManterData.getInstance().getData();

        String insertSQL = "";
        if (tipoDeUsuario == 1) {
            insertSQL = "insert into itens (nome, tipo, disponivel, datasheet, descricao, tal_matricula, data) VALUES (?, ?, ?, ?, ?, ?, ?);";
        } else if (tipoDeUsuario == 2) {
            insertSQL = "insert into itens (nome, tipo, disponivel, datasheet, descricao, professor_matricula, data) VALUES (?, ?, ?, ?, ?, ?, ?);";
        }
        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(insertSQL);
            ps.setString(1, nome);
            ps.setString(2, tipo);
            ps.setBoolean(3, disponivel);
            ps.setString(4, datasheet);
            ps.setString(5, descricao);
            ps.setString(6, matricula);
            ps.setDate(7, data);

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
    public static boolean atualizarItem(int id, String nome, String tipo, boolean disponivel, String datasheet, String descricao) {
        int regAlterados = 0;

        String insertSQL1 = "update itens SET nome = ? WHERE id = ?;";
        String insertSQL2 = "update itens SET tipo = ? WHERE id = ?;";
        String insertSQL3 = "update itens SET disponivel = ? WHERE id = ?;";
        String insertSQL4 = "update itens SET datasheet = ? WHERE id = ?;";
        String insertSQL5 = "update itens SET descricao = ? WHERE id = ?;";

        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(insertSQL1);
            ps.setString(1, nome);
            ps.setInt(2, id);

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
            ps.setString(1, tipo);
            ps.setInt(2, id);

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
            ps.setBoolean(1, disponivel);
            ps.setInt(2, id);

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
            ps.setString(1, datasheet);
            ps.setInt(2, id);

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
            PreparedStatement ps = cnn.prepareStatement(insertSQL5);
            ps.setString(1, descricao);
            ps.setInt(2, id);

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
    public static boolean excluirItem(String nome) {
        String sql = "delete from itens where nome like ?;";

        int regAlterados = 0;

        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, nome);

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
    public static List<Itens> procurarItem(String search, int esc) throws SQLException {
        String querySQL = "";
        List result = new LinkedList();

        switch (esc) {
            case 1:
                int id = Integer.parseInt(search);
                querySQL = "select * from itens where id = ?;";
                result = new LinkedList();

                try {
                    Connection cnn = abrirConexao();
                    PreparedStatement ps = cnn.prepareStatement(querySQL);
                    ps.setString(1, search);
                    ResultSet rs = ps.executeQuery();

                    if (rs == null) {
                        return null;
                    }
                    while (rs.next()) {
                        Itens item = new Itens();
                        item.setId(rs.getInt("id"));
                        item.setNome(rs.getString("nome"));
                        item.setTipo(rs.getString("tipo"));
                        item.setDisponivel(rs.getBoolean("disponivel"));
                        item.setDescricao(rs.getString("descricao"));
                        item.setDatasheet(rs.getString("datasheet"));
                        item.setData(rs.getDate("data"));
                        String tal = rs.getString("tal_matricula");
                        String professor = rs.getString("professor_matricula");

                        System.out.println(tal);
                        System.out.println(professor);
                        
                        if (tal != null) {
                            item.setTipoDeUsuario(1);
                            item.setMatricula_usuario(tal);
                        } else if (professor != null) {
                            item.setTipoDeUsuario(2);
                            item.setMatricula_usuario(professor);
                        }

                        result.add(item);
                    }

                    cnn.close();
                    if (!result.isEmpty()) {
                        return result;
                    }
                } catch (SQLException e) {
                    // se houve algum erro, uma exceção é gerada para informar o erro
                    e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                }
                return null;

            case 2:
                querySQL = "select * from itens where nome like ?;";
                search = "%" + search + "%";
                result = new LinkedList();

                try {
                    Connection cnn = abrirConexao();
                    PreparedStatement ps = cnn.prepareStatement(querySQL);
                    ps.setString(1, search);
                    ResultSet rs = ps.executeQuery();

                    if (rs == null) {
                        return null;
                    }
                    while (rs.next()) {
                        Itens item = new Itens();
                        item.setId(rs.getInt("id"));
                        item.setNome(rs.getString("nome"));
                        item.setTipo(rs.getString("tipo"));
                        item.setDisponivel(rs.getBoolean("disponivel"));
                        item.setDescricao(rs.getString("descricao"));
                        item.setDatasheet(rs.getString("datasheet"));
                        result.add(item);
                    }

                    cnn.close();
                    if (!result.isEmpty()) {
                        return result;
                    }
                } catch (SQLException e) {
                    // se houve algum erro, uma exceção é gerada para informar o erro
                    e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                }
                return null;
            case 3:
                querySQL = "select * from itens where tipo like ?;";
                search = "%" + search + "%";
                result = new LinkedList();

                try {
                    Connection cnn = abrirConexao();
                    PreparedStatement ps = cnn.prepareStatement(querySQL);
                    ps.setString(1, search);
                    ResultSet rs = ps.executeQuery();

                    if (rs == null) {
                        return null;
                    }
                    while (rs.next()) {
                        Itens item = new Itens();
                        item.setId(rs.getInt("id"));
                        item.setNome(rs.getString("nome"));
                        item.setTipo(rs.getString("tipo"));
                        item.setDisponivel(rs.getBoolean("disponivel"));
                        item.setDescricao(rs.getString("descricao"));
                        item.setDatasheet(rs.getString("datasheet"));
                        result.add(item);
                    }

                    cnn.close();
                    if (!result.isEmpty()) {
                        return result;
                    }
                } catch (SQLException e) {
                    // se houve algum erro, uma exceção é gerada para informar o erro
                    e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                }
                return null;
            case 4:
                querySQL = "select * from itens where tipo like ? or "
                        + "nome like ? or descricao like ?;";
                search = "%" + search + "%";
                result = new LinkedList();

                try {
                    Connection cnn = abrirConexao();
                    PreparedStatement ps = cnn.prepareStatement(querySQL);
                    ps.setString(1, search);
                    ps.setString(2, search);
                    ps.setString(3, search);
                    ResultSet rs = ps.executeQuery();

                    if (rs == null) {
                        return null;
                    }
                    while (rs.next()) {
                        Itens item = new Itens();
                        item.setId(rs.getInt("id"));
                        item.setNome(rs.getString("nome"));
                        item.setTipo(rs.getString("tipo"));
                        item.setDisponivel(rs.getBoolean("disponivel"));
                        item.setDescricao(rs.getString("descricao"));
                        item.setDatasheet(rs.getString("datasheet"));
                        result.add(item);
                    }

                    cnn.close();
                    if (!result.isEmpty()) {
                        return result;
                    }
                } catch (SQLException e) {
                    // se houve algum erro, uma exceção é gerada para informar o erro
                    e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                }
                return null;
            case 5:
                querySQL = "select * from itens;";
                result = new LinkedList();

                try {
                    Connection cnn = abrirConexao();
                    PreparedStatement ps = cnn.prepareStatement(querySQL);
                    ResultSet rs = ps.executeQuery();

                    if (rs == null) {
                        return null;
                    }
                    while (rs.next()) {
                        Itens item = new Itens();
                        item.setId(rs.getInt("id"));
                        item.setNome(rs.getString("nome"));
                        item.setTipo(rs.getString("tipo"));
                        item.setDisponivel(rs.getBoolean("disponivel"));
                        item.setDescricao(rs.getString("descricao"));
                        item.setDatasheet(rs.getString("datasheet"));
                        result.add(item);
                    }

                    cnn.close();
                    if (!result.isEmpty()) {
                        return result;
                    }
                } catch (SQLException e) {
                    // se houve algum erro, uma exceção é gerada para informar o erro
                    e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                }
                return null;
            default:
                return null;
        }
    }
    public static Itens acharItem(String nome) {
        String querySQL = "";
        List result = new LinkedList();
        querySQL = "select * from itens where nome like ?;";
        nome = "%" + nome + "%";

        try {
            Connection cnn = abrirConexao();
            PreparedStatement ps = cnn.prepareStatement(querySQL);
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs == null) {
                return null;
            }

            rs.first();
            Itens item = new Itens();
            item.setId(rs.getInt("id"));
            item.setNome(rs.getString("nome"));
            item.setTipo(rs.getString("tipo"));
            item.setDisponivel(rs.getBoolean("disponivel"));
            item.setDescricao(rs.getString("descricao"));
            item.setDatasheet(rs.getString("datasheet"));
            item.setData(rs.getDate("data"));
            String tal = rs.getString("tal_matricula");
            String professor = rs.getString("professor_matricula");

            if (tal != null) {
                item.setTipoDeUsuario(1);
                item.setMatricula_usuario(tal);
            } else if (professor != null) {
                item.setTipoDeUsuario(2);
                item.setMatricula_usuario(professor);
            }
            
            System.out.println(item.getTipoDeUsuario());
            
            cnn.close();

            if (!"".equals(item.getNome())) {
                return item;
            }
        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }
        return null;
    }
}
