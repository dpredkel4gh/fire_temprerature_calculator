package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.exceptions.ServiceException;

import java.io.Serializable;
import java.util.List;

public interface IService<T> {
    void delete(T entity) throws ServiceException;

    List<T> getAll() throws ServiceException;

    T getById(Long id) throws ServiceException;

    Serializable save(T entity) throws ServiceException;

    void update(T entity) throws ServiceException;
}
