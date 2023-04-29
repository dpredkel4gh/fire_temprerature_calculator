package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.entities.Building;
import by.pvt.predkel.exceptions.DaoException;

import java.util.List;

public interface IBuildingService extends IService<Building> {
    Building getBuildingByFkAndName(Building building) throws DaoException;

    List<Building> getAllByFk(Long userId) throws DaoException;

    boolean addBuilding(Building building) throws DaoException;
}
