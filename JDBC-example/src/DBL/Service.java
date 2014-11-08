package DBL;

import java.util.List;

/**
 * Created by igor on 12.10.2014.
 */
public interface Service<T> {
    List<T> getAll();
    T get(int id);
    void create(T entity);
    void remove(T entity);
    void update(T entity);
}
