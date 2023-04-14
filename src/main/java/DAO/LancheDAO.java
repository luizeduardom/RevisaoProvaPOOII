package DAO;

import DOMINIO.Lanche;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LancheDAO {

    public List<Lanche> listar() throws ClassNotFoundException, SQLException {
        List<Lanche> lista = new ArrayList();
        Statement stmt;
        stmt = ConexaoBanco.obterConexao().createStatement();
        String sql = "SELECT * FROM Lanche";
        ResultSet set = stmt.executeQuery(sql);
        Lanche lanche;

        while (set.next()) {
            lanche = new Lanche(set.getInt(1), set.getString(2));
            lista.add(lanche);
        }
        return lista;
    }

}
