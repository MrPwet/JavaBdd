package org.jbdd.pwet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by mrpwet on 06/02/14.
 */
public class PanierManager {
    private Connection conn;

    public PanierManager(Connection conn) {
        this.conn = conn;
    }

    public int create() {
        int n = -1;
        int idPanier = 0;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            String sql = "insert into Panier values(null);";
            pstm = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            n = pstm.executeUpdate();
            rset = pstm.getGeneratedKeys();
            if(rset.next()) {
                idPanier = rset.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch (Exception ignore) {}
        }
        return idPanier;
    }

    public int addArticle(int idPanier, int idArticle, int quantite) {
        int n = -1;
        PreparedStatement pstm = null;

        try {
            String sql = "insert into Comporte values(?,?,?);";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setInt(i++, idPanier);
            pstm.setInt(i++, idArticle);
            pstm.setInt(i++, quantite);
            n = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch (Exception ignore) {}
        }
        return n;
    }

    public int update(int idPanier, int idArticle, int quantite) {
        int n = -1;
        PreparedStatement pstm = null;

        try {
            String sql = "update Comporte set quantite=? where idPanier=? and idArticle=?;";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setInt(i++, quantite);
            pstm.setInt(i++, idPanier);
            pstm.setInt(i++, idArticle);
            n = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch (Exception ignore) {}
        }
        return n;
    }

    public int delete(int idPanier, int idArticle) {
        int n = -1;
        PreparedStatement pstm = null;

        try {
            String sql = "delete from Comporte where idPanier=? and idArticle=?;";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setInt(i++, idPanier);
            pstm.setInt(i++, idArticle);
            n = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch (Exception ignore) {}
        }
        return n;
    }
}
