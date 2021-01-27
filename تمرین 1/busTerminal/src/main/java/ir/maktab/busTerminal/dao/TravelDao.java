package ir.maktab.busTerminal.dao;

import ir.maktab.busTerminal.entities.Travel;

import javax.persistence.EntityManager;

public class TravelDao extends AbstractDao<Integer, Travel>{

    public TravelDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Travel> getEntityClass() {
        return Travel.class;
    }
}
