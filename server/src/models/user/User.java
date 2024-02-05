package models.user;

import java.sql.Timestamp;

public class User implements IUser {
    private final long id;
    private String nick;
    private String login;
    private String password;
    private final Timestamp insertTime;

    public User(String nick, String login, String password) {
        this.id = -1;
        this.nick = nick;
        this.login = login;
        this.password = password;
        this.insertTime = null;
    }

    public User(long id, String nick, String login, String password, Timestamp insertTime) {
        this.id = id;
        this.nick = nick;
        this.login = login;
        this.password = password;
        this.insertTime = insertTime;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getNick() {
        return nick;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public Timestamp getInsertTime() {
        return insertTime;
    }

    @Override
    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
