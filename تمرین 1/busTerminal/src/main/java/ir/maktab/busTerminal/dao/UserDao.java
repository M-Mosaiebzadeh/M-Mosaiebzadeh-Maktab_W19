package ir.maktab.busTerminal.dao;

import ir.maktab.busTerminal.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao extends AbstractDao<Integer, User>{

    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    public List<User> loadUserByUsername(String username) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> fromUser = query.from(User.class);

        query.select(fromUser).where(builder.equal(fromUser.get("username"),username));
        TypedQuery<User> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }
}
