package Beans;

public class Users {

    private int IdUser;
    private String username;
    private String email;
    private String password;


    public Users(int IdUser, String username, String email, String password) {
        super();
        this.setIdUser(IdUser);
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Users(String username, String email, String password) {
        super();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int idUser) {
        IdUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
