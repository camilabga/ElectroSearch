package business;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class AdaptadorBDElectroSearch {
    private static String serverName = ipBD();    //caminho do servidor do BD
    private static String mydatabase = "ElectroSearch";        //nome do banco de dados
    // endereço onde está o banco de dados. 
    private static String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
    // usuário do banco de dados
    private static String username = "root";
    // senha para acesso ao banco de dados
    private static String password = "abcd1234";
    // Driver para conexão ao banco de dados
    private static String driverName = "com.mysql.jdbc.Driver";

    public static Connection abrirConexao() {
        Connection cnn = null;
        try {
    // Conexão ao banco de dados
            if (cnn == null) {
                // Este é um dos meios para registrar um driver
                Class.forName(driverName);
                // Configurando a nossa conexão com um banco de dados//
                cnn = DriverManager.getConnection(url, username, password);
                // Se a conexão foi executada com sucesso, a mensagem abaixo é exibida na Saída Padrão Java
                System.out.println("Você se conectou ao banco de dados!! :D :D");
                System.out.println("#####################################");
                return cnn;
            }

        } catch (SQLException e) {
            // se houve algum erro, uma exceção é gerada para informar o erro
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
        }

        return cnn;
    }
    
    private static String ipBD() {
        String ip = null;
        try {
            ip = (String) InetAddress.getLocalHost().getHostAddress();
            System.out.println(ip);
        } catch (UnknownHostException ex) {
            Logger.getLogger(AdaptadorBDElectroSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
       // File file = new File("config.txt");     
        
        
        
        //FileReader fr = null;
        //try {
          //  fr = new FileReader(file);
        //} catch (FileNotFoundException ex) {
          //  Logger.getLogger(AdaptadorBDElectroSearch.class.getName()).log(Level.SEVERE, null, ex);
        //}
        //BufferedReader br = new BufferedReader(fr);
        
        String linha_de_ip="";
      /*  try {
            while (br.ready()) {
                linha_de_ip = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(AdaptadorBDElectroSearch.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        return linha_de_ip;
    }
    
}