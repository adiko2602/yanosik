package models.user;

import java.sql.Timestamp;
import java.util.Date;

public class User implements IUser {
    private final long id;
    private String nick;
    private String login;
    private String password;
    private final Timestamp insertTime;

    public User(long id, String nick, String login, String password) {
        this.id = id;
        this.nick = nick;
        this.login = login;
        this.password = password;
        this.insertTime = new Timestamp(new Date().getTime());
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
