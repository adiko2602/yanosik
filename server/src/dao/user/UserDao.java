package dao.user;

import database.DatabaseConnection;
import models.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    private final Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }
    @Override
    public User get(long userId) {
        User user = null;
        try {
            String sql = "SELECT * FROM users WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setLong(1, userId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Process ResultSet and populate the User object
                    if (resultSet.next()) {
                        long id = resultSet.getLong("id");
                        String nick = resultSet.getString("nick");
                        String login = resultSet.getString("login");
                        String password = resultSet.getString("password");
                        Timestamp insertTime = resultSet.getTimestamp("insert_time");

                        user = new User(id, nick, login, password, insertTime);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM users";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        users.add(UserHandleDbResponse.handleResponse(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public void save(User user) {
        try {
            String sql = "INSERT INTO users (nick, login, password) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, user.getNick());
                preparedStatement.setString(2, user.getLogin());
                preparedStatement.setString(3, user.getPassword());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        // TODO Connect to db and update user
    }

    @Override
    public void delete(long userId) {
        // TODO Connect to db and remove user
    }
}
