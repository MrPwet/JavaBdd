package org.jbdd.pwet;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by mrpwet on 06/02/14.
 */
public class TableBuilder {

    private Connection conn;

    public TableBuilder(Connection conn) {
        this.conn = conn;
    }

    public int createArticles() {
        int n = -1;

        Statement stm2 = null;

        try {
            String sql2 = "create table if not exists Article (" +
                    "idArticle int not null auto_increment," +
                    "nomArticle varchar(100) not null," +
                    "prixArticle float not null," +
                    "dispArticle int not null," +
                    "categorie varchar(100) not null," +
                    "primary key (idArticle));";
            stm2 = conn.createStatement();
            n = stm2.executeUpdate(sql2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm2.close();} catch (Exception ignore) {}
        }
        return n;
    }

    public int dropArticles() {
        int n = -1;
        Statement stm1 = null;

        try {
            String sql1 = "drop table if exists Article;";
            stm1 = conn.createStatement();
            n = stm1.executeUpdate(sql1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm1.close();} catch (Exception ignore) {}
        }
        return n;
    }

    public int createClient() {
        int n = -1;
        Statement stm2 = null;

        try {
            String sql2 = "create table if not exists Client (" +
                    "username varchar(100) not null," +
                    "password varchar(100) not null," +
                    "idPanier int not null," +
                    "foreign key (idPanier) references Panier(idPanier)," +
                    "primary key (username));";
            stm2 = conn.createStatement();
            n += stm2.executeUpdate(sql2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm2.close();} catch (Exception ignore) {}
        }
        return n;
    }

    public int dropClient() {
        int n = -1;
        Statement stm1 = null;

        try {
            String sql1 = "drop table if exists Client;";
            stm1 = conn.createStatement();
            n = stm1.executeUpdate(sql1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm1.close();} catch (Exception ignore) {}
        }
        return n;
    }


    public int createCommande() {
        int n = -1;
        Statement stm2 = null;

        try {
            String sql2 = "create table if not exists Commande (" +
                    "idCommande int not null auto_increment," +
                    "username varchar(100) not null," +
                    "dateCommande date not null," +
                    "prixCommande float not null," +
                    "foreign key (username) references Client(username)," +
                    "primary key (idCommande));";
            stm2 = conn.createStatement();
            n = stm2.executeUpdate(sql2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm2.close();} catch (Exception ignore) {}
        }
        return n;
    }

    public int dropCommande() {
        int n = -1;
        Statement stm1 = null;

        try {
            String sql1 = "drop table if exists Commande;";
            stm1 = conn.createStatement();
            n = stm1.executeUpdate(sql1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm1.close();} catch (Exception ignore) {}
        }
        return n;
    }

    public int createComporte() {
        int n = -1;
        Statement stm2 = null;

        try {
            String sql2 = "create table if not exists Comporte (" +
                    "idPanier int not null," +
                    "idArticle int not null," +
                    "quantite int not null," +
                    "foreign key (idPanier) references Panier(idPanier)," +
                    "foreign key (idArticle) references Article(idArticle)," +
                    "primary key (idPanier,idArticle));";
            stm2 = conn.createStatement();
            n += stm2.executeUpdate(sql2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm2.close();} catch (Exception ignore) {}
        }
        return n;
    }

    public int dropComporte() {
        int n = -1;
        Statement stm1 = null;

        try {
            String sql1 = "drop table if exists Comporte;";
            stm1 = conn.createStatement();
            n = stm1.executeUpdate(sql1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm1.close();} catch (Exception ignore) {}
        }
        return n;
    }

    public int createConcerne() {
        int n = -1;
        Statement stm2 = null;

        try {
            String sql2 = "create table if not exists Concerne (" +
                    "idCommande int not null," +
                    "idArticle int not null," +
                    "quantite int not null," +
                    "foreign key (idCommande) references Commande(idCommande)," +
                    "foreign key (idArticle) references Article(idArticle)," +
                    "primary key (idCommande,idArticle));";
            stm2 = conn.createStatement();
            n += stm2.executeUpdate(sql2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm2.close();} catch (Exception ignore) {}
        }
        return n;
    }

    public int dropConcerne() {
        int n = -1;
        Statement stm1 = null;

        try {
            String sql1 = "drop table if exists Concerne;";
            stm1 = conn.createStatement();
            n = stm1.executeUpdate(sql1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm1.close();} catch (Exception ignore) {}
        }
        return n;
    }

    public int createPanier() {
        int n = -1;
        Statement stm2 = null;

        try {
            String sql2 = "create table if not exists Panier (" +
                    "idPanier int not null auto_increment," +
                    "primary key (idPanier));";
            stm2 = conn.createStatement();
            n = stm2.executeUpdate(sql2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm2.close();} catch (Exception ignore) {}
        }
        return n;
    }

    public int dropPanier() {
        int n = -1;
        Statement stm1 = null;

        try {
            String sql1 = "drop table if exists Panier;";
            stm1 = conn.createStatement();
            n = stm1.executeUpdate(sql1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {stm1.close();} catch (Exception ignore) {}
        }
        return n;
    }


    public void createAllTables() {
        dropConcerne();
        dropComporte();
        dropArticles();
        dropCommande();
        dropClient();
        dropPanier();

        createArticles();
        createPanier();
        createClient();
        createComporte();
        createCommande();
        createConcerne();
    }
}
