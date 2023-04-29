package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;

public interface IUserService extends IService<User> {
    boolean registerUser(User user) throws DaoException;

    boolean deleteUser(String login) throws DaoException;

    User getByLogin(String login) throws DaoException;

    User loginUser(String login, String password) throws DaoException;
}
