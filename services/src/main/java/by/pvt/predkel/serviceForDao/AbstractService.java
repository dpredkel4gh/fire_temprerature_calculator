package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.constants.ServiceConstants;
import by.pvt.predkel.dao.DaoI;
import by.pvt.predkel.entities.Entity;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.exceptions.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractService<T extends Entity> implements IService<T> {
    private static Logger logger = Logger.getLogger(AbstractService.class);
    private DaoI<T> dao;

    @Autowired
    protected TransactionTemplate transactionTemplate;

    protected AbstractService(DaoI<T> dao) {
        this.dao = dao;
    }

    @Override
    public void delete(T entity) throws ServiceException {
        transactionTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus transactionStatus) {
                try {
                    dao.delete(entity);
                    logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
                    logger.info(ServiceConstants.MESSAGE_DELETE);
                } catch (DaoException e) {
                    logger.error(ServiceConstants.TRANSACTION_FAILED, e);
                    transactionStatus.setRollbackOnly();
                }
                return null;
            }
        });
    }

    @Override
    public List<T> getAll() throws ServiceException {
        return transactionTemplate.execute(new TransactionCallback<List<T>>() {
            @Override
            public List<T> doInTransaction(TransactionStatus transactionStatus) {
                List<T> list = new ArrayList<T>();
                try {
                    list = dao.getAll();
                    logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
                    logger.info(list);
                } catch (DaoException e) {
                    logger.error(ServiceConstants.TRANSACTION_FAILED, e);
                    transactionStatus.setRollbackOnly();
                }
                return list;
            }
        });
    }

    @Override
    public T getById(Long id) throws ServiceException {
        return transactionTemplate.execute(new TransactionCallback<T>() {
            @Override
            public T doInTransaction(TransactionStatus transactionStatus) {
                T entity = null;
                try {
                    entity = (T) dao.getById(id);
                    logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
                    logger.info(entity);
                } catch (DaoException e) {
                    logger.error(ServiceConstants.TRANSACTION_FAILED, e);
                    transactionStatus.setRollbackOnly();
                }
                return entity;
            }
        });

    }

    @Override
    public Serializable save(T entity) throws ServiceException {
        return transactionTemplate.execute(new TransactionCallback<Serializable>() {
            @Override
            public Serializable doInTransaction(TransactionStatus transactionStatus) {
                Serializable id = null;
                try {
                    id = dao.create(entity);
                    logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
                    logger.info(entity);
                } catch (DaoException e) {
                    logger.error(ServiceConstants.TRANSACTION_FAILED, e);
                    transactionStatus.setRollbackOnly();
                }
                return id;
            }
        });
    }

    @Override
    public void update(T entity) throws ServiceException {
        transactionTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus transactionStatus) {
                try {
                    dao.update(entity);
                    logger.info(ServiceConstants.TRANSACTION_SUCCEEDED);
                    logger.info(entity);
                } catch (DaoException e) {
                    logger.error(ServiceConstants.TRANSACTION_FAILED, e);
                    transactionStatus.setRollbackOnly();
                }
                return null;
            }
        });
    }
}
