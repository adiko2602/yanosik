package dao.user;

import models.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    private List<User> users = new ArrayList<>();

    public UserDao() {
        this.users.add(new User(1, "Adus", "adi", "12345678"));
        this.users.add(new User(2, "Basia", "basia", "12345678"));
        this.users.add(new User(3, "Mis", "mis", "12345678"));
    }
    @Override
    public User get(long userId) {
        for(User user: users) {
            if(user.getId() == userId) return user;
        }
        return null;
    }
    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void update(User user) {
        users.forEach(u -> {
            if (u.getId() == user.getId()) {
                u.setLogin(user.getLogin());
                u.setNick(user.getNick());
                u.setPassword(user.getPassword());
            }
        });
    }

    @Override
    public void delete(long userId) {
        users = users.stream().filter(user -> user.getId() != userId).toList();
    }
}
