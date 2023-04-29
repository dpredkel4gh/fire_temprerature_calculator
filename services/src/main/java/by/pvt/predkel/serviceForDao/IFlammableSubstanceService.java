package by.pvt.predkel.serviceForDao;

import by.pvt.predkel.entities.FlammableSubstance;
import by.pvt.predkel.exceptions.DaoException;

import java.util.List;

public interface IFlammableSubstanceService extends IService<FlammableSubstance> {
    public void createSubstance(FlammableSubstance substance) throws DaoException;

    Long getCountOfSubstances() throws DaoException;

    List<FlammableSubstance> getSubstancesForPage(int page, int maxResult) throws DaoException;
}
