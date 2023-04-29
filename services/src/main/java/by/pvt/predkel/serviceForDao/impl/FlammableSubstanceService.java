package by.pvt.predkel.serviceForDao.impl;

import by.pvt.predkel.dao.IFlammableSubstanceDao;
import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.serviceForDao.AbstractService;
import by.pvt.predkel.serviceForDao.IFlammableSubstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = DaoException.class)
public class FlammableSubstanceService extends AbstractService<FlammableSubstance> implements IFlammableSubstanceService {

    private IFlammableSubstanceDao flammableSubstanceDao;

    @Autowired
    public FlammableSubstanceService(IFlammableSubstanceDao flammableSubstanceDao) {
        super(flammableSubstanceDao);
        this.flammableSubstanceDao = flammableSubstanceDao;
    }

    //save
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void createSubstance(FlammableSubstance substance) throws DaoException {
        flammableSubstanceDao.create(substance);
    }
    //delete
//    public void deleteSubstance(FlammableSubstance substance) throws DaoException {
//        flammableSubstanceDao.delete(substance);
//    }
    //update
//    public void updateSubstance(FlammableSubstance substance) throws DaoException {
//        flammableSubstanceDao.update(substance);
//    }
    //getAll
//    public List<FlammableSubstance> getAllSubstances() throws DaoException {
//        List<FlammableSubstance> list = flammableSubstanceDao.getAll();
//        return list;
//    }
    //getById
//    public FlammableSubstance readSubstance(Long id) throws DaoException {
//        FlammableSubstance substance = flammableSubstanceDao.getById(id);
//        return substance;
//    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Long getCountOfSubstances() throws DaoException {
        return flammableSubstanceDao.getCountOfRows();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<FlammableSubstance> getSubstancesForPage(int page, int maxResult) throws DaoException {
        int firstResult = (page - 1) * maxResult;
        return flammableSubstanceDao.pagination(firstResult, maxResult);
    }


}
