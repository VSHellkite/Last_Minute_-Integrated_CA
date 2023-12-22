
package backend.models;
    
public class User{
    
    
    
    private Integer userid;
    private String userlogin;
    private String password;
    private String username;

    public User(Integer userid, String login, String password, String username) {
        this.userid = userid;
        this.userlogin = login;
        this.password = password;
        this.username = username;
    }

    public Integer getUserid() {
        return userid;
    }


    public void setUserid(Integer userid) {
        this.userid = userid;
    }


    public String getUserlogin() {
        return userlogin;
    }


    public void setUserlogin(String userlogin) {
        this.userlogin = userlogin;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userid + ", userlogin=" + userlogin + ", password=" + password + ", username=" + username + '}';
    }
    
}