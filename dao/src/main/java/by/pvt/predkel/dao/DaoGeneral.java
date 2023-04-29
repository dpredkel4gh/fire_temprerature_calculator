package by.pvt.predkel.dao;

import by.pvt.predkel.entities.Entity;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.utils.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class DaoGeneral<T extends Entity> implements DaoI<T> {
    private String message;
    private T entity;

    private SessionFactory sessionFactory;

    @Autowired
    public DaoGeneral(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T getById(long id) throws DaoException {
        Session session;
        T t;
        try {
            session = getCurrentSession();
            t = (T) session.load(getPersistentClass(), id);
        } catch (Exception e) {
            message = "Unable to get entity by id";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
        return t;
    }

    @Override
    public Serializable create(T t) throws DaoException {
        Session session;
        try {
            session = getCurrentSession();
            return session.save(t);
        } catch (Exception e) {
            message = "Unable to save entity";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
    }

    @Override
    public void update(T t) throws DaoException {
        Session session;
        try {
            session = getCurrentSession();
            session.update(t);
        } catch (Exception e) {
            message = "Unable to update entity";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
    }

    @Override
    public void delete(T t) throws DaoException {
        Session session;
        try {
            session = getCurrentSession();
            session.delete(t);
        } catch (Exception e) {
            message = "Unable to delete entity";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
    }

    @Override
    public List<T> getAll() throws DaoException {
        Session session;
        List<T> t;
        try {
            session = getCurrentSession();
            t = (List<T>) session.createCriteria(getPersistentClass()).list();
        } catch (NullPointerException e1) {
            return new ArrayList<>();
        } catch (Exception e) {
            message = "Unable to get all entities";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
        return t;
    }

    @Override
    public Long getCountOfRows() throws DaoException {
        Session session;
        try {
            session = getCurrentSession();
            return (Long) session.createCriteria(getPersistentClass())
                    .setProjection(Projections.rowCount())
                    .list()
                    .get(0);
        } catch (Exception e) {
            message = "Unable to get row count from table";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
    }

    @Override
    public List<T> pagination(int firstResult, int maxResult) throws DaoException {
        List<T> list;
        Session session;
        try {
            session = getCurrentSession();
            Criteria userCriteria = session.createCriteria(getPersistentClass());
            list = (List<T>) userCriteria.setFirstResult(firstResult).setMaxResults(maxResult).list();
        } catch (Exception e) {
            message = "Unable to get data for pagination";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
        return list;
    }

    @Override
    public Class getPersistentClass() {
        return entity.getClass();
    }
}
