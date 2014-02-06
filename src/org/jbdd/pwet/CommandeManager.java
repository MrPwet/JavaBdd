package org.jbdd.pwet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mrpwet on 06/02/14.
 */
public class CommandeManager {
    private Connection conn;

    public CommandeManager(Connection conn) {
        this.conn = conn;
    }

    public int create(Commande commande, List<Article> lstArticle, int idPanier) {
            int n = -1;
            PreparedStatement pstm = null;
            PreparedStatement pstm2 = null;
            ResultSet rset = null;
            int idVente = 0;
            Iterator<Article> it = null;

            try {
                String sql = "insert into Commande values(null,?,?,?);";
                pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                int i = 1;
                pstm.setString(i++, commande.getUsername());
                pstm.setDate(i++, commande.getDatecommande());
                pstm.setFloat(i++, commande.getPrixCommande());
                n = pstm.executeUpdate();
                rset = pstm.getGeneratedKeys();
                while(rset.next()) {
                    idVente = rset.getInt(1);
                }

                it = lstArticle.iterator();
                    while(it.hasNext()) {
                        i = 1;
                        String sql2 = "insert into Concerne values(?,?);";
                        pstm2 = conn.prepareStatement(sql2);
                        pstm2.setInt(i++, idVente);
                        pstm2.setInt(i++, it.next().getIdArticle());
                        n += pstm2.executeUpdate();
                        try {pstm2.close();} catch (Exception ignore) {}
                        pstm2 = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {pstm.close();} catch (Exception ignore) {}
            }
            PanierManager pm = new PanierManager(conn);
            pm.cleanPanier(idPanier);
            return n;

    }
}
