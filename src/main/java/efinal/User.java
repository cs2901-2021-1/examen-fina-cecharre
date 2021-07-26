package efinal;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isUser(){
        StringBuilder pass = new StringBuilder(password).reverse();
        return username.equals(pass.toString());
    }
}
