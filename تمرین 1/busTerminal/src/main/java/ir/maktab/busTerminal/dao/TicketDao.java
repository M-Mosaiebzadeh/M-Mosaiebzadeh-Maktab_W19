package ir.maktab.busTerminal.dao;

import ir.maktab.busTerminal.entities.Ticket;

import javax.persistence.EntityManager;

public class TicketDao extends AbstractDao<Integer, Ticket>{


    public TicketDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }

}
