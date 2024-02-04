package dao;

import java.util.List;

public interface IDao <T> {
    T get(long id);
    List<T> getAll();
    void save(T data);
    void update(T data);
    void delete(long id);
}
