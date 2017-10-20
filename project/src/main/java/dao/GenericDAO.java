package dao;

import java.util.List;

/**
 * GenericDAO<T>
 * Interface to every DAO implement
 * 
 * @author Gabriel Barzagli
 */
public interface GenericDAO<T> {

    void insert(T object);
    void update(T object);
    List<T> all();
    T findByKey(Long id);

}