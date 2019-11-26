/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;


/**
 *
 * @author luis
 */
public class Login_MB {
    private String email;
    private String password;
    private int nvl_user;

    public Login_MB() {
    }

    public Login_MB(String username, String password, int nvl_user) {
        this.email = username;
        this.password = password;
        this.nvl_user = nvl_user;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return email;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.email = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the nvl_user
     */
    public int getNvl() {
        return nvl_user;
    }

    /**
     * @param nvl_user the nvl_user to set
     */
    public void setNvl(int nvl_user) {
        this.nvl_user = nvl_user;
    }
    
    
}
