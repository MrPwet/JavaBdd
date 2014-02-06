package org.jbdd.pwet;

import java.sql.Connection;

/**
 * Created by mrpwet on 06/02/14.
 */
public class Test {

    public static void main(String[] args) {

        Connection conn = null;
        TableBuilder tb = null;

        try {
            conn = Singleton.DS.getConnection();
            tb = new TableBuilder(conn);

            tb.createAllTables();

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {conn.close();} catch(Exception ignore) {}
        }
    }
}
