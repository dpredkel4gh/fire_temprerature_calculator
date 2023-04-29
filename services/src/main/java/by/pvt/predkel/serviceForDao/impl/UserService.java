package by.pvt.predkel.serviceForDao.impl;

import by.pvt.predkel.dao.IUserDao;
import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.serviceForDao.AbstractService;
import by.pvt.predkel.serviceForDao.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = DaoException.class)
public class UserService extends AbstractService<User> implements IUserService {

    private IUserDao userDao;

    @Autowired
    public UserService(IUserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    @Override
    public boolean registerUser(User user) throws DaoException {
        if (userDao.getByLogin(user.getLogin()) == null) {
            userDao.create(user);
            return true;
        } else
            return false;
    }

    @Override
    public boolean deleteUser(String login) throws DaoException {
        User user = userDao.getByLogin(login);
        if (user != null) {
            userDao.delete(user);
            return true;
        } else
            return false;
    }

    @Override
    public User getByLogin(String login) throws DaoException {
        return userDao.getByLogin(login);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public User loginUser(String login, String password) throws DaoException {
        return userDao.isAuthorized(login, password);
    }
}
