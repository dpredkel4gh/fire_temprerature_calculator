package by.pvt.predkel.dao.impl;

import by.pvt.predkel.dao.DaoGeneral;
import by.pvt.predkel.dao.IUserDao;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.settings.ColumnName;
import by.pvt.predkel.utils.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends DaoGeneral<User> implements IUserDao {
    private String message;
    private User user = new User();

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User isAuthorized(String login, String password) throws DaoException {
        Session session;
        User user;
        try {
            session = getCurrentSession();
            Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq(ColumnName.USER_LOGIN, login));
            userCriteria.add(Restrictions.eq(ColumnName.USER_PASSWORD, password));
            user = (User) userCriteria.uniqueResult();
        } catch (Exception e) {
            message = "Unable to authorize user";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
        return user;
    }

    @Override
    public User getByLogin(String login) throws DaoException {
        Session session;
        User user;
        try {
            session = getCurrentSession();
            Criteria userCriteria = session.createCriteria(User.class);
            userCriteria.add(Restrictions.eq(ColumnName.USER_LOGIN, login));
            user = (User) userCriteria.uniqueResult();
        } catch (Exception e) {
            message = "Unable to get user by login";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
        return user;
    }

    @Override
    public Class getPersistentClass() {
        return user.getClass();
    }
}
