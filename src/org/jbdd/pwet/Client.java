package org.jbdd.pwet;

/**
 * Created by mrpwet on 06/02/14.
 */
public class Client {
    private String username;
    private String password;
    private int idPanier;

    public Client(String username, String password) {
        this.username = username;
        this.password = password;
        this.idPanier = 0;
    }

    public Client(String username, String password, int idPanier) {
        this.username = username;
        this.password = password;
        this.idPanier = idPanier;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
