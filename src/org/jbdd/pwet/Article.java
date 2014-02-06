package org.jbdd.pwet;

import java.math.BigDecimal;

/**
 * Created by mrpwet on 06/02/14.
 */
public class Article {
    int idArticle;
    String nomArticle;
    BigDecimal prixArticle;
    int dispArticle;
    String categorie;

    public Article(String nomArticle, BigDecimal prixArticle, int dispArticle, String categorie)
    {
        this.idArticle = 0;
        this.nomArticle = nomArticle;
        this.prixArticle = prixArticle;
        this.dispArticle = dispArticle;
        this.categorie = categorie;
    }

    public Article(int idArticle, String nomArticle, BigDecimal prixArticle, int dispArticle, String categorie)
    {
        this.idArticle = idArticle;
        this.nomArticle = nomArticle;
        this.prixArticle = prixArticle;
        this.dispArticle = dispArticle;
        this.categorie = categorie;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public BigDecimal getPrixArticle() {
        return prixArticle;
    }

    public void setPrixArticle(BigDecimal prixArticle) {
        this.prixArticle = prixArticle;
    }

    public int getDispArticle() {
        return dispArticle;
    }

    public void setDispArticle(int dispArticle) {
        this.dispArticle = dispArticle;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String toString() {
        return idArticle + " " + nomArticle + " " + prixArticle + " " + dispArticle + " " + categorie;
    }
}
