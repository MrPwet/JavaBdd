package org.jbdd.pwet;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;

/**
 * Created by mrpwet on 06/02/14.
 */
public class Singleton {
    public static final String JBDC_DRIVER = "org.mariadb.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:mariadb://localhost:3306/JavaBdd";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final DataSource DS = new BasicDataSource();

    static {
        BasicDataSource ds = (BasicDataSource) DS;
        ds.setDriverClassName(JBDC_DRIVER);
        ds.setUsername(USERNAME);
        ds.setPassword(PASSWORD);
        ds.setUrl(JDBC_URL);
        ds.setDefaultAutoCommit(false);
        ds.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
    }
}
