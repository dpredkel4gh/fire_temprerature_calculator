package by.pvt.predkel.dao;

import by.pvt.predkel.entities.Entity;
import by.pvt.predkel.exceptions.DaoException;

import java.io.Serializable;
import java.util.List;

public interface DaoI<T extends Entity> {

    T getById(long id) throws DaoException;

    Serializable create(T entity) throws DaoException;

    void update(T entity) throws DaoException;

    void delete(T entity) throws DaoException;

    List<T> getAll() throws DaoException;

    Long getCountOfRows() throws DaoException;

    List<T> pagination(int firstResult, int maxResult) throws DaoException;

    Class getPersistentClass();

}
