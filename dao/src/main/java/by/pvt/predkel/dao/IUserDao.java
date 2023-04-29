package by.pvt.predkel.dao;

import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;

public interface IUserDao extends DaoI<User> {
    User isAuthorized(String login, String password) throws DaoException;

    User getByLogin(String login) throws DaoException;
}
