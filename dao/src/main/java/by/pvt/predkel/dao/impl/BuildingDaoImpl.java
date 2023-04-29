package by.pvt.predkel.dao.impl;

import by.pvt.predkel.dao.DaoGeneral;
import by.pvt.predkel.dao.IBuildingDao;
import by.pvt.predkel.entities.Building;
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

import java.io.Serializable;
import java.util.List;

@Repository
public class BuildingDaoImpl extends DaoGeneral<Building> implements IBuildingDao {
    private String message;
    private Building building = new Building();

    @Autowired
    public BuildingDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void delete(Building building) throws DaoException {
        Session session;
        try {
            session = getCurrentSession();
            User user = (User) session.load(User.class, building.getUserId());
            building.setUser(user);
            session.delete(building);
        } catch (Exception e) {
            message = "Unable to update building";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
    }

    @Override
    public void update(Building building) throws DaoException {
        Session session;
        try {
            session = getCurrentSession();
            User user = (User) session.load(User.class, building.getUserId());
            building.setUser(user);
            session.merge(building);
        } catch (Exception e) {
            message = "Unable to update building";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
    }

    @Override
    public Serializable create(Building building) throws DaoException {
        Session session;
        try {
            session = getCurrentSession();//напрямую нельзя добавить здание
            //т.к. оно зависит от юзера
            User user = (User) session.load(User.class, building.getUserId());//поэтому достаем (прокси) юзера
            user.getBuilding().add(building);// добавляем ему здание
            session.update(user);// и сохраняем юзера
        } catch (Exception e) {
            message = "Unable to save building";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
        return null;
    }

    @Override
    public Building isCreated(Building entity) throws DaoException {
        Session session;
        Building building;
        try {
            session = getCurrentSession();
            Criteria userCriteria = session.createCriteria(getPersistentClass());
            userCriteria.add(Restrictions.eq(ColumnName.BUILDING_FK_ID_USER, entity.getUserId()));
            userCriteria.add(Restrictions.eq(ColumnName.BUILDING_NAME, entity.getNameOfBuilding()));
            building = (Building) userCriteria.uniqueResult();
        } catch (Exception e) {
            message = "Unable to get building by name and foreign key";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
        return building;
    }

    @Override
    public List<Building> geAllByFk(Long userId) throws DaoException {
        Session session;
        List<Building> buildings;
        try {
            session = getCurrentSession();
            Criteria userCriteria = session.createCriteria(getPersistentClass());
            userCriteria.add(Restrictions.eq(ColumnName.BUILDING_FK_ID_USER, userId));
            buildings = (List<Building>) userCriteria.list();
        } catch (Exception e) {
            message = "Unable to get building by foreign key";
            Logger.getInstance().logError(getClass(), message);
            throw new DaoException(message, e);
        }
        return buildings;
    }

    @Override
    public Class getPersistentClass() {
        return building.getClass();
    }
}
