package models.user;

import java.sql.Timestamp;

public interface IUser {
    // getters
    long getId();
    String getNick();
    String getLogin();
    String getPassword();
    Timestamp getInsertTime();

    // setters
    void setNick(String nick);
    void setLogin(String login);
    void setPassword(String password);
}
