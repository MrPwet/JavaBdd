package org.jbdd.pwet;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by mrpwet on 06/02/14.
 */
public class ClientManager {
    private Connection conn;

    public ClientManager(Connection conn) {
        this.conn = conn;
    }

    public int create(Client client) {
        int n = -1;
        PreparedStatement pstm = null;
        PanierManager pm = new PanierManager(conn);

        try {
            String sql = "insert into Client values(?,?,?);";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            int idPanier = pm.create();
            pstm.setString(i++,client.getUsername());
            pstm.setString(i++, client.getPassword());
            pstm.setInt(i++,idPanier);

            client.setIdPanier(idPanier);

            n = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstm.close();} catch (Exception ignore) {}
        }
        return n;
    }
}
