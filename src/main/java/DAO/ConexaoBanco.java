
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
    static Connection conexao;

    public static Connection obterConexao() throws ClassNotFoundException, SQLException{
        String servidor = "127.0.0.1:3306";
        String login = "root";
        String senha = "";
        String nomeBanco = "jeanxfome";
        String url = "jdbc:mysql://" + servidor + "/" + nomeBanco;
        Class.forName("com.mysql.jdbc.Driver");
        conexao = DriverManager.getConnection(url, login, senha);
        return conexao;
    }

}
