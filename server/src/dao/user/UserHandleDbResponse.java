package dao.user;

import models.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserHandleDbResponse {
    public static User handleResponse(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String nick = resultSet.getString("nick");
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        Timestamp insertTime = resultSet.getTimestamp("insert_time");

        return new User(id, nick, login, password, insertTime);
    }
}
