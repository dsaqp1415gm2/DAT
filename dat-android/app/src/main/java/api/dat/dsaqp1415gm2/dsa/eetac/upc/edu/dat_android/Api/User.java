package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api;

/**
 * Created by Manel on 12/06/2015.
 */
public class User {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public boolean isLoginSuccesful() {
        return LoginSuccesful;
    }

    public void setLoginSuccesful(boolean loginSuccesful) {
        LoginSuccesful = loginSuccesful;
    }

    private boolean LoginSuccesful;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

}
