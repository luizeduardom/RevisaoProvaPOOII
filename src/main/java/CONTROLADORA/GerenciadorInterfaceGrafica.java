package CONTROLADORA;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GerenciadorInterfaceGrafica {

    GerenciadorDominio gerDom;

    public GerenciadorInterfaceGrafica() {
        try {
            gerDom = new GerenciadorDominio();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(principal, "Classe não encontrada" + ex);
        }
    }

}
