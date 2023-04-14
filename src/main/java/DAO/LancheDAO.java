package DAO;

import DOMINIO.Lanche;
import java.sql.PreparedStatement;
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

    public void inserirLanche(Lanche lanche) throws ClassNotFoundException, SQLException {
        Statement stmt;
        stmt = ConexaoBanco.obterConexao().createStatement();
        String sql = "insert into Lanche (nome, valor, ingredientes)" + "values (?, ?, ?)";
        int cont = 1;
        PreparedStatement pstmt = ConexaoBanco.obterConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pstmt.setString(cont++, lanche.getNome());
        pstmt.setFloat(cont++, lanche.getValor());
        pstmt.setString(cont++, lanche.getIngredientes());
      //CONVERSAO DE DATA
      //pstmt.setDate(cont++, new java.sql.Date(xx.getData..().getTime()));
      //CONVERSAO DE CHAR PARA STRING
      //pstmt.setString(cont++, String.valueOf(xx.get..()));
        pstmt.execute();
        ResultSet res = pstmt.getGeneratedKeys();
        if (res.next()){
            int id = res.getInt(1);
            lanche.setIdLanche(id);
        }
        
    }

}
