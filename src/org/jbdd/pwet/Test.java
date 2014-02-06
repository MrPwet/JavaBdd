package org.jbdd.pwet;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mrpwet on 06/02/14.
 */
public class Test {

    public static void main(String[] args) {

        Connection conn = null;
        TableBuilder tb = null;
        ArticleManager am = null;

        try {
            conn = Singleton.DS.getConnection();
            tb = new TableBuilder(conn);

            tb.createAllTables();

            //Création des articles
            am = new ArticleManager(conn);

            Article reflex = new Article("Reflex numérique", new BigDecimal(1600), 2, "appareils photo");
            am.create(reflex);

            Article kitReflex = new Article("Kit Reflex numérique + 18-55mm", new BigDecimal(530), 1, "appareils photo");
            am.create(kitReflex);

            Article zoom = new Article("Zoom 24-105 mm f/4", new BigDecimal(748), 5, "objectif / zoom");
            am.create(zoom);

            Article objectif = new Article("Objectif 85mm f/1.8", new BigDecimal(354.90), 1, "objectif / zoom");
            am.create(objectif);

            Article filtre = new Article("Filtre", new BigDecimal(17.80), 17, "objectif / zoom");
            am.create(filtre);

            //Afficher les articles par prix croissant
            List<Article> lstArticle = am.readAllByPrix();
            Iterator<Article> it = lstArticle.iterator();
            while(it.hasNext()) {
                System.out.println(it.next());
            }

            //Création du panier pour le client 1;
            ClientManager cm = new ClientManager(conn);
            Client user1 = new Client("user1", "machin");
            cm.create(user1);
            PanierManager pm = new PanierManager(conn);
            pm.addArticle(user1.getIdPanier(), kitReflex.getIdArticle(), 1);
            pm.addArticle(user1.getIdPanier(), filtre.getIdArticle(), 2);
            pm.addArticle(user1.getIdPanier(), objectif.getIdArticle(), 1);

            //Création du panier pour le client 2
            Client user2 = new Client("user2", "chose");
            cm.create(user2);
            pm.addArticle(user2.getIdPanier(), reflex.getIdArticle(),1);
            pm.addArticle(user2.getIdPanier(), zoom.getIdArticle(), 1);
            pm.addArticle(user2.getIdPanier(), objectif.getIdArticle(),1);
            pm.addArticle(user2.getIdPanier(), filtre.getIdArticle(),2);
            pm.update(user2.getIdPanier(), reflex.getIdArticle(), 2);
            pm.delete(user2.getIdPanier(), filtre.getIdArticle());

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {conn.close();} catch(Exception ignore) {}
        }
    }
}
