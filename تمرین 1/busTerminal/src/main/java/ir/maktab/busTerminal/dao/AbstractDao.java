package ir.maktab.busTerminal.dao;

import javax.persistence.EntityManager;


public abstract class AbstractDao<K,E> {
    protected EntityManager entityManager;

    public AbstractDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public E load(K id) {
        return entityManager.find(getEntityClass(),id);
    }

    public void save(E entity) {
        entityManager.persist(entity);
    }

    public void delete(E entity) {
        entityManager.remove(entity);
    }

    public void update(E entity) {
        entityManager.merge(entity);
    }

//    public CriteriaBuilder getCriteriaBuilder() {
//        return entityManager.getCriteriaBuilder();
//    }
//
//    public CriteriaQuery<E> getCriteriaQuery() {
//        return getCriteriaBuilder().createQuery(getEntityClass());
//    }
//
//    public List<E> loadAll() {
//        getCriteriaQuery().select(getCriteriaQuery().from(getEntityClass()));
//        TypedQuery<E> typedQuery = entityManager.createQuery(getCriteriaQuery());
//        return typedQuery.getResultList();
//    }
//
//    public Long count() {
//        CriteriaQuery<Long> query = getCriteriaBuilder().createQuery(Long.class);
//        Root<E> fromEntity = query.from(getEntityClass());
//        query.select(getCriteriaBuilder().count(fromEntity));
//        TypedQuery<Long> typedQuery = entityManager.createQuery(query);
//        return typedQuery.getSingleResult();
//    }

    public abstract Class<E> getEntityClass();
}
