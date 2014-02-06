package org.jbdd.pwet;

import java.sql.Date;

/**
 * Created by mrpwet on 06/02/14.
 */
public class Commande {
    private int idCommande;
    private String username;
    private Date datecommande;
    private float prixCommande;

    public Commande(int idCommande, String username, Date datecommande, float prixCommande) {
        this.idCommande = idCommande;
        this.username = username;
        this.datecommande = datecommande;
        this.prixCommande = prixCommande;
    }

    public Commande(String username, Date datecommande, float prixCommande) {
        this.username = username;
        this.datecommande = datecommande;
        this.prixCommande = prixCommande;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public float getPrixCommande() {
        return prixCommande;
    }

    public void setPrixCommande(float prixCommande) {
        this.prixCommande = prixCommande;
    }
}
