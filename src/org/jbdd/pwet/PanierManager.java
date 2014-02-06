package org.jbdd.pwet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public List<List<Object>> readAll(int idPanier) {
        PreparedStatement pstm = null;
        ResultSet rset = null;
        List<List<Object>> lst = new ArrayList<List<Object>>();

        try {
            String sql = "select C.idArticle, A.nomArticle, A.prixArticle,A.dispArticle,A.categorie, C.quantite, (A.prixArticle*C.quantite) " +
                    "from Article A, Comporte C, Panier P " +
                    "where A.idArticle=C.idArticle " +
                    "and P.idPanier=C.idPanier " +
                    "and C.idPanier=?;";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setInt(i++, idPanier);
            rset = pstm.executeQuery();
            while(rset.next()) {
                List<Object> lstemp = new ArrayList<Object>();
                lstemp.add(new Article(rset.getInt(1), rset.getString(2), rset.getBigDecimal(3), rset.getInt(4), rset.getString(5)));
                lstemp.add(rset.getInt(6));
                lstemp.add(rset.getFloat(7));
                lst.add(lstemp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch (Exception ignore) {}
        }
        return lst;
    }

    public int cleanPanier(int idPanier) {
        int n = -1;
        PreparedStatement pstm = null;

        try {
            String sql = "delete from Comporte where idPanier=?";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setInt(i++, idPanier);
            n = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch (Exception ignore) {}
        }
        return n;
    }
}
