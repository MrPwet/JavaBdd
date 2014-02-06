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
public class ArticleManager {
    private Connection conn;

    public ArticleManager(Connection conn) {
        this.conn = conn;
    }

    public int create(Article article) {
        int n = -1;
        PreparedStatement pstm = null;

        try {
            String sql = "insert into Article values(null,?,?,?,?);";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setString(i++,article.getNomArticle());
            pstm.setBigDecimal(i++, article.getPrixArticle());
            pstm.setInt(i++,article.getDispArticle());
            pstm.setString(i++,article.getCategorie());

            n = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch (Exception ignore) {}
        }
        return n;
    }


    public List<Article> readAll() {
        int n = -1;
        Statement stm = null;
        ResultSet rset = null;
        List<Article> lstArticle = new ArrayList<Article>();

        try {
            String sql = "select idArticle, nomArticle, prixArticle, dispArticle, categorie from Article;";
            stm = conn.prepareStatement(sql);

            rset = stm.executeQuery(sql);

            while(rset.next()) {
                lstArticle.add(new Article(rset.getInt(1), rset.getString(2), rset.getBigDecimal(3), rset.getInt(4), rset.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm.close();} catch (Exception ignore) {}
        }
        return lstArticle;
    }

    public List<Article> readAllByPrix() {
        int n = -1;
        Statement stm = null;
        ResultSet rset = null;
        List<Article> lstArticle = new ArrayList<Article>();

        try {
            String sql = "select idArticle, nomArticle, prixArticle, dispArticle, categorie from Article order by prixArticle;";
            stm = conn.prepareStatement(sql);

            rset = stm.executeQuery(sql);

            while(rset.next()) {
                lstArticle.add(new Article(rset.getInt(1), rset.getString(2), rset.getBigDecimal(3), rset.getInt(4), rset.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm.close();} catch (Exception ignore) {}
        }
        return lstArticle;
    }
}
