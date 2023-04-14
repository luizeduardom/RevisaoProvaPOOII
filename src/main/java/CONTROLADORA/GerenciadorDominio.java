/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADORA;

import DAO.ConexaoBanco;
import DAO.LancheDAO;
import DOMINIO.Lanche;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 2021122760224
 */
public class GerenciadorDominio {

    LancheDAO lancheDAO;

    public GerenciadorDominio() throws ClassNotFoundException, SQLException {
        ConexaoBanco.obterConexao();
        lancheDAO = new LancheDAO();
    }

    public List<Lanche> listarLanches() throws ClassNotFoundException, SQLException {
        return lancheDAO.listar();
    }

    public int inserirLanche(String nome, float valor, String ingredientes) throws ClassNotFoundException, SQLException {
        Lanche lanche = new Lanche(nome, valor, ingredientes);
        lancheDAO.inserirLanche(lanche);
        return lanche.getIdLanche();
    }
}
