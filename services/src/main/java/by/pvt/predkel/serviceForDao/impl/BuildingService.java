package by.pvt.predkel.serviceForDao.impl;

import by.pvt.predkel.dao.IBuildingDao;
import by.pvt.predkel.entities.Building;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.serviceForDao.AbstractService;
import by.pvt.predkel.serviceForDao.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = DaoException.class)
public class BuildingService extends AbstractService<Building> implements IBuildingService {

    private IBuildingDao buildingDao;

    @Autowired
    public BuildingService(IBuildingDao buildingDao) {
        super(buildingDao);
        this.buildingDao = buildingDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Building getBuildingByFkAndName(Building building) throws DaoException {
        return buildingDao.isCreated(building);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Building> getAllByFk(Long userId) throws DaoException {
        return buildingDao.geAllByFk(userId);
    }

    //getById
//    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
//    public Building readBuilding(Long id) throws DaoException {
//        Building building = buildingDao.getById(id);
//        return building;
//    }
//
    //delete
//    @Transactional(propagation = Propagation.SUPPORTS)
//    public void deleteBuilding(Building building) throws DaoException {
//        buildingDao.delete(building);
//    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean addBuilding(Building building) throws DaoException {
        GregorianCalendar time = new GregorianCalendar();
        String buildingTime = (time.get(time.HOUR_OF_DAY) + ":" + time.get(time.MINUTE) + " " + time.get(time.DATE) + "-" + (time.get(time.MONTH) + 1) + "-" + time.get(time.YEAR));
        Boolean checker;

        Building build = buildingDao.isCreated(building);

        if (building.getId() != 0) {
            building.setDateOfBuilding("изм. " + buildingTime);
            buildingDao.update(building);
            checker = false;
        } else if (build != null) {
            building.setId(build.getId());
            building.setDateOfBuilding("изм. " + buildingTime);
            buildingDao.update(building);
            checker = false;
        } else {
            building.setDateOfBuilding("созд. " + buildingTime);
            buildingDao.create(building);
            checker = true;
        }

        return checker;
    }
}
