package com.example.onlineaplication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public abstract class AbstractService<T> {
    private Class<T> entityClass;

    protected abstract EntityManager getEntityManager();

    public AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {getEntityManager().persist(entity);}

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity){
        if(!getEntityManager().contains(entity)){
            entity = getEntityManager().merge(entity);
        }
        getEntityManager().remove(entity);
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll(){
        CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(entityClass));
        return getEntityManager().createQuery(criteriaQuery).getResultList();
    }
}
