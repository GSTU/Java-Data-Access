package com.nesterione.gstu.jdbc.DBL;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by igor on 12.10.2014.
 */
public interface Context<T> {

    /**
     * Используеться в Beans.xml
     * @param ds
     */
    void setDataSource(DataSource ds);

    List<T> getAll();
    T get(int id);
    void create(T entity);
    void remove(T entity);
    void update(T entity);
}
